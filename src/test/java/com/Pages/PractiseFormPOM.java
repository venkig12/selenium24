package com.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PractiseFormPOM {
	WebDriver driver; //instance variable
	
	//note: if local variable and instance variable are same then we are going to use this keyword 
	//constructor : method which is having same name as a class name and it is used
	//for initializing the instance variables
	
	public PractiseFormPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="dateOfBirthInput")
	public WebElement DateOfBirth;
	
	@FindBy(xpath="//select[@class='react-datepicker__month-select']")
	public WebElement MonthDropDown;
	
	@FindBy(xpath="//select[@class='react-datepicker__year-select']")
	public WebElement YearDropDown;
	
	@FindBy(xpath="//div[@class='react-datepicker__month-container']/div[2]/div/div")
	public List<WebElement> AllDays;

}
