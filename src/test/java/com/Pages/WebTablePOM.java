package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.javaBasics.string;

public class WebTablePOM {
	WebDriver driver;
	
	public WebTablePOM(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath ="//table[@id='example']")
	public WebElement webtable;
	
	@FindBy(xpath="//table[@id='example']/tbody/tr/td[3]")
	public List<WebElement> AllLastNames;
	
	@FindBy(xpath="//button[@class='dt-paging-button next']")
	public WebElement NextPageInTable;
	
	public By getFirstName(int row) { 
		By FirstName=By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[2]");
		return FirstName;
	}
	
	public By getLastName(int row) { 
		By LastName=By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[3]");
		return LastName;
	}
	
	public By getPosition(int row) { 
		By Position=By.xpath("//table[@id='example']/tbody/tr[" + row + "]/td[4]");
		return Position;
	}
	
}
