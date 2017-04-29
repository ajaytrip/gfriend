package com.gfriend.service.helper;

import org.springframework.stereotype.Component;

import com.gfriend.account.beans.CustomerRegistration;

@Component
public class AccountServiceHelper {

	public void registerUser(CustomerRegistration pCustomerRegistration) {
		// TODO Auto-generated method stub
		System.out.println("Helper :: "+pCustomerRegistration);
	}

	
}
