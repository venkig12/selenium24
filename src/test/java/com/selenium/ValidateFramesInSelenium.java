package com.selenium;

import org.testng.annotations.Test;

import com.Pages.AlertsPOM;
import com.Pages.FramesPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateFramesInSelenium extends Library{
  @Test(priority=-1)
  public void ValidateLoadingOfDemoutomationTestingFramesPage() {
	  System.out.println("inside ValidateLoadingOfDemoutomationTestingFramesPage");
	  driver.get(objProp.getProperty("FramesURL"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), Constants.framesPageTitle);
  }
  
  @Test(priority = 1)
public void ValidateSingleFrame() {
	  System.out.println("inside ValidateSingleFrame");
	  driver.switchTo().frame("SingleFrame");
	  FramesPOM objFramesPOM = new FramesPOM(driver);
	  objFramesPOM.TextBox.sendKeys(objProp.getProperty("SingleFrameText"));
	  driver.switchTo().defaultContent();//to come out of frame and go back to the main html document
	  objFramesPOM.IframeWithInIframeButton.click();
  }
  
  @Test(priority=2)
  public void ValidateMultipleFrames() {
	  System.out.println("ValidateMultipleFrames");
	  FramesPOM objFramesPOM = new FramesPOM(driver);
	  driver.switchTo().frame(objFramesPOM.OuterFrameInMultipleFrames);
	  driver.switchTo().frame(objFramesPOM.InnerFrameInMultipleFrames);
	  objFramesPOM.TextBox.sendKeys(objProp.getProperty("IframeWithInIframeText"));
	  driver.switchTo().defaultContent();
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
