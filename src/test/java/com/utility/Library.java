package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Library {
	public static Properties objProp;
	public static WebDriver driver;
	HashMap<String, String> hmap = new HashMap<String, String>();
	public static void ReadPropertiesFile() throws IOException {
		System.out.println("path where project is stored:"+System.getProperty("user.dir"));
		try {
		File objFile = new File(System.getProperty("user.dir")+"//src//test//resources//configuration//project.properties"); 
		FileInputStream objFileInput = new FileInputStream(objFile);
		objProp = new Properties();
		objProp.load(objFileInput);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void LaunchBrowser() {
		String browerName = objProp.getProperty("browser");
		switch(browerName.toLowerCase()) {
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			File objFile = new File (System.getProperty("user.dir")+"//addBlocker//extension_5.21.0.crx");
			options.addExtensions(objFile);
			driver=new ChromeDriver(options);
			break;
		case "ie":
			driver=new InternetExplorerDriver();
			break;
		}
		driver.manage().window().maximize();
		//implicit wait : It is a global waiting mechanism which is applicable for all web elements 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		
	}
	
	public static void PageLoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.pageLoadTimeout));
	}
	
	public void scrollIntoView(WebElement webtable) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",webtable);
	}
	
	public HashMap<String, String> ReadExcelTestDataFile(XSSFSheet objXSSFSheet, int row) {
		// TODO Auto-generated method stub
		DataFormatter objDataFormatter = new DataFormatter();
		hmap.put("RunMode", objXSSFSheet.getRow(row).getCell(0).getStringCellValue());
		hmap.put("TestCaseName", objXSSFSheet.getRow(row).getCell(1).getStringCellValue());
		hmap.put("FirstName", objXSSFSheet.getRow(row).getCell(2).getStringCellValue());
		hmap.put("LastName", objXSSFSheet.getRow(row).getCell(3).getStringCellValue());
		hmap.put("Address", objXSSFSheet.getRow(row).getCell(4).getStringCellValue());
		hmap.put("Email Address", objXSSFSheet.getRow(row).getCell(5).getStringCellValue());

		hmap.put("PhoneNumber", objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(6)));

		hmap.put("Gender", objXSSFSheet.getRow(row).getCell(7).getStringCellValue());
		hmap.put("Hobbies", objXSSFSheet.getRow(row).getCell(8).getStringCellValue());
		hmap.put("Languages", objXSSFSheet.getRow(row).getCell(9).getStringCellValue());
		hmap.put("Skills", objXSSFSheet.getRow(row).getCell(10).getStringCellValue());
		hmap.put("Country", objXSSFSheet.getRow(row).getCell(11).getStringCellValue());
		hmap.put("SelectCountry", objXSSFSheet.getRow(row).getCell(12).getStringCellValue());

		hmap.put("DOB_YY", objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(13)));

		hmap.put("DOB_MM", objXSSFSheet.getRow(row).getCell(14).getStringCellValue());

		hmap.put("DOB_DD", objDataFormatter.formatCellValue(objXSSFSheet.getRow(row).getCell(15)));

		hmap.put("Password", objXSSFSheet.getRow(row).getCell(16).getStringCellValue());
		hmap.put("Confirm Password", objXSSFSheet.getRow(row).getCell(17).getStringCellValue());
		return hmap;
	}

	public void WriteToExcelFile(int row, XSSFSheet objXSSFSheet) {

		objXSSFSheet.getRow(row).createCell(18).setCellValue("Pass");

	}
	
	public void SelectValueFromDropDown(List<WebElement> AllDropDownItems, String ExpectedDropDownValue) {
		int Count = AllDropDownItems.size();
		for (int i = 0; i <= Count - 1; i++) {
			WebElement DropDownItem = AllDropDownItems.get(i);
			String IndividualDropDownValue = DropDownItem.getText();
			if (IndividualDropDownValue.equalsIgnoreCase(ExpectedDropDownValue)) {
				AllDropDownItems.get(i).click();
				break;
			}
		}
	}
	

}
