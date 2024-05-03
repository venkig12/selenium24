package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticeAlertPom {
	WebDriver driver;
	
	public PracticeAlertPom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name ="alert" )
	public WebElement NormalAlert;
	
	@FindBy(name="confirmation")
	public WebElement ConfirmationAlert;
	
	@FindBy(name="prompt")
	public WebElement PromptBoxAlert;
	
	@FindBy(name="download")
	public WebElement FileDownloadAlert;
	
	@FindBy(xpath="//a[text()='Download PDF File']")
	public WebElement ChooseFileButton ;
	
	@FindBy(xpath="//*[@id='double-click']")
	public WebElement DoubleClickMe;
	
	public void ClickOnNormalAlert() {
		NormalAlert.click();}
	
	
	
}
