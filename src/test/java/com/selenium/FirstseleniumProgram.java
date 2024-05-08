package com.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class FirstseleniumProgram {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver= new EdgeDriver(); 
		driver.get("https://www.costco.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(200));
		String title= driver.getTitle();
		System.out.println(title);
		Assert.assertEquals(title, "Welcome to Costco Wholesale");
		driver.findElement(By.id("search-field")).sendKeys("samsung s24 mobiles");
		
	   driver.findElement(By.xpath("//i[@automation-id='searchWidgetButton']")).click();
		driver.close();
	
}
}