package com.tests;

import org.testng.annotations.*;
import com.pageobject.ebay.eBayHome;
import com.pageobject.ebay.eBaySearchResult;
import com.pageobject.ebay.eBaySearchPage;
import com.pageobject.ebay.eBayProductDetail;
import com.test.eBay.android.BaseClass;
import com.test.eBay.android.WebDriverWaitUtils;

public class ProductPurchase extends BaseClass {
	
	private eBayHome ebayHome;
	private eBaySearchResult eBaySearchResult;
	private eBaySearchPage eBaySearchPage;
	private eBayProductDetail eBayProductDetail;

	
	@Test
	public void purchaseProduct() throws Exception{
		
		ebayHome = new eBayHome();
		eBaySearchResult = new eBaySearchResult();
		eBaySearchPage = new eBaySearchPage();
		eBayProductDetail= new eBayProductDetail();
		
		WebDriverWaitUtils.waitElementToBeVisible(ebayHome.signInButton);
		ebayHome.clickSearch();
		eBaySearchPage.searchInfo();
		eBaySearchResult.navigateToProductInfo();
		eBayProductDetail.purchaseProduct();
	}
}
