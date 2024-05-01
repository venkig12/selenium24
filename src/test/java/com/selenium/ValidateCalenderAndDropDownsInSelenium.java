package com.selenium;

import org.testng.annotations.Test;

import com.Pages.AlertsPOM;
import com.Pages.FramesPOM;
import com.Pages.PractiseFormPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ValidateCalenderAndDropDownsInSelenium extends Library{
  @Test(priority=-1)
  public void ValidateLoadingOfDemoutomationTestingFramesPage() {
	  System.out.println("inside ValidateLoadingOfDemoutomationTestingFramesPage");
	  driver.get(objProp.getProperty("DropDownAndCalenderUrl"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(), Constants.DemoQaTitle);
  }
  
 @Test(priority = 0)
 public void ValidateCalenderDateOfBirth() {
	 System.out.println("Inside ValidateCalender");
	 JavascriptExecutor js = (JavascriptExecutor)driver;
	 js.executeScript("window.scrollBy(0,600)",""); //scroll down by 250 pixels
	 //js.executeScript("window.scrollBy(0,-250)",""); //scroll up by 250 pixels
	 //js.executeScript("window.scrollBy(250,0)",""); //scroll right by 250 pixels
	 //js.executeScript("window.scrollBy(-250,0)",""); //scroll left by 250 pixels
	 PractiseFormPOM objPractiseForm = new PractiseFormPOM(driver);
	 objPractiseForm.DateOfBirth.click();
	 Select objselectMonth = new Select(objPractiseForm.MonthDropDown);
	 objselectMonth.selectByVisibleText(objProp.getProperty("Month"));	 
	 Select objselectYear = new Select(objPractiseForm.YearDropDown);
	 objselectYear.selectByValue(objProp.getProperty("Year"));
	 List<WebElement> AllDays = objPractiseForm.AllDays;
	 for(int i=0;i<AllDays.size();i++) {
		 String dayFromCalender=AllDays.get(i).getText();
		 if(dayFromCalender.equals(objProp.getProperty("Day"))) {
			 AllDays.get(i).click();
			 break;
		 }
	 }
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
