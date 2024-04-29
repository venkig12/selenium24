package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FramesPOM {
	WebDriver driver;
	
	public FramesPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement TextBox;
	
	@FindBy(xpath="//a[contains(text(),'with in an Iframe')]")
	public WebElement IframeWithInIframeButton;
	
	@FindBy(xpath="//iframe[@src='MultipleFrames.html']")
	public WebElement OuterFrameInMultipleFrames;
	
	@FindBy(xpath="//iframe[@src='SingleFrame.html']")
	public WebElement InnerFrameInMultipleFrames;
	
}
