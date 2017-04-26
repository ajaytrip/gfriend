package com.gfriend.account.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class Profile {

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
}
