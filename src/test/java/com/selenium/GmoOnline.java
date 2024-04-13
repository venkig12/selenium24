package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class GmoOnline {
	static WebDriver driver;
	public static void main(String[] args) {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demo.borland.com/gmopost/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	String HomePageTitle = driver.getTitle();
	System.out.println("HomePageTitle:"+HomePageTitle);
	Assert.assertEquals(HomePageTitle, "Welcome to Green Mountain Outpost");
	driver.findElement(By.name("bSubmit")).click();
	String OnlineCatalogTitle = driver.getTitle();
	System.out.println("OnlineCatalogTitle:"+OnlineCatalogTitle);
	Assert.assertEquals(OnlineCatalogTitle, "OnLine Catalog");
	driver.findElement(By.name("QTY_GLASSES")).clear();
	driver.findElement(By.name("QTY_GLASSES")).sendKeys("3");
	driver.findElement(By.xpath("//input[@value='Place An Order']")).click();
	String placeOrderTitle = driver.getTitle();
	System.out.println("placeOrderTitle:"+placeOrderTitle);
	Assert.assertEquals(placeOrderTitle, "Place Order");
	String UnitPrice=driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[4]")).getText();
	System.out.println("UnitPrice:"+UnitPrice);
	String floatValueOfUnitPrice= UnitPrice.substring(2).trim();
	System.out.println("floatValueOfUnitPrice:"+floatValueOfUnitPrice);
	float calculatedUnitprice=Float.parseFloat(floatValueOfUnitPrice)*3;
	System.out.println("calculatedUnitprice:"+calculatedUnitprice);
	String totalPriceDisplayed = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[5]")).getText();
	float floatValueOfTotalPrice = Float.parseFloat(totalPriceDisplayed.substring(2).trim());
	Assert.assertEquals(calculatedUnitprice, floatValueOfTotalPrice);
	System.out.println("floatValueOfTotalPrice:"+floatValueOfTotalPrice);
	}

}
