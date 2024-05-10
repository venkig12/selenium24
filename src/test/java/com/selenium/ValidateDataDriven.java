package com.selenium;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import com.Pages.DataDrivenPOM;
import com.Pages.FramesPOM;
import com.Pages.WebTablePOM;
import com.Pages.WindowsPOM;
import com.utility.Library;

public class ValidateDataDriven extends Library {
	HashMap<String, String> hmap = new HashMap<String, String>();

	@Test(priority = 1)
	public void ValidateAutomationRegister() throws IOException, AWTException {
		System.out.println("inside ValidateAutomationRegister");
		driver.get(objProp.getProperty("AutomationRegister"));
		PageLoadTimeOut();
		//read the excel file
		try {
		File objFile = new File(System.getProperty("user.dir")+"//src//test//resources//TestData//AutomationDemoSite.xlsx");
		FileInputStream objFileInput = new FileInputStream(objFile);
		
		//if .xls is the extension 
		
		//HSSFWorkbook objHSSFWB = new HSSFWorkbook(objFileInput);
		//HSSFSheet objHSSFSheet =objHSSFWB.getSheet("TestData");
				
		//if .xlsx is the extension 
		
		XSSFWorkbook objXSSFWB = new XSSFWorkbook(objFileInput);
		XSSFSheet objXSSFSheet =objXSSFWB.getSheet("TestData");
		
		int Rows = objXSSFSheet.getLastRowNum();
		for(int row =1 ; row<=Rows;row++) {
			System.out.println("---------------------------------------");
			for (Map.Entry<String, String> map : hmap.entrySet()) {
				System.out.println(map.getKey() + ":" + map.getValue());
			}
			
			hmap=ReadExcelTestDataFile(objXSSFSheet,row);

			if(hmap.get("RunMode").equalsIgnoreCase("yes")) {
			DataDrivenPOM objDDPOM = new DataDrivenPOM(driver);
			
			objDDPOM.FirstName.clear();
			objDDPOM.FirstName.sendKeys(hmap.get("FirstName"));
			
			objDDPOM.LastName.clear();
			objDDPOM.LastName.sendKeys(hmap.get("LastName"));
			
			objDDPOM.Adress.clear();
			objDDPOM.Adress.sendKeys(hmap.get("Address"));
			
			objDDPOM.Email.clear();
			objDDPOM.Email.sendKeys(hmap.get("Email Address"));
			
			objDDPOM.Phone.clear();
			objDDPOM.Phone.sendKeys(hmap.get("PhoneNumber"));
			
			if(hmap.get("Gender").equals("Male")) {
				objDDPOM.Male.click();
			}else {
				objDDPOM.Female.click();
			}
			
			if(hmap.get("Hobbies").equals("Cricket")) {
				objDDPOM.Cricket.click();
			}else if (hmap.get("Hobbies").equals("Hockey")){
				objDDPOM.Hockey.click();
			}else {
				objDDPOM.Movies.click();
			}
			
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("window.scrollBy(0,500)");
			
			if(row>1) {
				objDDPOM.closeSelectedLanguage.click();
			}
			
			objDDPOM.Langugaes.click();
			SelectValueFromDropDown(objDDPOM.AllLanguages,hmap.get("Languages"));
			
			objDDPOM.SkillsField.click();
			
			objDDPOM.Skills.click();
			SelectValueFromDropDown(objDDPOM.Allskills,hmap.get("Skills"));
			
			objDDPOM.SelectCountry.click();
			objDDPOM.TextBoxOfCountry.sendKeys(hmap.get("SelectCountry"));
			
			Robot objRobot = new Robot();
			objRobot.keyPress(KeyEvent.VK_ENTER);
			objRobot.keyRelease(KeyEvent.VK_ENTER);
			
			objDDPOM.DOB_YEAR.click();
			SelectValueFromDropDown(objDDPOM.AllYears,hmap.get("DOB_YY"));
			
			objDDPOM.DOB_Month.click();
			SelectValueFromDropDown(objDDPOM.AllMonths,hmap.get("DOB_MM"));
			
			objDDPOM.DOB_DAY.click();
			SelectValueFromDropDown(objDDPOM.AllDays,hmap.get("DOB_DD"));
			
			objDDPOM.Password.clear();
			objDDPOM.Password.sendKeys(hmap.get("Password"));
			
			objDDPOM.Conformpassword.clear();
			objDDPOM.Conformpassword.sendKeys(hmap.get("Confirm Password"));
			
			FileOutputStream objFileOutPut = new FileOutputStream(objFile);
			WriteToExcelFile(row, objXSSFSheet);
			objXSSFWB.write(objFileOutPut);
			}else {
				int row1 = row + 1;
				System.out.println("Run Mode is not marked as Yes in the test data excel");
			}
		}
		objXSSFWB.close();
		objFileInput.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
