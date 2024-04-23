package com.selenium;

import org.testng.annotations.Test;

import com.Pages.AlertsPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateAlertsInSelenium extends Library{
  @Test(priority=-1)
  public void ValidateLoadingOfAlertPage() {
	  System.out.println("inside ValidateLoadingOfAlertPage");
	  driver.get(objProp.getProperty("AlertsURL"));
	  PageLoadTimeOut();
  }
  
  @Test()
  public void ValidateNormalAlert() {
	  //driver.findElement(By.id("alertButton")).click();
	  AlertsPOM objAlertsPOM = new AlertsPOM(driver);
	 // objAlertsPOM.NormalAlert.click();
	  objAlertsPOM.ClickOnNormalAlert();
	  Alert objAlert = driver.switchTo().alert();
	  String titleOfNormalAlert = objAlert.getText();
	  Assert.assertEquals(titleOfNormalAlert, Constants.NormalAlertText);
	  objAlert.accept();
  }
  
  @Test(priority=1)
  public void ValidateTimerAlert() {
  }
  
  @Test(priority=2)
  public void ValidateConformBoxAlert() {
  }
  
  @Test(priority=3)
  public void ValidateTextBoxAlert() {
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Inside beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("Inside afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Inside beforeTest");
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("Inside afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Inside beforeSuite");
	  try {
		ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("Inside afterSuite");
  }

}
