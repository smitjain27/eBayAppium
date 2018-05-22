package com.test.eBay.android;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.File;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	public static AppiumDriver<WebElement> driver;
	
	@BeforeMethod(alwaysRun = true)
	public void  setUp() throws Exception {
		File classpathRoot = new File(System.getProperty("user.dir"));
		System.out.println(classpathRoot);
        File appDir = new File(classpathRoot, "src/resources");
	    File app = new File(appDir, "com.ebay.mobile_2018-05-21.apk");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "04157df4adcb6a27");
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    capabilities.setCapability("rotatable", true);

	    driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

	}

  

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
	  driver.quit();
  }

}
