package com.model;

import java.util.Calendar;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "user")
public class User {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(name = "email", nullable = false)
	private String email = "";

	@Column(name = "userName", nullable = false)
	private String userName = "";
	
	@Column(name = "password")
	private String password = "";
	
	@Column(name = "tempPassword")
	private String tempPassword = "";
	
	@Column(name = "firstName")
	private String firstName = "";
	
	@Column(name = "lastName")
	private String lastName = "";
	
	@Column(name = "userType")
	private String userType = "";

	@Column(name = "sourceofsignup")
	private String sourceofsignup = "";

	@Column(name = "melpid")
	private String melpid = UUID.randomUUID().toString();

	@Column(name = "calendar_link")
	private String calendar_link;

	@Column(name = "employementtype")
	private int employementtype = -1;

	@Column(name = "group_restrictionId")
	private int group_restrictionId = 4;

	@Column(name = "countrycode")
	private String countrycode = "";

	@Column(name = "phoneNumber")
	private String phoneNumber = "";
	
	@Column(name = "extension")
	private String extension = "";
	
	@Column(name = "extPass")
	private String extPass = "";

	@Column(name = "asteriskIP")
	private String asteriskIP = "";

	@Column(name = "deptId")
	private int deptId = 0;

	@Column(name = "countryId")
	private int countryId = 0;
	
	@Column(name = "stateId")
	private int stateId = 0;
	
	@Column(name = "cityId")
	private int cityId = 0;
	
	@Column(name = "professionId")
	private int professionId = 0;
	
	@Column(name = "imageUrl")
	private String imageUrl = "https://fm.melpapp.com:8000/MelpApp/uploads/defaultF.jpg";
	
	@Column(name = "imageType")
	private String imageType = "";
	
	@Column(name = "aboutUs")
	private String aboutUs = "";
	
	@Column(name = "deviceType")
	private int deviceType = 0;
	
	@Column(name = "deviceId")
	private String deviceId = "";
	
	@Column(name = "deviceIdapns")
	private String deviceIdapns = "";
	
	@Column(name = "isAddAcount")
	private int isAddAcount = 0;
	
	@Column(name = "appVersion")
	private String appVersion = "";
	
	@Column(name = "isActive")
	private String isActive = "Y";
	
	@Column(name = "workingas")
	private String workingas = "";
	
	@Column(name = "expertise")
	private String expertise = "";

	@Column(name = "skill")
	private String skill = "";

	@Transient
	private String emails;

	@Transient
	private String externalemails;

	@Column(name = "roomlink")
	private String roomlink = "";

	@Column(name = "verificationCode")
	private String verificationCode = "";

	@Column(name = "verificationStatus")
	private String verificationStatus = "";

	@Column(name = "client_id")
	private int client_id = 0;

	@Column(name = "addedOn")
	private long addedOn = Calendar.getInstance().getTimeInMillis();

	@Column(name = "last_login")
	private long last_login = 0l;

	@Column(name = "parent_id")
	private int parent_id = 0;

	@Column(name = "first_login")
	private long first_login = 0l;

	@Column(name = "profileStatus")
	private int profileStatus;

	@Column(name = "secondaryEmail")
	private String secondaryEmail = "";

	@Column(name = "port")
	private int port = 0;

	@Column(name = "proxy")
	private String proxy = "";

	@Column(name = "companyName")
	private String companyName = "";

	@Transient
	private String CityName;
	
	@Transient
	private String StateName;
	
	@Transient
	private String Department;

	@Transient
	private String Profession;
	
	@Transient
	private Object count;
	
	@Transient
	private String Country;
	
	@Transient
	private String phonecode;
	
	@Transient
	private int isadmin;
	
	@Transient
	private int invitestatus;
	
	@Transient
	private int parentMemberId;
	
	@Transient
	private int contactMemberId;
	
	@Transient
	private long invitationId;

	@Transient
	private String sortname = "";

	@Transient
	private String statusmessage = "Pending";

	@Transient
	private int meetingstatus = 0;

	@Transient
	private int phoneformate;

	@Transient
	private Object maxext = 0l;
	
	@Transient
	private Integer flag;
	
	@Transient
	private Integer resultCount;


	public Integer getResultCount() {
		return resultCount;
	}

