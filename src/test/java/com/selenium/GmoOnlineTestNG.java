package com.selenium;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.GmoOnlinePOM;
import com.Utility.Constants;
import com.Utility.Library;

public class GmoOnlineTestNG extends Library {

	@Test(priority = 0)
	public void ValidateGmoOnLineAppLoading() {
		driver.get(objProp.getProperty("GmoOnlineURL"));
		PageLoadTimeOut();
		String HomePageTitle = driver.getTitle();
		System.out.println("HomePageTitle:" + HomePageTitle);
		Assert.assertEquals(HomePageTitle, Constants.GmoOnlineTitle);
	}

	@Test(priority = 1,dependsOnMethods= {"ValidateGmoOnLineAppLoading"})
	public void ValidateEneterGMOonline() {
		GmoOnlinePOM objgmoOnlinePOM = new GmoOnlinePOM(driver);
		objgmoOnlinePOM.clickOnEnterGmoOnlineButton();
		String OnlineCatalogTitle = driver.getTitle();
		System.out.println("OnlineCatalogTitle:" + OnlineCatalogTitle);
		Assert.assertEquals(OnlineCatalogTitle, Constants.OnlineCatalogTitle);
	}

	@Test(priority = 2,dependsOnMethods= {"ValidateGmoOnLineAppLoading","ValidateEneterGMOonline"})
	public void SelectSunGlassesProduct() {
		GmoOnlinePOM objgmoOnlinePOM = new GmoOnlinePOM(driver);
		objgmoOnlinePOM.QTY_GLASSES.clear();
		objgmoOnlinePOM.QTY_GLASSES.sendKeys(Constants.QTY_Glasses);
		objgmoOnlinePOM.PlaceAnOrder.click();
	}

	@Test(priority = 3,dependsOnMethods= {"ValidateGmoOnLineAppLoading","ValidateEneterGMOonline","SelectSunGlassesProduct"})

	public void ValidatePriceCalculationOnPlaceOrderPage() {
		GmoOnlinePOM objgmoOnlinePOM = new GmoOnlinePOM(driver);
		String placeOrderTitle = driver.getTitle();
		System.out.println("placeOrderTitle:" + placeOrderTitle);
		Assert.assertEquals(placeOrderTitle, Constants.PlaceOrderTitle);
		String UnitPrice = objgmoOnlinePOM.UnitPrice.getText();
		System.out.println("UnitPrice:" + UnitPrice);
		String floatValueOfUnitPrice = UnitPrice.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:" + floatValueOfUnitPrice);
		float calculatedUnitprice = Float.parseFloat(floatValueOfUnitPrice) * 3;
		System.out.println("calculatedUnitprice:" + calculatedUnitprice);
		String totalPriceDisplayed = objgmoOnlinePOM.TotalPriceDisplayed.getText();
		float floatValueOfTotalPrice = Float.parseFloat(totalPriceDisplayed.substring(2).trim());
		Assert.assertEquals(calculatedUnitprice, floatValueOfTotalPrice);
		System.out.println("floatValueOfTotalPrice:" + floatValueOfTotalPrice);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			ReadPropertiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
