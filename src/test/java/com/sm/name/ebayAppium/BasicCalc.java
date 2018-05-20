package com.sm.name.ebayAppium;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class BasicCalc extends BaseClass  {


@Test
public void testCal() throws Exception {
	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	Calculator calc=new Calculator(driver);
	calc.clickFive();
	calc.clickPlus();
	calc.clickFour();
	calc.clickEqualsTo();
	String results=calc.getResult();
assert results.equals("9"):"Actual value is : "+results+" did not match with expected value: 9";

}


}