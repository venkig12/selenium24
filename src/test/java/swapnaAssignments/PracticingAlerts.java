package swapnaAssignments;

import org.testng.annotations.Test;

import com.Pages.PracticeAlertPom;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class PracticingAlerts extends Library {
	@Test(priority = -1)
	public void LaunchingAlert() {
		System.out.println("Launching Alert Website");
		driver.get(objProp.getProperty("PAlertUrl"));
		PageLoadTimeOut();
	}

	@Test(priority = 1, dependsOnMethods = { "LaunchingAlert" })
	public void Alert1() {
		System.out.println("Alert");
		PracticeAlertPom objPracticeAlertPom = new PracticeAlertPom(driver);
		objPracticeAlertPom.NormalAlert.click();
		Alert objAlert = driver.switchTo().alert();
		String TitleOfAlert1 = objAlert.getText();
		Assert.assertEquals(TitleOfAlert1, Constants.AlertText);
		objAlert.accept();

	}

	@Test(priority = 2, dependsOnMethods = { "LaunchingAlert", "Alert1" })
	public void ConfirmationBoxAlert() {
		System.out.println("ConfirmationBoxAlert");
		PracticeAlertPom objPracticeAlertPom = new PracticeAlertPom(driver);
		objPracticeAlertPom.ConfirmationAlert.click();
		Alert objAlert = driver.switchTo().alert();
		String TitleOfConfirmation = objAlert.getText();
		Assert.assertEquals(TitleOfConfirmation, Constants.ConfirmationBoxText);
		objAlert.accept();

	}

	@Test(priority = 3, dependsOnMethods = { "LaunchingAlert", "Alert1", "ConfirmationBoxAlert" })
	public void PromptAlert() {
		System.out.println("PromptAlert");
		PracticeAlertPom objPracticeAlertPom = new PracticeAlertPom(driver);
		objPracticeAlertPom.PromptBoxAlert.click();
		Alert objAlert = driver.switchTo().alert();
		objAlert.sendKeys(Constants.PBoxMessage);
		objAlert.accept();

	}

	@Test(priority = 3, dependsOnMethods = { "LaunchingAlert", "Alert1", "ConfirmationBoxAlert", "PromptAlert" })
	public void DoubleClick() {
		System.out.println("DoubleClick");
		PracticeAlertPom objPracticeAlertPom = new PracticeAlertPom(driver);

		Actions objActions = new Actions(driver);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		objActions.doubleClick(objPracticeAlertPom.DoubleClickMe).build().perform();

		Alert objAlert = driver.switchTo().alert();
		// Assert.assertEquals(objAlert.getText(),objProp.getProperty("DoubleClick"));
		Assert.assertEquals(objAlert.getText(), Constants.DoubleClick);

		objAlert.accept();

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
		LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
	}

	@BeforeSuite
	public void beforeSuite() {
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
