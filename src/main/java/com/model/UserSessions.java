package com.model;

import java.util.Calendar;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("device_session_details1")
public class UserSessions {

	@PrimaryKey
	private String id;
	
	private String deviceid="";
	private String sessionid="";
	private String devicetoken="";
	private String devicevoipid="";
	private String devicevoipisactive="1";
	
	private String devicetype="";
	private String ipaddress="";
	private String devicedetails="";
	private String clientpubkey="";
	private long notificationofftill=0l;
	private String melpid="";
	private String melpidencrypted="";
	private String email="";
	private String emailencrypted="";
	private String serverpubkey="";
	private String serverpvtkey="";
	private String symmetricKey="";
	private String isactive="N";
	private long  create_date = Calendar.getInstance().getTimeInMillis();
	private long  modi_date=Calendar.getInstance().getTimeInMillis();
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public String getDeviceid() {
		return deviceid;
	}
	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}
	public String getDevicetoken() {
		return devicetoken;
	}
	public void setDevicetoken(String devicetoken) {
		this.devicetoken = devicetoken;
	}
	public String getDevicetype() {
		return devicetype;
	}
	public void setDevicetype(String devicetype) {
		this.devicetype = devicetype;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getDevicedetails() {
		return devicedetails;
	}
	public void setDevicedetails(String devicedetails) {
		this.devicedetails = devicedetails;
	}
	public String getClientpubkey() {
		return clientpubkey;
	}
	public void setClientpubkey(String clientpubkey) {
		this.clientpubkey = clientpubkey;
	}
	public String getServerpubkey() {
		return serverpubkey;
	}
	public void setServerpubkey(String serverpubkey) {
		this.serverpubkey = serverpubkey;
	}
	public String getServerpvtkey() {
		return serverpvtkey;
	}
	public void setServerpvtkey(String serverpvtkey) {
		this.serverpvtkey = serverpvtkey;
	}
	public String getSymmetricKey() {
		return symmetricKey;
	}
	public void setSymmetricKey(String symmetricKey) {
		this.symmetricKey = symmetricKey;
	}
	public String getIsactive() {
		return isactive;
	}
	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}
	public long getCreate_date() {
		return create_date;
	}
	public void setCreate_date(long create_date) {
		this.create_date = create_date;
	}
	public long getModi_date() {
		return modi_date;
	}
	public void setModi_date(long modi_date) {
		this.modi_date = modi_date;
	}
	
	public String getDevicevoipid() {
		return devicevoipid;
	}
	public void setDevicevoipid(String devicevoipid) {
		this.devicevoipid = devicevoipid;
	}
	public String getMelpid() {
		return melpid;
	}
	public void setMelpid(String melpid) {
		this.melpid = melpid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getNotificationofftill() {
		return notificationofftill;
	}
	public void setNotificationofftill(long notificationofftill) {
		this.notificationofftill = notificationofftill;
	}
	public String getMelpidencrypted() {
		return melpidencrypted;
	}
	public void setMelpidencrypted(String melpidencrypted) {
		this.melpidencrypted = melpidencrypted;
	}
	public String getEmailencrypted() {
		return emailencrypted;
	}
	public void setEmailencrypted(String emailencrypted) {
		this.emailencrypted = emailencrypted;
	}
	public String getDevicevoipisactive() {
		return devicevoipisactive;
	}
	public void setDevicevoipisactive(String devicevoipisactive) {
		this.devicevoipisactive = devicevoipisactive;
	}
	
	
	
    
	

}


	