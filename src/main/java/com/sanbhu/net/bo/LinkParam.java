package com.sanbhu.net.bo;

import java.util.Date;

public class LinkParam {

	private String userName;
	private String emailAddress;
	private boolean isForcedPasswordChange;
	private boolean isForgotPassword;
	private Date linkCreatedTime;
	private Date linkExpiryTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public Date getLinkCreatedTime() {
		return linkCreatedTime;
	}

	public void setLinkCreatedTime(Date linkCreatedTime) {
		this.linkCreatedTime = linkCreatedTime;
	}

	public Date getLinkExpiryTime() {
		return linkExpiryTime;
	}

	public void setLinkExpiryTime(Date linkExpiryTime) {
		this.linkExpiryTime = linkExpiryTime;
	}

	public boolean isForcedPasswordChange() {
		return isForcedPasswordChange;
	}

	public void setForcedPasswordChange(boolean isForcedPasswordChange) {
		this.isForcedPasswordChange = isForcedPasswordChange;
	}

	public boolean isForgotPassword() {
		return isForgotPassword;
	}

	public void setForgotPassword(boolean isForgotPassword) {
		this.isForgotPassword = isForgotPassword;
	}
}
