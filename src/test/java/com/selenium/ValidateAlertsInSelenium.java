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
  
  @Test(priority = 1, dependsOnMethods = { "ValidateNormalAlert"})
	public void validateTimerAlert() {
		System.out.println("inside validateTimerAlert");
		AlertsPOM objDemoQaAlertsPOM = new AlertsPOM(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].scrollIntoView(true);",objDemoQaAlertsPOM.TimerAlertButton);
		objDemoQaAlertsPOM.TimerAlertButton.click();
		
		//Explicit wait : Applicable for only one particular web element by providing a condition
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.ExplicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert objAlert = driver.switchTo().alert();
		String TextOfNormalAlert = objAlert.getText();
		Assert.assertEquals(TextOfNormalAlert, Constants.TimerAlertText);
		objAlert.accept();
	}
	
	@Test(priority=2,dependsOnMethods= {"validateTimerAlert","ValidateNormalAlert"})
	public void validateConfirmBoxAlert() {
		System.out.println("inside validateConfirmBoxAlert");
		AlertsPOM objDemoQaAlertsPOM = new AlertsPOM(driver);
		objDemoQaAlertsPOM.confirmAlertButton.click();
		Alert objAlert = driver.switchTo().alert();
		String TextOfConfirmBoxAlert = objAlert.getText();
		Assert.assertEquals(TextOfConfirmBoxAlert, Constants.ConfirmBoxAlertText);
		objAlert.dismiss();
		String ConfirmBoxResult=objDemoQaAlertsPOM.confirmResult.getText();
		Assert.assertEquals(ConfirmBoxResult, Constants.ConfirmBoxResult, "Confirm Box Result is not validated");
	}
	
	@Test(priority=3,dependsOnMethods= {"validateConfirmBoxAlert","ValidateNormalAlert","validateTimerAlert"})
	public void validatePromptBoxAlert() {
		System.out.println("inside validatePromptBoxAlert");
		AlertsPOM objDemoQaAlertsPOM = new AlertsPOM(driver);
		objDemoQaAlertsPOM.promptAlertButton.click();
		Alert objAlert = driver.switchTo().alert();
		objAlert.sendKeys(Constants.PromptBoxAlertMessage);
		objAlert.accept();
		String ResultOfPromptBox = objDemoQaAlertsPOM.PromptBoxResult.getText();
		Assert.assertEquals(ResultOfPromptBox, Constants.PrompBoxAlertResult, "Prompt Box Result is not validated");
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
