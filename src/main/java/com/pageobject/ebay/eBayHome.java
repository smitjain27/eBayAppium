package com.pageobject.ebay;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.eBay.android.BaseClass;
import com.test.eBay.android.WebDriverWaitUtils;

public class eBayHome extends BaseClass {


	@AndroidFindBy(xpath="//android.widget.Button[@text='SIGN IN']") public WebElement signInButton;
	@AndroidFindBy(className="android.widget.TextView") public WebElement searchBox;
	@AndroidFindBy(className="android.widget.EditText") public WebElement searchInput;
	@AndroidFindBy(xpath="//android.widget.Button[@text='REGISTER']") public WebElement registerButton;
	@AndroidFindBy(id="firstname") public WebElement firstName;

	
	public eBayHome() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}

	public void clickSearch() throws InterruptedException {
		WebDriverWaitUtils.waitElementToBeVisible(searchBox);
		searchBox.click();
		searchInput.isDisplayed();
		
	}
	public void navigateToRegistrationPage() {
		WebDriverWaitUtils.waitElementToBeVisible(registerButton);
		registerButton.click();
		WebDriverWaitUtils.waitElementToBeVisible(firstName);
	}
	

}
