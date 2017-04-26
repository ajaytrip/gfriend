package com.gfriend.account.beans;

public class CustomerRegistration {

	/**
	 *  This Property hold @String value
	 */
	private String mFirstName;
	
	/**
	 *  This Property hold @String value
	 */
	private String mLastName;
	
	/**
	 *  This Property hold @String value
	 */
	private String mLogin;
	
	/**
	 *  This Property hold @String value
	 */
	private String mPassword;

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return mFirstName;
	}

	/**
	 * @param pFirstName the firstName to set
	 */
	public void setFirstName(String pFirstName) {
		mFirstName = pFirstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return mLastName;
	}

	/**
	 * @param pLastName the lastName to set
	 */
	public void setLastName(String pLastName) {
		mLastName = pLastName;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return mLogin;
	}

	/**
	 * @param pLogin the login to set
	 */
	public void setLogin(String pLogin) {
		mLogin = pLogin;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return mPassword;
	}

	/**
	 * @param pPassword the password to set
	 */
	public void setPassword(String pPassword) {
		mPassword = pPassword;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerRegistration [mFirstName=");
		builder.append(mFirstName);
		builder.append(", mLastName=");
		builder.append(mLastName);
		builder.append(", mLogin=");
		builder.append(mLogin);
		builder.append(", mPassword=");
		builder.append(mPassword);
		builder.append("]");
		return builder.toString();
	}
	
}
