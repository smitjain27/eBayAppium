package com.pageobject.ebay;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.test.eBay.android.BaseClass;
import com.test.eBay.android.WebDriverWaitUtils;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class eBayProductDetail extends BaseClass {
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ORIGINAL MI CHARGER FOR  XIAOMI REDMI NOTE 5/PRO 4 3, YI/LITE 2AMP Adapter+CABLE']") public WebElement selectedProduct;
	@AndroidFindBy(xpath="//android.widget.Button[@text='SORT']") public WebElement SortButton;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='₹199.00-₹415.00']") public WebElement productPrice;
	@AndroidFindBy(xpath="//android.widget.Button[@text='BUY IT NOW']") public WebElement Purchase;
	
	public eBayProductDetail() throws Exception {
		PageFactory.initElements(new AppiumFieldDecorator(driver, 10, TimeUnit.SECONDS), this);
	}

	public void purchaseProduct() {
		WebDriverWaitUtils.waitElementToBeVisible(selectedProduct);
		WebDriverWaitUtils.waitElementToBeVisible(productPrice);
		Purchase.click();
		WebDriverWaitUtils.waitForElementToBeInVisible(Purchase);
	
	}
		
}

