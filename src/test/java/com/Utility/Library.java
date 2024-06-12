package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Library {
	public static Properties objProp;
	public static WebDriver driver;
	HashMap<String, String> hmap = new HashMap<String, String>();
	
	public static ExtentHtmlReporter ExtHtmlReporter ;
	public static ExtentReports ExtReports;
	public static ExtentTest ExtTest;
	
	/*
	 * ExtentHtmlReporter : responsible for look and feel of the report ,we can
	 * specify the report name , document title , theme of the report
	 * 
	 * ExtentReports : used to create entries in your report , create test cases in
	 * report , who executed the test case, environment name , browser
	 * 
	 * ExtentTest : update pass fail and skips and logs the test cases results
	 */
	
	public void StartExtentReport() {
		// TODO Auto-generated method stub
		File objFile = new File(System.getProperty("user.dir")+"//test-output//ExtentReportV4.html");
		ExtentHtmlReporter objExtentHtmlReporter = new ExtentHtmlReporter(objFile);
		objExtentHtmlReporter.config().setDocumentTitle("Automation Report");
		objExtentHtmlReporter.config().setReportName("Extent Report");
		objExtentHtmlReporter.config().setTheme(Theme.DARK);
		ExtReports = new ExtentReports();
		ExtReports.attachReporter(objExtentHtmlReporter);
		
		ExtReports.setSystemInfo("TesterName", "Raghuveer");
		ExtReports.setSystemInfo("Broswer", objProp.getProperty("Browser"));
		ExtReports.setSystemInfo("Environment", "UAT");
		
	}
	
	public void UpdatingResultInExtentReport(ITestResult result) {
		// TODO Auto-generated method stub
		if(result.getStatus()==ITestResult.SUCCESS) {
			ExtTest.log(Status.PASS, "Test Case Passed is "+result.getName());
		}else if(result.getStatus()==ITestResult.FAILURE) {
			ExtTest.log(Status.FAIL, "Test Case Failed is "+result.getName());
			ExtTest.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());
			try {
				ExtTest.addScreenCaptureFromPath(TakeScreenShot(result.getName()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(result.getStatus()==ITestResult.SKIP) {
			ExtTest.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}
	}
	
	/* Author : Raghuveer
	 * This method is used to take screen shot and store the screen shots in side ScreenShot folder
	 */
	public static String TakeScreenShot(String testcaseName) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String dateName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String destination = System.getProperty("user.dir") + "//ScreenShots//" + dateName + testcaseName+"captured.jpeg";
		FileUtils.copyFile(src, new File(destination));
		return destination;
	}
	
	public void FlushReport() {
		ExtReports.flush();
	}
	
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
	
	//below is the method for selenium 4
		public WebDriver getBrowserCapabilities(String BrowserName) {
			if (BrowserName == null || BrowserName.equalsIgnoreCase("FIREFOX")) {
				FirefoxOptions options = new FirefoxOptions();
				// options.setHeadless(headless);
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (BrowserName.equalsIgnoreCase("IE")) {
				// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
				// true);
				// capabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION,
				// true);
				InternetExplorerOptions options = new InternetExplorerOptions();
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (BrowserName.equalsIgnoreCase("CHROME")) {
				ChromeOptions options = new ChromeOptions();
				// options.setHeadless(headless);
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (BrowserName.equalsIgnoreCase("EDGE")) {
				EdgeOptions options = new EdgeOptions();
				try {
					driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			return driver;
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
	
	public WebDriver initializeBrowser(String broswerName) {
		DesiredCapabilities dc = new DesiredCapabilities();
		if (broswerName.equals("chrome")) {
			dc.setBrowserName("chrome");
		} else if (broswerName.equals("firefox")) {
			dc.setBrowserName("firefox");
		} else if (broswerName.equals("safari")) {
			dc.setBrowserName("safari");
		} else if (broswerName.equals("Edge")) {
			dc.setBrowserName("Edge");
		} else if (broswerName.equals("ie")) {
			dc.setBrowserName("ie");
		}
		try {
			driver = new RemoteWebDriver(new URL("http://localhost:4444"), dc);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver;
	}

	
	public static void PageLoadTimeOut() {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Constants.pageLoadTimeout));
	}
	
	public void scrollIntoView(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",element);
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
