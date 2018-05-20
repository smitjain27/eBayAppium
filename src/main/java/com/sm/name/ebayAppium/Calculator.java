package com.sm.name.ebayAppium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


class Calculator {
	private WebDriver driver=null;
	public Calculator(WebDriver driver) {           
		this.driver = driver; 
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//android.widget.Button[@text='5']")
	private WebElement five;
	@FindBy(xpath="//android.widget.Button[@text='+']")
	private WebElement plus;
	@FindBy(xpath="//android.widget.Button[@text='4']")
	private WebElement four;
	@FindBy(xpath="//android.widget.Button[@text='=']")
	private WebElement equalTo;
	@FindBy(id="result")
	private WebElement results;
	
	public void clickFive(){
		five.click();
	}
	public void clickPlus(){
		plus.click();
	}
	public void clickFour(){
		four.click();
	}
	public void clickEqualsTo(){
		equalTo.click();
	}
	public String getResult(){
		return results.getText();
	}
}
