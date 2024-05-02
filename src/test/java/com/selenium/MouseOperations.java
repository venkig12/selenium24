package com.selenium;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.MouserOperationsPOM;
import com.utility.Library;

public class MouseOperations extends Library{
	
	@Test (priority=1)
	public void ValidateRightClickOperation() throws InterruptedException {
		driver.get(objProp.getProperty("mouseOpeartionRightClick"));
		PageLoadTimeOut();
		MouserOperationsPOM objMouseOperations =  new MouserOperationsPOM(driver);
		Actions objActions = new Actions(driver);
		objActions.contextClick(objMouseOperations.rightClickMeButton).build().perform();
		Thread.sleep(2000);
		objActions.click(objMouseOperations.copyOption).build().perform();
		Thread.sleep(2000);
		Alert objAlert = driver.switchTo().alert();
		Assert.assertEquals(objAlert.getText(), objProp.getProperty("mouseOpeartionRightclick_CopyOptionAlertText"));
		objAlert.accept();
	}
	
	@Test(priority=2)
	public void ValidateDoubleClickOperation() {
		driver.navigate().to(objProp.getProperty("mouseOpeartionDoubleClick"));
		PageLoadTimeOut();
		MouserOperationsPOM objMouseOperations =  new MouserOperationsPOM(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",objMouseOperations.iframe);
		driver.switchTo().frame(objMouseOperations.iframe);
		Actions objActions = new Actions(driver);
		objActions.doubleClick(objMouseOperations.doubleClickBox).build().perform();
		driver.switchTo().defaultContent();
	}
	
	@Test(priority=3)
	public void ValidateDragAndDrop() {
		System.out.print("inside ValidateDragAndDrop");
		driver.navigate().to(objProp.getProperty("mouseOperationDragAndDrop"));
		PageLoadTimeOut();
		MouserOperationsPOM objMouseOperations =  new MouserOperationsPOM(driver);
		driver.switchTo().frame(objMouseOperations.iframe);
		Actions objActions = new Actions(driver);
		objActions.dragAndDrop(objMouseOperations.Draggable, objMouseOperations.Droppable).build().perform();
		driver.switchTo().defaultContent();
		objMouseOperations.AcceptOutSideiframe.click();
		
	}
	
	@BeforeTest
	public void BeforeTest() {
		LaunchBrowser();
	}
	
	@BeforeSuite
	public void BeforeSuite() {
		try {
			ReadPropertiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
