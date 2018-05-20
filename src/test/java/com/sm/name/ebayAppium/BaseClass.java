package com.sm.name.ebayAppium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	DesiredCapabilities capabilities;
	WebDriver driver;
  @BeforeMethod
  public void beforeMethod() {
	 
	  	//Set up desired capabilities and pass the Android app-activity and app-package to Appium
	  	capabilities= new DesiredCapabilities();
	  	capabilities.setCapability("BROWSER_NAME", "Android");
	  	capabilities.setCapability("VERSION", "7.1.1"); 
	  	capabilities.setCapability("deviceName","Emulator");
	  	capabilities.setCapability("platformName","Android");
	   
	     
	     capabilities.setCapability("appPackage", "com.android.calculator2");
	  // This package name of your app (you can get it from apk info app)
	  	capabilities.setCapability("appActivity","com.android.calculator2.Calculator"); // This is Launcher activity of your app (you can get it from apk info app)
	  //Create RemoteWebDriver instance and connect to the Appium server
	   //It will launch the Calculator App in Android Device using the configurations specified in Desired Capabilities
	     
	  }
  

  @AfterMethod
  public void afterMethod() {
	  driver.quit();
  }

}
