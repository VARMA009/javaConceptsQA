package com.dao;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.model.CalllogPOJO;

@Repository("calllogDao")
public interface CalllogDao extends CrudRepository<CalllogPOJO, String> {

	@Query("Select * from calllog where user=:extension and modi_date>:millis  ALLOW FILTERING")
	List<CalllogPOJO> getcalllogdatabyextension(@Param("extension") String extension, @Param("millis") long millis);

	@Query("Select * from calllog where callid=:callid and callstatus='202' and activelast>:millis order by create_date desc  ALLOW FILTERING")
	List<CalllogPOJO> getActiveCall(@Param("callid") String callid, @Param("millis") long millis);

	@Query("Select * from calllog where callid=:callid  and user=:user ALLOW FILTERING")
	CalllogPOJO getcalldatabycallidAndCallStatus(@Param("callid") String callid, @Param("user") String user);

	@Query("Select * from calllog where teamid=:teamid and callstatus='202' and  modi_date>:millis ALLOW FILTERING")
	List<CalllogPOJO> getActiveCallbyteamid(@Param("teamid") String teamid, @Param("millis") long millis);

	@Query("Select * from calllog where  user=:extension and create_date>:lastthirtyday ALLOW FILTERING")
	List<CalllogPOJO> getrecentcallofuser(@Param("extension") String extension,
			@Param("lastthirtyday") long lastthirtyday);

	@Query("Select * from calllog where callid=:callid and callstatus='202' and activelast>:millis  order by create_date desc  ALLOW FILTERING")
	List<CalllogPOJO> getActiveCallbycallid(@Param("callid") String callid, @Param("millis") long millis);

	@Query("Select * from calllog where roomid=:roomid and callstatus='202' and activelast>:millis ALLOW FILTERING")
	List<CalllogPOJO> getActiveCallbyroomid(@Param("roomid") String roomid, @Param("millis") long millis);

	@Query("Select * from calllog where callstatus='202' ALLOW FILTERING")
	List<CalllogPOJO> getAllActiveRooms();

	@Query("Select * from calllog where callid=:callid and calldate=:calldate")
	List<CalllogPOJO> getCallLogByCallId(@Param("callid") String callid, @Param("calldate") String calldate);

	@Query("Select max(calldataid) from calllog where callid=:callid and calldate=:calldate")
	Integer getCallLogMaxByCallId(@Param("callid") String callid, @Param("calldate") String calldate);

	@Query("Select * from calllog where callid=:callid and calldate=:calldate and calldataid=:callid")
	List<CalllogPOJO> getCallLogByCallDataId(@Param("callid") String callid, @Param("calldate") String calldate,
			@Param("calldataid") String calldataid);

	@Query("Select * from calllog where callid=:callid and calldate=:calldate and calldataid=:callid")
	CalllogPOJO getCallLogByUserId(@Param("callid") String callid, @Param("calldate") String calldate,
			@Param("calldataid") String calldataid, @Param("user") String user);

	@Query("Select * from calllog where callid=:callid and calldate=:calldate and calldataid=:callid and callstatus='200' ALLOW FILTERING")
	List<CalllogPOJO> getActiveCallLogByCallStatus(@Param("callid") String callid, @Param("calldate") String calldate,
			@Param("calldataid") String calldataid);

}
