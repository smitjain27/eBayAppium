package com.sm.name.ebayAppium;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;


public class Basic extends BaseClass  {


@Test
public void testCal() throws Exception {
	driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	Calculator calc=new Calculator(driver);
	calc.clickFive();
	calc.clickPlus();
	calc.clickFour();
	calc.clickEqualsTo();
	String results=calc.getResult();
   //locate the Text on the calculator by using By.name()
//   WebElement five=driver.findElement(By.xpath("//android.widget.Button[@text='5']"));
//   five.click();
//   WebElement plus=driver.findElement(By.xpath("//android.widget.Button[@text='+']"));
//   plus.click();
//   WebElement four=driver.findElement(By.xpath("//android.widget.Button[@text='4']"));
//   four.click();
//   WebElement equalTo=driver.findElement(By.xpath("//android.widget.Button[@text='=']"));
//   equalTo.click();
   //locate the edit box of the calculator by using By.tagName()
//   WebElement results=driver.findElement(By.id("result"));
	//Check the calculated value on the edit box
assert results.equals("9"):"Actual value is : "+results+" did not match with expected value: 6";

}


}