package com.pageobject.ebay;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import junit.framework.Assert;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.test.eBay.android.BaseClass;
import com.test.eBay.android.WebDriverWaitUtils;

public class eBayRegistration extends BaseClass {

	@AndroidFindBy(id="firstname") public WebElement firstName;
	@AndroidFindBy(id="lastname") public WebElement lastName;
	@AndroidFindBy(id="email") public WebElement emailAddress;
	@AndroidFindBy(id="PASSWORD") public WebElement password;
	@AndroidFindBy(id="lblPASSWORD") public WebElement lblPassword;
	@AndroidFindBy(id="ppaFormSbtBtn") public WebElement register;
	
		
	
	public eBayRegistration() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10,
				TimeUnit.SECONDS), this);
	}
	
	public void registration(){
		boolean r1=register.isEnabled();
		Assert.assertTrue("Register Page is open", r1==false);
		firstName.click();
		firstName.sendKeys("FName");
		
		lastName.click();
		lastName.sendKeys("LName");
		
		emailAddress.click();
		emailAddress.sendKeys("email@email.com");
		
		password.click();
		password.sendKeys("Appium@123");
		lblPassword.click();
		
		WebDriverWaitUtils.waitElementToBeClickable(register);
		register.click();
		register.click();
		WebDriverWaitUtils.waitForElementToBeInVisible(register);
		
	}

	
	
	

}
