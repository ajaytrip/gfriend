package com.gfriend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gfriend.account.beans.CustomerLogin;
import com.gfriend.account.beans.CustomerRegistration;
import com.gfriend.account.beans.Profile;
import com.gfriend.service.helper.AccountServiceHelper;

@Component
public class AccountServices {

	/**
	 *  This Property hold @AccountServiceHelper value
	 */
	@Autowired
	private AccountServiceHelper mAccountServiceHelper;
	
	public AccountServices() {
		System.out.println("AccountServices");
	}
	
	/**
	 * @return
	 */
	public Profile loginService() {
		
		return null;
	}
   
	/**
	 * @return
	 */
	private Profile registrationService() {

		return null;
	}
	/**
	 * @return the accountServiceHelper
	 */
	public AccountServiceHelper getAccountServiceHelper() {
		return mAccountServiceHelper;
	}


	/**
	 * @param pAccountServiceHelper the accountServiceHelper to set
	 */
	public void setAccountServiceHelper(AccountServiceHelper pAccountServiceHelper) {
		mAccountServiceHelper = pAccountServiceHelper;
	}

	public void registerUser(CustomerRegistration pCustomerRegistration) {
		// TODO Auto-generated method stub
		System.out.println("service "+pCustomerRegistration);
		mAccountServiceHelper.registerUser(pCustomerRegistration);
	}
	
	
}
