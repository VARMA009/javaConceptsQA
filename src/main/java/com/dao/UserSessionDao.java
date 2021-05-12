package com.dao;

import java.util.List;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.model.UserSessions;

@Repository("userSessionDao")
public interface UserSessionDao extends CrudRepository<UserSessions, String> {

	@Query("Select * from device_session_details1 where deviceid=:deviceid and sessionid=:sessionid limit 1 ALLOW FILTERING")
	UserSessions getSessionByDeviceIdAndSessionId(@Param("deviceid") String deviceid,
			@Param("sessionid") String sessionid);

	@Query("Select * from device_session_details1 where sessionid=:sessionid and emailid=:emailid ALLOW FILTERING")
	UserSessions getSessionByIdAndEmail(@Param("sessionid") String sessionid, @Param("emailid") String emailid);

	@Query("Select * from device_session_details1 where sessionid=:sessionid limit 1 ALLOW FILTERING")
	UserSessions getSymmetricKey(@Param("sessionid") String sessionid);

	@Query("Select * from device_session_details1 where sessionid=:sessionid  and isactive='Y' limit 1 ALLOW FILTERING")
	UserSessions getActiveSymmetricKey(@Param("sessionid") String sessionid);

	@Query("Select * from device_session_details1 where deviceid=:deviceid ALLOW FILTERING")
	UserSessions getSessionByDeviceId(@Param("deviceid") String deviceid);

	@Query("Select * from device_session_details1 where deviceid=:deviceid and isactive='Y'  ALLOW FILTERING")
	List<UserSessions> getdevicetokenDeviceId(@Param("deviceid") String deviceid);

	@Query("Select * from device_session_details1 where melpid=:melpid and notificationofftill<:millisecond ALLOW FILTERING")
	List<UserSessions> getusersessionbymelpid(@Param("melpid") String melpid, @Param("millisecond") long millisecond);

	@Query("Select * from device_session_details1 where email=:email and notificationofftill<:millisecond ALLOW FILTERING")
	List<UserSessions> getusersessionbyemail(@Param("email") String email, @Param("millisecond") long millisecond);

	@Query("Select * from device_session_details1 where email=:email and deviceid=:deviceid ALLOW FILTERING")
	UserSessions getsessionbyemailAndDeviceid(@Param("email") String email, @Param("deviceid") String deviceid);

	@Query("Select * from device_session_details1 where email=:email and isactive='Y' ALLOW FILTERING")
	List<UserSessions> getusersessionbyemail(@Param("email") String email);

	@Query("Select * from device_session_details1 where sessionid=:sessionid and emailencrypted=:email  and isactive='Y' limit 1 ALLOW FILTERING")
	UserSessions getActiveSymmetricByemail(@Param("sessionid") String sessionid, @Param("email") String email);

	@Query("Select * from device_session_details1 where sessionid=:sessionid and melpidencrypted=:melpid and isactive='Y' limit 1 ALLOW FILTERING")
	UserSessions getActiveSymmetricBymelpid(@Param("sessionid") String sessionid, @Param("melpid") String melpid);

	@Query("Select * from device_session_details1 where sessionid=:sessionid and email=:email ALLOW FILTERING")
	List<UserSessions> getAllActiveSymmetricKey(@Param("sessionid") String sessionid, @Param("email") String email);

	@Query("Select * from device_session_details1 where melpid=:melpid and deviceid=:deviceid ALLOW FILTERING")
	UserSessions getsessionbymelpidAndDeviceid(@Param("melpid") String melpid, @Param("deviceid") String deviceid);

	@Query("Select * from device_session_details1 where melpid=:melpid and isactive='Y' ALLOW FILTERING")
	List<UserSessions> getuserActiveSession(@Param("melpid") String melpid, @Param("millisecond") long millisecond);

	@Query("Select * from device_session_details1 where sessionid=:sessionid and emailid=:emailid and isactive='Y' ALLOW FILTERING")
	UserSessions getActiveSessionByES(@Param("sessionId") String sessionId, @Param("emailId") String emailId);

}