	public void setResultCount(Integer resultCount) {
		this.resultCount = resultCount;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	public String getAboutUs() {
		return aboutUs;
	}

	public long getAddedOn() {
		return addedOn;
	}

	public String getAppVersion() {
		return appVersion;
	}

	public String getAsteriskIP() {
		return asteriskIP;
	}

	public String getCalendar_link() {
		return calendar_link;
	}

	public int getCityId() {
		return cityId;
	}

	public String getCityName() {
		return CityName;
	}

	public int getClient_id() {
		return client_id;
	}

	public String getCompanyName() {
		return companyName;
	}
	
	public int getContactMemberId() {
		return contactMemberId;
	}

	public Object getCount() {
		return count;
	}

	public String getCountry() {
		return Country;
	}
	
	public String getCountrycode() {
		return countrycode;
	}

	public int getCountryId() {
		return countryId;
	}

	public String getCountrySortname() {
		return sortname;
	}

	public String getDepartment() {
		return Department;
	}

	public int getDeptId() {
		return deptId;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public String getDeviceIdapns() {
		return deviceIdapns;
	}

	public int getDeviceType() {
		return deviceType;
	}

	public String getEmail() {
		return email;
	}

	public String getEmails() {
		return emails;
	}

	public int getEmployementtype() {
		return employementtype;
	}

	public String getExpertise() {
		return expertise;
	}

	public String getExtension() {
		return extension;
	}

	public String getExternalemails() {
		return externalemails;
	}

	public String getExtPass() {
		return extPass;
	}

	public long getFirst_login() {
		return first_login;
	}

	public String getFirstName() {
		return firstName;
	}

	public int getGroup_restrictionId() {
		return group_restrictionId;
	}

	public long getId() {
		return userId;
	}

	public String getImageType() {
		return imageType;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public long getInvitationId() {
		return invitationId;
	}

	public int getInvitestatus() {
		return invitestatus;
	}

	public String getIsActive() {
		return isActive;
	}

	public int getIsAddAcount() {
		return isAddAcount;
	}

	public int getIsadmin() {
		return isadmin;
	}

	public long getLast_login() {
		return last_login;
	}

	public String getLastName() {
		return lastName;
	}

	public Object getMaxext() {
		return maxext;
	}

	public int getMeetingstatus() {
		return meetingstatus;
	}

	public String getMelpid() {
		return melpid;
	}

	public int getParent_id() {
		return parent_id;
	}

	public int getParentMemberId() {
		return parentMemberId;
	}

	public String getPassword() {
		return password;
	}

	public String getPhonecode() {
		return phonecode;
	}

	public int getPhoneformate() {
		return phoneformate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public int getPort() {
		return port;
	}

	public String getProfession() {
		return Profession;
	}

	public int getProfessionId() {
		return professionId;
	}

	public int getProfileStatus() {
		return profileStatus;
	}

	public String getProxy() {
		return proxy;
	}

	public String getRoomLink() {
		return roomlink;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public String getSkill() {
		return skill;
	}

	public String getSortname() {
		return sortname;
	}

	public String getSourceofsignup() {
		return sourceofsignup;
	}

	public int getStateId() {
		return stateId;
	}

	public String getStateName() {
		return StateName;
	}

	public String getStatusmessage() {
		return statusmessage;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public long getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserType() {
		return userType;
	}

	public String getVerificationCode() {
		return verificationCode;
	}

	public String getVerificationStatus() {
		return verificationStatus;
	}

	public String getWorkingas() {
		return workingas;
	}

	public void setAboutUs(String aboutUs) {
		this.aboutUs = aboutUs;
	}

	public void setAddedOn(Object addedOn) {
		this.addedOn = Long.parseLong(addedOn + "");
	}

	public void setAppVersion(String appVersion) {
		this.appVersion = appVersion;
	}

	public void setAsteriskIP(String asteriskIP) {
		this.asteriskIP = asteriskIP;
	}

	public void setCalendar_link(String calendar_link) {
		this.calendar_link = calendar_link;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setContactMemberId(int contactMemberId) {
		this.contactMemberId = contactMemberId;
	}

	public void setCount(Object count) {
		this.count = count;
	}

	public void setCountry(String country) {
		Country = country;
	}

	public void setCountrycode(String countrycode) {
		this.countrycode = countrycode;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public void setCountrySortname(String sortname) {
		this.sortname = sortname;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

	public void setDeviceIdapns(String deviceIdapns) {
		this.deviceIdapns = deviceIdapns;
	}

	public void setDeviceType(int deviceType) {
		this.deviceType = deviceType;
	}

	public void setEmail(String value) {
		this.email = value;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public void setEmployementtype(int employementtype) {
		this.employementtype = employementtype;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public void setExternalemails(String externalemails) {
		this.externalemails = externalemails;
	}

	public void setExtPass(String extPass) {
		this.extPass = extPass;
	}

	public void setFirst_login(Object first_login) {
		this.first_login = Long.parseLong(first_login + "");
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setGroup_restrictionId(int group_restrictionId) {
		this.group_restrictionId = group_restrictionId;
	}

	public void setId(long value) {
		this.userId = value;
	}

	public void setImageType(String imageType) {
		this.imageType = imageType;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setInvitationId(Object invitationId) {
		this.invitationId = Long.parseLong(invitationId + "");
	}

	public void setInvitestatus(int invitestatus) {
		this.invitestatus = invitestatus;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public void setIsAddAcount(int isAddAcount) {
		this.isAddAcount = isAddAcount;
	}

	public void setIsadmin(int isadmin) {
		this.isadmin = isadmin;
	}

	public void setLast_login(Object last_login) {
		this.last_login = Long.parseLong(last_login + "");
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMaxext(Object maxext) {
		this.maxext = maxext;
	}

	public void setMeetingstatus(int meetingstatus) {
		this.meetingstatus = meetingstatus;
	}

	public void setMelpid(String melpid) {
		this.melpid = melpid;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public void setParentMemberId(int parentMemberId) {
		this.parentMemberId = parentMemberId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhonecode(String phonecode) {
		this.phonecode = phonecode;
	}

	public void setPhoneformate(int phoneformate) {
		this.phoneformate = phoneformate;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}

	public void setProfessionId(int professionId) {
		this.professionId = professionId;
	}

	public void setProfileStatus(int profileStatus) {
		this.profileStatus = profileStatus;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public void setRoomLink(String roomlink) {
		this.roomlink = roomlink;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public void setSortname(String sortname) {
		this.sortname = sortname;
	}

	public void setSourceofsignup(String sourceofsignup) {
		this.sourceofsignup = sourceofsignup;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public void setStateName(String stateName) {
		StateName = stateName;
	}

	public void setStatusmessage(String statusmessage) {
		this.statusmessage = statusmessage;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public void setUserName(String value) {
		this.userName = value;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	public void setVerificationStatus(String verificationStatus) {
		this.verificationStatus = verificationStatus;
	}

	public void setWorkingas(String workingas) {
		this.workingas = workingas;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", email=" + email + ", userName=" + userName + ", password=" + password
				+ ", tempPassword=" + tempPassword + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", userType=" + userType + ", sourceofsignup=" + sourceofsignup + ", melpid=" + melpid
				+ ", calendar_link=" + calendar_link + ", employementtype=" + employementtype + ", group_restrictionId="
				+ group_restrictionId + ", countrycode=" + countrycode + ", phoneNumber=" + phoneNumber + ", extension="
				+ extension + ", extPass=" + extPass + ", asteriskIP=" + asteriskIP + ", deptId=" + deptId
				+ ", countryId=" + countryId + ", stateId=" + stateId + ", cityId=" + cityId + ", professionId="
				+ professionId + ", imageUrl=" + imageUrl + ", imageType=" + imageType + ", aboutUs=" + aboutUs
				+ ", deviceType=" + deviceType + ", deviceId=" + deviceId + ", deviceIdapns=" + deviceIdapns
				+ ", isAddAcount=" + isAddAcount + ", appVersion=" + appVersion + ", isActive=" + isActive
				+ ", workingas=" + workingas + ", expertise=" + expertise + ", skill=" + skill + ", emails=" + emails
				+ ", externalemails=" + externalemails + ", roomlink=" + roomlink + ", verificationCode="
				+ verificationCode + ", verificationStatus=" + verificationStatus + ", client_id=" + client_id
				+ ", addedOn=" + addedOn + ", last_login=" + last_login + ", parent_id=" + parent_id + ", first_login="
				+ first_login + ", profileStatus=" + profileStatus + ", secondaryEmail=" + secondaryEmail + ", port="
				+ port + ", proxy=" + proxy + ", companyName=" + companyName + ", CityName=" + CityName + ", StateName="
				+ StateName + ", Department=" + Department + ", Profession=" + Profession + ", count=" + count
				+ ", Country=" + Country + ", phonecode=" + phonecode + ", isadmin=" + isadmin + ", invitestatus="
				+ invitestatus + ", parentMemberId=" + parentMemberId + ", contactMemberId=" + contactMemberId
				+ ", invitationId=" + invitationId + ", sortname=" + sortname + ", statusmessage=" + statusmessage
				+ ", meetingstatus=" + meetingstatus + ", phoneformate=" + phoneformate + ", maxext=" + maxext + "]";
	}
} 