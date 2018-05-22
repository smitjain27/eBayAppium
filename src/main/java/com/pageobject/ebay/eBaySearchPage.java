package com.pageobject.ebay;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.eBay.android.BaseClass;
import com.test.eBay.android.WebDriverWaitUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


	public class eBaySearchPage extends BaseClass {

		@AndroidFindBy(className="android.widget.EditText") public WebElement searchInput;
		@AndroidFindBy(xpath="//android.widget.TextView[@text='mi note 4 charger']") public WebElement searchButton;
		@AndroidFindBy(xpath="//android.widget.Button[@text='SORT']") public WebElement SortButton;
		
		public eBaySearchPage() throws Exception {
			PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
		}

		public void searchInfo() {
			searchInput.sendKeys("MI Note4");
			searchButton.click();
			WebDriverWaitUtils.waitElementToBeVisible(SortButton);
		
		}
			

	}


