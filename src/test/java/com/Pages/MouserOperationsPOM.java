package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouserOperationsPOM {
	WebDriver driver;
	
	public MouserOperationsPOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[text()='right click me']")
	public WebElement rightClickMeButton;
	
	@FindBy(xpath="//span[text()='Copy']")
	public WebElement copyOption;
	
	@FindBy(tagName = "iframe")
	public WebElement iframe;
	
	@FindBy(xpath="//span[contains(text(),'Double click')]/preceding-sibling::div")
	public WebElement doubleClickBox;
	
	@FindBy(id="draggable")
	public WebElement Draggable;
	
	@FindBy(id="droppable")
	public WebElement Droppable;

	@FindBy(xpath="//a[text()='Accept']")
	public WebElement AcceptOutSideiframe;
	
}
