package com.selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.Pages.GmoOnlinePOM;
import com.utility.Constants;
import com.utility.Library;

public class GmoOnline2 extends Library{
	
	public static void main(String[] args) throws IOException {
	ReadPropertiesFile();
	LaunchBrowser();
	driver.get(objProp.getProperty("GmoOnlineURL"));
	PageLoadTimeOut();
	String HomePageTitle = driver.getTitle();
	System.out.println("HomePageTitle:"+HomePageTitle);
	Assert.assertEquals(HomePageTitle, Constants.GmoOnlineTitle);
	//driver.findElement(By.name("bSubmit")).click();
	
	GmoOnlinePOM objgmoOnlinePOM = new GmoOnlinePOM(driver);
	//objgmoOnlinePOM.EnterGmoOnline.click();
	objgmoOnlinePOM.clickOnEnterGmoOnlineButton();
	
	String OnlineCatalogTitle = driver.getTitle();
	System.out.println("OnlineCatalogTitle:"+OnlineCatalogTitle);
	Assert.assertEquals(OnlineCatalogTitle, Constants.OnlineCatalogTitle);
	
//	driver.findElement(By.name("QTY_GLASSES")).clear();
//	driver.findElement(By.name("QTY_GLASSES")).sendKeys("3");

	objgmoOnlinePOM.QTY_GLASSES.clear();
	objgmoOnlinePOM.QTY_GLASSES.sendKeys(Constants.QTY_Glasses);
	
	//driver.findElement(By.xpath("//input[@value='Place An Order']")).click();
	objgmoOnlinePOM.PlaceAnOrder.click();
	
	String placeOrderTitle = driver.getTitle();
	System.out.println("placeOrderTitle:"+placeOrderTitle);
	Assert.assertEquals(placeOrderTitle, Constants.PlaceOrderTitle);
	
	//String UnitPrice=driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[4]")).getText();
	String UnitPrice= objgmoOnlinePOM.UnitPrice.getText();
	System.out.println("UnitPrice:"+UnitPrice);
	String floatValueOfUnitPrice= UnitPrice.substring(2).trim();
	System.out.println("floatValueOfUnitPrice:"+floatValueOfUnitPrice);
	float calculatedUnitprice=Float.parseFloat(floatValueOfUnitPrice)*3;
	System.out.println("calculatedUnitprice:"+calculatedUnitprice);
	//String totalPriceDisplayed = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[5]")).getText();
	String totalPriceDisplayed =objgmoOnlinePOM.TotalPriceDisplayed.getText();
	float floatValueOfTotalPrice = Float.parseFloat(totalPriceDisplayed.substring(2).trim());
	Assert.assertEquals(calculatedUnitprice, floatValueOfTotalPrice);
	System.out.println("floatValueOfTotalPrice:"+floatValueOfTotalPrice);
	}
	

}
