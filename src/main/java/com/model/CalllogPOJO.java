package com.model;

import java.util.Calendar;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("calllog")

public class CalllogPOJO {

	@PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private String calldataid;
	@PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	private String calldate;

	@PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	private String callid;
	private String calltype;

	private Long create_date = Calendar.getInstance().getTimeInMillis();

	public String getCalldate() {
		return calldate;
	}

	public void setCalldate(String calldate) {
		this.calldate = calldate;
	}

	private String rid;
	private String isactive = "Y";
	private Long modi_date = Calendar.getInstance().getTimeInMillis();
	private String callstatus;
	private String subtype;
	private String type;
	private String grouptype;
	private String accesstoken;
	private String conversationid;
	private String startedby;
	private String callpackettype;
	private String roomurl;
	private String serverurl;
	private String teamid;
	private String initiatorname;
	private String roomid;
	private String teamname;
	@PrimaryKeyColumn(ordinal = 3, type = PrimaryKeyType.CLUSTERED)
	private String user;
	private String callto;
	private String callfrom;
	private int groupid;

	public int getGroupid() {
		return groupid;
	}

	public void setGroupid(int groupid) {
		this.groupid = groupid;
	}

	private String ispresent = "Y";
	private Long activelast = Calendar.getInstance().getTimeInMillis() + (10 * 60 * 1000l);

	public String getIspresent() {
		return ispresent;
	}

	public void setIspresent(String ispresent) {
		this.ispresent = ispresent;
	}

	public Long getActivelast() {
		return activelast;
	}

	public void setActivelast(Long activelast) {
		this.activelast = activelast;
	}

	public String getCalldataid() {
		return calldataid;
	}

	public void setCalldataid(String calldataid) {
		this.calldataid = calldataid;
	}

	public String getCallid() {
		return callid;
	}

	public void setCallid(String callid) {
		this.callid = callid;
	}

	public String getCalltype() {
		return calltype;
	}

	public void setCalltype(String calltype) {
		this.calltype = calltype;
	}

	public Long getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Long create_date) {
		this.create_date = create_date;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public Long getModi_date() {
		return modi_date;
	}

	public void setModi_date(Long modi_date) {
		this.modi_date = modi_date;
	}

	public String getCallstatus() {
		return callstatus;
	}

	public void setCallstatus(String callstatus) {
		this.callstatus = callstatus;
	}

	public String getConversationid() {
		return conversationid;
	}

	public void setConversationid(String conversationid) {
		this.conversationid = conversationid;
	}

	public String getStartedby() {
		return startedby;
	}

	public void setStartedby(String startedby) {
		this.startedby = startedby;
	}

	public String getCallpackettype() {
		return callpackettype;
	}

	public void setCallpackettype(String callpackettype) {
		this.callpackettype = callpackettype;
	}

	public String getRoomurl() {
		return roomurl;
	}

	public void setRoomurl(String roomurl) {
		this.roomurl = roomurl;
	}

	public String getServerurl() {
		return serverurl;
	}

	public void setServerurl(String serverurl) {
		this.serverurl = serverurl;
	}

	public String getTeamid() {
		return teamid;
	}

	public void setTeamid(String teamid) {
		this.teamid = teamid;
	}

	public String getInitiatorname() {
		return initiatorname;
	}

	public void setInitiatorname(String initiatorname) {
		this.initiatorname = initiatorname;
	}

	public String getRoomid() {
		return roomid;
	}

	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}

	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public String getCallto() {
		return callto;
	}

	public void setCallto(String callto) {
		this.callto = callto;
	}

	public String getCallfrom() {
		return callfrom;
	}

	public void setCallfrom(String callfrom) {
		this.callfrom = callfrom;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSubtype() {
		return subtype;
	}

	public void setSubtype(String subtype) {
		this.subtype = subtype;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGrouptype() {
		return grouptype;
	}

	public void setGrouptype(String grouptype) {
		this.grouptype = grouptype;
	}

	public String getAccesstoken() {
		return accesstoken;
	}

	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}

}