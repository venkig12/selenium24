package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowsPOM {
	WebDriver driver;
	
	public WindowsPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="tabButton")
	public WebElement NewTab;
	
	@FindBy(id="windowButton")
	public WebElement NewWindowButton;
	
	@FindBy(id="messageWindowButton")
	public WebElement NewWindowMessage;
	
	@FindBy(xpath="//h1[text()='This is a sample page']")
	public WebElement MessageDispalyed;
	
	
}
