package swapnaAssignments;

import org.testng.annotations.Test;

import com.Pages.AssignmentFramesPOM;
import com.utility.Constants;
import com.utility.Library;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class assignmentFrames1 extends Library{
  @Test(priority=-1)
  public void LaunchingBrowser() {
	  System.out.println("Launching Frames Browser");
	  driver.get(objProp.getProperty("Frames@1URL"));
	  PageLoadTimeOut();
	  Assert.assertEquals(driver.getTitle(),Constants.AssignmentFramespageTitle);
	  
	  
  }
  
  @Test (priority=1)
  public void OuterFrame() {
	  System.out.println("Inside OuterFrame");
	  driver.switchTo().frame("frame1");
	  AssignmentFramesPOM objAssignmentFramesPOM = new AssignmentFramesPOM (driver);
	  objAssignmentFramesPOM.TextBox.sendKeys(objProp.getProperty("Topic"));
	 
	  
  }
  
  @Test (priority=2) 
  public void InnerFrame() {
	  System.out.println("Inside InnerFrame");
	  driver.switchTo().frame("frame3");
	  AssignmentFramesPOM objAssignmentFramesPOM = new AssignmentFramesPOM (driver);
	  objAssignmentFramesPOM.InnerFrameCheckBox.click();
	  driver.switchTo().defaultContent();
	  
  }
  

  @Test (priority=3) 
  public void SecondFrame() {
	  System.out.println("Inside SecondFrame");
	  AssignmentFramesPOM objAssignmentFramesPOM = new AssignmentFramesPOM (driver);
	  driver.switchTo().frame(objAssignmentFramesPOM.Secondframe);
	  objAssignmentFramesPOM.AnimalsSelectBox .click();
	 Select objAssignmentFramesPOMselect = new Select(objAssignmentFramesPOM.AnimalsSelectBox);
	 objAssignmentFramesPOMselect.selectByVisibleText("Big Baby Cat");
	 objAssignmentFramesPOM.BigBabyCatButton.click();
	 
	 driver.switchTo().defaultContent();
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
	  LaunchBrowser();
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  try {
		ReadPropertiesFile();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @AfterSuite
  public void afterSuite() {
  }

}
