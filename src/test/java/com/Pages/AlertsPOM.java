package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPOM {
	WebDriver driver;
	
	public AlertsPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="alertButton")
	public WebElement NormalAlert;
	
	
	@FindBy(id="timerAlertButton")
	public WebElement TimerAlertButton;
	
	@FindBy(id="confirmButton")
	public WebElement confirmAlertButton;
	
	@FindBy(id="confirmResult")
	public WebElement confirmResult;
	
	@FindBy(id="promtButton")
	public WebElement promptAlertButton;
	
	@FindBy(id="promptResult")
	public WebElement PromptBoxResult;
	
	
	public void ClickOnNormalAlert() {
		NormalAlert.click();
	}
}
