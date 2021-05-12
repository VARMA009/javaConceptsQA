package com.utility;

public class Calljitsitoken {

	private String callid;
	
	private String avatar;
	
	private String email;
	
	private String username;
	
	private String room;
	
	private String groupname;
	
	private long ttlMillis;
	
	private String calleename;
	
	private String calleeavatar;	
	
	private Boolean moderator;
	
	public Calljitsitoken(String callid, String avatar, String email, String username, String room, String groupname,
			long ttlMillis, String calleename, String calleeavatar, Boolean moderator) {
		super();
		this.callid = callid;
		this.avatar = avatar;
		this.email = email;
		this.username = username;
		this.room = room;
		this.groupname = groupname;
		this.ttlMillis = ttlMillis;
		this.calleename = calleename;
		this.calleeavatar = calleeavatar;
		this.moderator = moderator;
	}

	

	public String getCallid() {
		return callid;
	}

	public void setCallid(String callid) {
		this.callid = callid;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public long getTtlMillis() {
		return ttlMillis;
	}

	public void setTtlMillis(long ttlMillis) {
		this.ttlMillis = ttlMillis;
	}

	public String getCalleename() {
		return calleename;
	}

	public void setCalleename(String calleename) {
		this.calleename = calleename;
	}

	public String getCalleeavatar() {
		return calleeavatar;
	}

	public void setCalleeavatar(String calleeavatar) {
		this.calleeavatar = calleeavatar;
	}

	public Boolean getModerator() {
		return moderator;
	}
	
	public void setModerator(Boolean moderator) {
		this.moderator = moderator;
	}
    
}
