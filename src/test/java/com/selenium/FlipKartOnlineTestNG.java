package com.selenium;

import org.testng.annotations.Test;

import com.Utility.Constants;
import com.Utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FlipKartOnlineTestNG extends Library {
  @Test
  public void ValidateFlipkartOnLineAppLoading() {
	  driver.get(objProp.getProperty("FlipkartURL"));
	  PageLoadTimeOut();
		String HomePageTitle = driver.getTitle();
		System.out.println("HomePageTitle:" + HomePageTitle);
		Assert.assertEquals(HomePageTitle, Constants.FlipkartTitle);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
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
  }

}
