package com.controllers;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.MessageDigest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dao.CalllogDao;
import com.dao.UserRepo;
import com.dao.UserSessionDao;
import com.model.CalllogPOJO;
import com.model.User;
import com.model.UserSessions;
import com.utility.Calljitsitoken;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@RestController
@RequestMapping("/calllog/")
public class CalllogController {
	@Autowired
	UserRepo userRepo;
	@Autowired
	CalllogDao calllogDao;
	@Autowired
	UserSessionDao userSessionDao;

	@RequestMapping(value = "/done", method = RequestMethod.GET)
	public String done() {
		return "done";
	}

	@RequestMapping(value = "/sendpacket", method = RequestMethod.POST)
	public void sendPacket(@RequestParam("email") String email, @RequestParam("id") String callid,
			@RequestParam("flag") String flag, @RequestParam("conversation_id") String conversation_id,
			@RequestParam("sessionid") String sessionid, @RequestParam("call_status") String callStatus) {
		String teamname = "";
		Date date = new Date(Calendar.getInstance().getTimeInMillis());
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String calldate = dateFormat.format(date);
		List<CalllogPOJO> calllogList = null;
		String intiatorName = "";
		UserSessions clientSession = userSessionDao.getAllActiveSymmetricKey(sessionid, email).get(0);
		User sessionUser = userRepo.findByEmail(clientSession.getEmail());
		if (flag.equals("onetoone")) {
			teamname = "onetoone";
			String[] users = conversation_id.split("_");
			// check the call first
			Integer callMax = calllogDao.getCallLogMaxByCallId(callid, calldate);
			Integer max = callMax == null ? 0 : callMax;
			if (callStatus.equals("100")) {
				// callstatus 100 means he is trying to initiate call
				// we should check if the call is active or not?
				// if active don't create the call,else create the call

				calllogList = calllogDao.getCallLogByCallDataId(callid, calldate, String.valueOf(max));
				if (calllogList.isEmpty()) {
					// Create callpojo
					for (int n = 0; n < users.length; n++) {
						Boolean isModerator = false;
						User user = userRepo.findByExtension(users[n]);
						if (users[n].equals(sessionUser.getExtension()) && callStatus.equals("100")) {
							isModerator = true;
							intiatorName = user.getFirstName() + " " + user.getLastName();
						}

						Calljitsitoken calljitsitoken = new Calljitsitoken(user.getExtension(),
								user.getImageUrl() + "?sessionid=" + "12345" + "&isthumb=1",
								user.getExtension() + "@melp.com", user.getFirstName(), md5(conversation_id), teamname,
								12 * 60 * 60 * 1000l, "", "", isModerator);

						CalllogPOJO callLog = new CalllogPOJO();
						String accesstoken = createJWT(calljitsitoken);
						callLog.setAccesstoken(accesstoken);
						callLog.setCallstatus(isModerator == true ? "202" : "100");
						callLog.setCallid(callid);
						callLog.setCalldate(calldate);
						callLog.setCalldataid("1");
						callLog.setInitiatorname(intiatorName);
						callLog.setUser(users[n]);
						calllogDao.save(callLog);
					}
				} else {
					calllogList = calllogDao.getActiveCallLogByCallStatus(callid, calldate, String.valueOf(max));
					// check whether another call is going or not,
					// if call is inactive create call else do nothing,but inform client that call
					// is already going
				}
			} else if (!callStatus.equals("100")) {
				CalllogPOJO callLog = calllogDao.getCallLogByUserId(callid, calldate, String.valueOf(max), "");
				callLog.setCallstatus(callStatus);
				calllogDao.save(callLog);
			}

		} else if (flag.equals("grp_topic")) {

		}
	}

	public static String md5(String input) {
		String md5 = null;
		if (null == input)
			return null;
		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD5");
			// Update input string in message digest
			digest.update(input.getBytes(), 0, input.length());
			// Converts message digest value in base 16 (hex)
			md5 = new BigInteger(1, digest.digest()).toString(16);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return md5;
	}

	public static String createJWT(Calljitsitoken calljitsi) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();

		Key signingKey = Keys.hmacShaKeyFor(
				"melp$12345@67890@sysmind123098dasdkhaskdhi1354789963#%@$!oia".getBytes(StandardCharsets.UTF_8));

		Map<String, Object> payload = new HashMap<String, Object>() {
			{
				put("aud", "melp_conf");
				put("iat", System.currentTimeMillis() / 1000);
				put("moderator", calljitsi.getModerator());
				put("sub", "meet.melpapp.com");

				put("room", calljitsi.getRoom());
				put("iss", "melp_conf_8");
				put("context", new HashMap() {
					{
						put("user", new HashMap() {
							{
								put("email", calljitsi.getEmail());
								put("name", calljitsi.getUsername());
								put("id", calljitsi.getCallid());
								put("avatar", calljitsi.getAvatar());
							}
						});
						put("callee", new HashMap() {
							{
								put("email", "");
								put("name", calljitsi.getCalleename());
								put("id", calljitsi.getCallid());
								put("avatar", calljitsi.getCalleeavatar());
							}
						});
						put("group", calljitsi.getGroupname());
					}
				});
			}
		};

		JwtBuilder builder = Jwts.builder().addClaims(payload).setHeaderParam("typ", "JWT").signWith(signingKey,
				signatureAlgorithm);

		if (calljitsi.getTtlMillis() >= 0) {
			long expMillis = nowMillis + calljitsi.getTtlMillis();
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		return builder.compact();
	}
}
