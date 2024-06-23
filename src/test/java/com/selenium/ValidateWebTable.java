package com.selenium;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.By;
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
import com.Pages.WebTablePOM;
import com.Pages.WindowsPOM;
import com.Utility.Library;


public class ValidateWebTable extends Library {
	HashMap<String, String> hmap = new HashMap<String, String>();

	@Test(priority = 1)
	public void ValidatewebTable() {
		System.out.println("inside ValidatewebTable");
		driver.get(objProp.getProperty("WebTableURL"));
		PageLoadTimeOut();
		WebTablePOM objWebTable = new WebTablePOM(driver);

		scrollIntoView(objWebTable.webtable);
		// List<WebElement> AllLastNames =
		// driver.findElements(By.xpath("//table[@id='example']/tbody/tr/td[3]"));
		
		List<WebElement> AllLastNames = objWebTable.AllLastNames;
		for (int page = 1; page <=6; page++) {
			for (int row = 0; row <= AllLastNames.size() - 1; row++) {
				String LastName = AllLastNames.get(row).getText();
				if (LastName.equals(objProp.getProperty("WebTableLastName"))) {
					row = row + 1;
					WebTablePOM objWebtablePOM = new WebTablePOM(driver);
					String FirstName = driver.findElement(objWebtablePOM.getFirstName(row)).getText();
					String Position = driver.findElement(objWebtablePOM.getPosition(row)).getText();
					String Office = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[5]")).getText();
					String StarteDate = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[6]")).getText();
					String Salary = driver.findElement(By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[7]")).getText();
					hmap.put("FirstName", FirstName);
					hmap.put("LastName", LastName);
					hmap.put("Position", Position);
					hmap.put("Office", Office);
					hmap.put("StarteDate", StarteDate);
					hmap.put("Salary", Salary);
					System.out.println("salary from hmap:" + hmap.get("Salary"));
					break;
				} 
			}
			if(hmap.isEmpty()) {
				objWebTable.NextPageInTable.click();
			}
		}
	}


	@Test(priority = 2)
	public void ValidateEmployeInfoStored() {
		for (Entry<String, String> map : hmap.entrySet()) {
			System.out.println(map.getKey() + ":" + map.getValue());
		}
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
