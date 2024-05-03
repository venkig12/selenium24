package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AssignmentFramesPOM {
	WebDriver driver;

	public AssignmentFramesPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
}

	@FindBy(xpath="//*[@id='frame1']")
	public WebElement frame1;

	@FindBy(xpath = "//input[@type='text']")
	public WebElement TextBox;
	
	@FindBy(xpath="//*[@id='frame3']")
	public WebElement frame3;
	
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement InnerFrameCheckBox;
	
	@FindBy(xpath = "//*[@id='frame2']")
	public WebElement Secondframe ;
	

	@FindBy(id ="animals")
	public WebElement AnimalsSelectBox;
	

	@FindBy(xpath="//*[@id='animals']/option[3]")
	public WebElement BigBabyCatButton;
	
}
