/**
 * 
 */
package com.mellon.platform.privilege;

import java.sql.Timestamp;

public class UserVO extends AbstractVO {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5038152686294520071L;
	
	private String name;

	private String lastOperator;

	private Long formatTime;

	private String accountName;

	private String pwd;

	private Integer orgId;

	private Integer superiorId;

	private String email;

	private Integer sex;

	private String tel;

	private String mobile;

	private Integer defaultLang;

	private String note;

	private String photo;

	private Integer status;

	private Integer isDelete;

	private Integer loginStatus;

	private Timestamp lastLoginTime;

	private String lastLoginIp;

	private Timestamp pwdUpdateTime;

	private Integer canMultiLogin;

	private Integer needChangePwd;

	private String organization;

	private String statusValue;

	private String superior;

	private String superiorName;

	private Long periodEnd;

	private Long periodStart;

	private Integer roleId;

	private Integer groupId;

	public UserVO() {
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String validWhenAdd() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String validWhenDelete() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String validWhenUpdate() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lastOperator
	 */
	public String getLastOperator() {
		return lastOperator;
	}

	/**
	 * @param lastOperator the lastOperator to set
	 */
	public void setLastOperator(String lastOperator) {
		this.lastOperator = lastOperator;
	}

	/**
	 * @return the formatTime
	 */
	public Long getFormatTime() {
		return formatTime;
	}

	/**
	 * @param formatTime the formatTime to set
	 */
	public void setFormatTime(Long formatTime) {
		this.formatTime = formatTime;
	}

	/**
	 * @return the accountName
	 */
	public String getAccountName() {
		return accountName;
	}

	/**
	 * @param accountName the accountName to set
	 */
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}

	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	/**
	 * @return the orgId
	 */
	public Integer getOrgId() {
		return orgId;
	}

	/**
	 * @param orgId the orgId to set
	 */
	public void setOrgId(Integer orgId) {
		this.orgId = orgId;
	}

	/**
	 * @return the superiorId
	 */
	public Integer getSuperiorId() {
		return superiorId;
	}

	/**
	 * @param superiorId the superiorId to set
	 */
	public void setSuperiorId(Integer superiorId) {
		this.superiorId = superiorId;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * @param sex the sex to set
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the defaultLang
	 */
	public Integer getDefaultLang() {
		return defaultLang;
	}

	/**
	 * @param defaultLang the defaultLang to set
	 */
	public void setDefaultLang(Integer defaultLang) {
		this.defaultLang = defaultLang;
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}

	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the isDelete
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * @return the loginStatus
	 */
	public Integer getLoginStatus() {
		return loginStatus;
	}

	/**
	 * @param loginStatus the loginStatus to set
	 */
	public void setLoginStatus(Integer loginStatus) {
		this.loginStatus = loginStatus;
	}

	/**
	 * @return the lastLoginTime
	 */
	public Timestamp getLastLoginTime() {
		return lastLoginTime;
	}

	/**
	 * @param lastLoginTime the lastLoginTime to set
	 */
	public void setLastLoginTime(Timestamp lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * @return the lastLoginIp
	 */
	public String getLastLoginIp() {
		return lastLoginIp;
	}

	/**
	 * @param lastLoginIp the lastLoginIp to set
	 */
	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	/**
	 * @return the pwdUpdateTime
	 */
	public Timestamp getPwdUpdateTime() {
		return pwdUpdateTime;
	}

	/**
	 * @param pwdUpdateTime the pwdUpdateTime to set
	 */
	public void setPwdUpdateTime(Timestamp pwdUpdateTime) {
		this.pwdUpdateTime = pwdUpdateTime;
	}

	/**
	 * @return the canMultiLogin
	 */
	public Integer getCanMultiLogin() {
		return canMultiLogin;
	}

	/**
	 * @param canMultiLogin the canMultiLogin to set
	 */
	public void setCanMultiLogin(Integer canMultiLogin) {
		this.canMultiLogin = canMultiLogin;
	}

	/**
	 * @return the needChangePwd
	 */
	public Integer getNeedChangePwd() {
		return needChangePwd;
	}

	/**
	 * @param needChangePwd the needChangePwd to set
	 */
	public void setNeedChangePwd(Integer needChangePwd) {
		this.needChangePwd = needChangePwd;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the statusValue
	 */
	public String getStatusValue() {
		return statusValue;
	}

	/**
	 * @param statusValue the statusValue to set
	 */
	public void setStatusValue(String statusValue) {
		this.statusValue = statusValue;
	}

	/**
	 * @return the superior
	 */
	public String getSuperior() {
		return superior;
	}

	/**
	 * @param superior the superior to set
	 */
	public void setSuperior(String superior) {
		this.superior = superior;
	}

	/**
	 * @return the superiorName
	 */
	public String getSuperiorName() {
		return superiorName;
	}

	/**
	 * @param superiorName the superiorName to set
	 */
	public void setSuperiorName(String superiorName) {
		this.superiorName = superiorName;
	}

	/**
	 * @return the periodEnd
	 */
	public Long getPeriodEnd() {
		return periodEnd;
	}

	/**
	 * @param periodEnd the periodEnd to set
	 */
	public void setPeriodEnd(Long periodEnd) {
		this.periodEnd = periodEnd;
	}

	/**
	 * @return the periodStart
	 */
	public Long getPeriodStart() {
		return periodStart;
	}

	/**
	 * @param periodStart the periodStart to set
	 */
	public void setPeriodStart(Long periodStart) {
		this.periodStart = periodStart;
	}

	/**
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
}
