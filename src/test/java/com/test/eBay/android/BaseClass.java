package com.test.eBay.android;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class BaseClass {
	public static AppiumDriver<WebElement> driver;
	public static Properties config=null;
	public static FileInputStream fp=null;
	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	public DesiredCapabilities capabilities;
	
	@BeforeSuite(alwaysRun = true)
	public void serverStart() throws Exception{
		//Build the Appium service
				builder = new AppiumServiceBuilder();
				builder.withIPAddress("127.0.0.1");
				builder.usingPort(4723);
				builder.withCapabilities(capabilities);
				builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
				builder.withArgument(GeneralServerFlag.LOG_LEVEL,"error");
				
				//Start the server with the builder
				service = AppiumDriverLocalService.buildService(builder);
				service.start();
	}
	
	@BeforeMethod(alwaysRun = true)
	public void loadDevices() throws Exception{
		//Loading Configuration Property files
		config = new Properties();
	    fp = new FileInputStream(System.getProperty("user.dir")+"//RunProperties//RunConfig.properties");
	    config.load(fp);
	    String OS = config.getProperty("OS");
	    
		
		
		//Select Configuration on the basis of Operating System IOS or Android
	    if(OS.equalsIgnoreCase("iOS")){
	    	iOS();
	    }
	    else{
	    	Android();
	    }
		
	}
	public static void  Android() throws Exception {
		config = new Properties();
	    fp = new FileInputStream(System.getProperty("user.dir")+"//RunProperties//Android.properties");
	    config.load(fp);
	    
	    String deviceOrientation = config.getProperty("deviceOrientation");
	    String DeviceName = config.getProperty("DeviceName");
	    String App = config.getProperty("APP");
	    
		File classpathRoot = new File(System.getProperty("user.dir"));
		System.out.println(classpathRoot);
        File appDir = new File(classpathRoot, "src/resources");
	    File app = new File(appDir, App);
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
//	    capabilities.setCapability("appPackage", "com.ebay.Mobile");
//	    capabilities.setCapability("appPackage", "in.amazon.mShop.android.shopping");
//	    capabilities.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
	    capabilities.setCapability("rotatable", true);
	    
	    // Initialization Android Driver
	    driver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    //Implicit Wait
	    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

		

	}
	
	public static void  iOS() throws Exception {
		config = new Properties();
	    fp = new FileInputStream(System.getProperty("user.dir")+"//RunProperties//iOS.properties");
	    config.load(fp);
	    
	    String DeviceName = config.getProperty("DeviceName");
	    String App = config.getProperty("APP");
	    String platformVersion = config.getProperty("platformVersion");
	    String deviceOrientation = config.getProperty("deviceOrientation");
	    
		File classpathRoot = new File(System.getProperty("user.dir"));
		System.out.println(classpathRoot);
        File appDir = new File(classpathRoot, "src/resources");
	    File app = new File(appDir, App);
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DeviceName);
	    capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
	    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);   
	    capabilities.setCapability("rotatable", true);
	    // Initialization iOS Driver
	    driver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	    // Implicit wait
	    driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

	}

  

  @AfterMethod(alwaysRun = true)
  public void afterMethod() {
	  driver.quit();
  }

}
