package com.gfriend.service.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gfriend.account.beans.CustomerRegistration;
import com.gfriend.dynamo.Dynamo;

@Component
public class AccountServiceHelper {
	@Autowired
	private Dynamo dynamo;
	public void registerUser(CustomerRegistration pCustomerRegistration) {
		// TODO Auto-generated method stub
		System.out.println("Helper :: "+pCustomerRegistration);
		try {
			dynamo.saveToDB(pCustomerRegistration);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
