package com.pageobject.ebay;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.eBay.android.BaseClass;
import com.test.eBay.android.WebDriverWaitUtils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;



public class eBaySearchResult extends BaseClass {
	
	public eBaySearchResult() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[2]") public WebElement product3;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='100% Brand New 2Amp Mi Charger For Xiaomi Redmi Note 4  4A  Redmi 3s 3s+']") public WebElement productSelect;
	@AndroidFindBy(xpath="//android.widget.Button[@text='SORT']") public WebElement SortButton;
	
	public void navigateToProductInfo(){
		
		WebDriverWaitUtils.waitElementToBeVisible(SortButton);

		//Swipe Function
		WebElement listViewToScroll = driver.findElement(By.className("android.widget.RelativeLayout")); 
        Point center = getCenter(listViewToScroll);

		driver.swipe(center.getY(), center.getX(), center.getY(), center.getX()-650, 1000);
		
		List<WebElement> relativeLayouts = driver.findElements(By.className("android.widget.RelativeLayout"));
		for (WebElement webElement : relativeLayouts) {
			List<WebElement> textViews = webElement.findElements(By.className("android.widget.TextView"));
			for (WebElement webElement2 : textViews) {
				if(webElement2.getText().contains("YI/LITE 2AMP Adapter"))
				{
					webElement2.click();
					break;
				}
			}
		}
		
	}
	private Point getCenter(WebElement element) {
        Point upperLeft = element.getLocation();
        Dimension dimensions = element.getSize();
        return new Point(upperLeft.getX() + dimensions.getWidth(), upperLeft.getY() + dimensions.getHeight());
    }

}
