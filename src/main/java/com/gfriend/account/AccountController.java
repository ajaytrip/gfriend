package com.gfriend.account;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gfriend.account.beans.CustomerLogin;
import com.gfriend.account.beans.CustomerRegistration;
import com.gfriend.service.AccountServices;

@Controller

public class AccountController {

	/**
	 *  This Property hold @AccountServices value
	 */
	@Autowired
	private AccountServices accountServices;
	
	public AccountController() {
		System.out.println("AccountController");
	}

	@RequestMapping(name="/index",method = RequestMethod.GET)
	public String showLoginForm(ModelMap model) {
		System.out.println("showLoginForm ");
		model.addAttribute("customerLogin", new CustomerLogin());
		model.addAttribute("customerRegistration", new CustomerRegistration());
		return "index";
	}

	@RequestMapping(name="/loginForm.htm",value="login", method = RequestMethod.POST)
	public String loginForm(@ModelAttribute("customerLogin") CustomerLogin customerLogin, BindingResult result,
			Map model) {
		System.out.println(customerLogin.getEmail() + "" + customerLogin.getPassword());
		
		return "profile";
	}
	
	@RequestMapping(name = "/registration.htm",value="registration", method = RequestMethod.POST)
	public String customerRegistration(@ModelAttribute("customerRegistration") CustomerRegistration customerRegistration, BindingResult result,
			Map model) {
		System.out.println(customerRegistration);
		
		return "profile";
	}

	/**
	 * @return the accountServices
	 */
	public AccountServices getAccountServices() {
		return accountServices;
	}

	/**
	 * @param pAccountServices the accountServices to set
	 */
	public void setAccountServices(AccountServices pAccountServices) {
		accountServices = pAccountServices;
	}
	
	
}
