package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

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

}
