package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class FirstSeleniumProgram {
	static WebDriver driver;
	public static void main(String[] args) {

		// TODO Auto-generated method stub

		driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("samsungs22mobiles");
		driver.findElement(By.id("nav-search-submit-button")).click();

	}

}
