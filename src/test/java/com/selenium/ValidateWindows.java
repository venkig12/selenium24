package com.selenium;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebElement;
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

import com.Pages.FramesPOM;
import com.Pages.WindowsPOM;
import com.utility.Library;

public class ValidateWindows extends Library {

	@Test(priority = 1)
	public void ValidateNewTab() {
		System.out.println("inside ValidateNewTab");
		driver.get(objProp.getProperty("windowsURL"));
		PageLoadTimeOut();
		WindowsPOM objWindowsPOM = new WindowsPOM(driver);
		String parentWindow = driver.getWindowHandle();
		objWindowsPOM.NewTab.click();
		PageLoadTimeOut();
		Set<String> AllWindows = driver.getWindowHandles();
		for (String Individualwindow : AllWindows) {
			driver.switchTo().window(Individualwindow);
			String pageSource = driver.getPageSource();
			System.out.println("page source :" + pageSource);
			if (pageSource.contains(objProp.getProperty("newTabtextDisplayed"))) {
				String textDisplayed = objWindowsPOM.MessageDispalyed.getText();
				Assert.assertEquals(textDisplayed, objProp.getProperty("newTabtextDisplayed"));
				driver.close();
			}
		}
		driver.switchTo().window(parentWindow);
	}

	@Test(priority = 2)
	public void ValidateNewWindow() {
		System.out.println("inside ValidateNewWindow");
		// driver

	}

	@Test(priority = 2)
	public void ValidateNewWindowMessage() {
		System.out.println("inside ValidateNewWindowMessage");

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
		// driver.close();//close the browser that is currently active by web driver
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		System.out.println(objProp.getProperty("application"));
		LaunchBrowser();

	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() throws IOException {
		System.out.println("inside beforeSuite");
		System.out.println(System.getProperty("user.dir"));
		ReadPropertiesFile();
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}

}
