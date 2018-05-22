package com.tests;

import org.testng.annotations.*;


import com.pageobject.ebay.eBayHome;
import com.pageobject.ebay.eBayRegistration;

import com.test.eBay.android.BaseClass;
import com.test.eBay.android.WebDriverWaitUtils;



public class Registration extends BaseClass {
	
	private eBayHome ebayHome;
	private eBayRegistration eBayRegistration;
	

	@Test
	public void register() throws Exception{
		ebayHome = new eBayHome();
		eBayRegistration = new eBayRegistration();
		WebDriverWaitUtils.waitElementToBeVisible(ebayHome.signInButton);
		ebayHome.navigateToRegistrationPage();
		eBayRegistration.registration();
		
	}
}
