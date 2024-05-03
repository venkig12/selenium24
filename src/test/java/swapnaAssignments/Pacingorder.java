package swapnaAssignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Pacingorder {	
	static WebDriver driver;

	public static void main(String[] args) {
		System.out.println("Good Morning");
		
		System.out.println("Launching a Website");
		
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		 driver.get("https://demo.borland.com/gmopost/");
		 
		 System.out.println("--HOMEPAGE--");
		 
		 String HomePageTitle=driver.getTitle();
		 System.out.println("HomePageTitle:" +HomePageTitle);
		Assert.assertEquals(HomePageTitle,"Welcome to Green Mountain Outpost");
		driver.findElement(By.name("bSubmit")).click();
		
		System.out.println("-TONEXTPAGE-");
		
		String OnlineCatalogTitle=driver.getTitle();
		 System.out.println("OnlineCatalogTitle:" +OnlineCatalogTitle);
		//Assert.assertEquals(OnlineCatalogTitle,"OnLine Catalog");
		
		
		
		System.out.println("-ADDING QUANTITY-");
	
		
		driver.findElement(By.name("QTY_TENTS")).clear();
		driver.findElement(By.name("QTY_TENTS")).sendKeys("1");
		
		
		driver.findElement(By.name("QTY_BACKPACKS")).clear();
		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys("2");
		
		driver.findElement(By.name("QTY_GLASSES")).clear();
		driver.findElement(By.name("QTY_GLASSES")).sendKeys("3");
		
		
		driver.findElement(By.name("QTY_SOCKS")).clear();
		driver.findElement(By.name("QTY_SOCKS")).sendKeys("4");
		
		
		driver.findElement(By.name("QTY_BOOTS")).clear();
		driver.findElement(By.name("QTY_BOOTS")).sendKeys("5");
		
		
		driver.findElement(By.name("QTY_SHORTS")).clear();
		driver.findElement(By.name("QTY_SHORTS")).sendKeys("6");
		
		
		
		System.out.println("-TONEXTPAGE-");
		 driver.findElement(By.name("bSubmit")).click();
		
		String PlaceOrder=driver.getTitle();
		 System.out.println("PlaceOrder:" +PlaceOrder);
		 Assert.assertEquals(PlaceOrder, "Place Order");
		 
		 System.out.println("---CALCULATING TOTAL PRICE OF DEMO TENT---");
		String UnitPrice=driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[4]")).getText(); 
	    System.out.println("UnitPrice:"+UnitPrice);
	    String floatValueofUnitPrice=UnitPrice.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:"+floatValueofUnitPrice);
		float calculatedUnitPrice1=Float.parseFloat(floatValueofUnitPrice)*1;
		System.out.println("calcutatedUnitPrice:"+calculatedUnitPrice1);
		
		System.out.println("---CALCULATING TOTAL PRICE OF BACKPACK---");
		
String UnitPrice1=driver.findElement(By.xpath("//table[@border='1']/tbody/tr[3]/td[4]")).getText(); 
	    System.out.println("UnitPrice:"+UnitPrice1); 
	    String floatValueofUnitPrice1=UnitPrice1.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:"+floatValueofUnitPrice1);
		float calculatedUnitPrice2=Float.parseFloat(floatValueofUnitPrice1)*2;
		System.out.println("calcutatedUnitPrice2:"+calculatedUnitPrice2);
		
	
		System.out.println("---CALCULATING TOTAL PRICE OF SUN GLASSES---");
		String UnitPrice2=driver.findElement(By.xpath("//table[@border='1']/tbody/tr[4]/td[4]")).getText(); 
	    System.out.println("UnitPrice2:"+UnitPrice2); 
	    String floatValueofUnitPrice2=UnitPrice2.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:"+floatValueofUnitPrice2);
		float calculatedUnitPrice3=Float.parseFloat(floatValueofUnitPrice2)*3;
		System.out.println("calcutatedUnitPrice3:"+calculatedUnitPrice3);
				
		System.out.println("---CALCULATING TOTAL PRICE OF SOCKS---");
		String UnitPrice3=driver.findElement(By.xpath("//table[@border='1']/tbody/tr[5]/td[4]")).getText(); 
	    System.out.println("UnitPrice3:"+UnitPrice3); 
	    String floatValueofUnitPrice3=UnitPrice3.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:"+floatValueofUnitPrice3);
		float calculatedUnitPrice4=Float.parseFloat(floatValueofUnitPrice3)*4;
		System.out.println("calcutatedUnitPrice4:"+calculatedUnitPrice4);
		
		
		System.out.println("---CALCULATING TOTAL PRICE OF BOOTS---");
		String UnitPrice4=driver.findElement(By.xpath("//table[@border='1']/tbody/tr[6]/td[4]")).getText(); 
	    System.out.println("UnitPrice4:"+UnitPrice4); 
	    String floatValueofUnitPrice4=UnitPrice4.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:"+floatValueofUnitPrice4);
		float calculatedUnitPrice5=Float.parseFloat(floatValueofUnitPrice4)*5;
		System.out.println("calcutatedUnitPrice5:"+calculatedUnitPrice5);
		
		
		System.out.println("---CALCULATING TOTAL PRICE OF SHORTS---");
		String UnitPrice5=driver.findElement(By.xpath("//table[@border='1']/tbody/tr[7]/td[4]")).getText(); 
	    System.out.println("UnitPrice5:"+UnitPrice5); 
	    String floatValueofUnitPrice5=UnitPrice5.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:"+floatValueofUnitPrice5);
		float calculatedUnitPrice6=Float.parseFloat(floatValueofUnitPrice5)*6;
		System.out.println("calcutatedUnitPrice6:"+calculatedUnitPrice6);
		
		System.out.println("---CALCULATING PRODUCT TOTAL---");
		String PRODUCTTOTAL =driver.findElement(By.xpath("//table[@border='1']/tbody/tr[8]/td[3]")).getText();
		float floatPRODUCTTOTAL = Float.parseFloat(PRODUCTTOTAL.substring(2).trim());
		System.out.println("PRODUCT TOTAL:"+PRODUCTTOTAL);
		float AddedPRODUCTTOTAL =( calculatedUnitPrice1+calculatedUnitPrice2+calculatedUnitPrice3+calculatedUnitPrice4+calculatedUnitPrice5+calculatedUnitPrice6);
		System.out.println("Added PRODUCT TOTAL:"+AddedPRODUCTTOTAL);
		
		System.out.println("---SALES TAX---");
		String SalesTax =driver.findElement(By.xpath("//table[@border='1']/tbody/tr[9]/td[2]")).getText();
		float floatSalesTax = Float.parseFloat(SalesTax.substring(2).trim());
		System.out.println("floatSales Tax:"+floatSalesTax);
		float AddedSalesTax =(floatSalesTax+ AddedPRODUCTTOTAL);
		System.out.println("AddedSalesTax:"+AddedSalesTax);
	
	 
        System.out.println("---ADDING SHIPPING AND HANDLING---");
		String Shipping	 =driver.findElement(By.xpath("//table[@border='1']/tbody/tr[10]/td[2]")).getText();
		System.out.println("Shipping:"+Shipping	);
		float floatShippingPrice = Float.parseFloat(Shipping .substring(2).trim());
		Float GrandTotalPrice = ( floatShippingPrice + AddedSalesTax);
		System.out.println("GRANDTotalPrice:"+GrandTotalPrice);
		
		driver.findElement(By.xpath("//input[@value='Proceed With Order']")).click();
		
		
		System.out.println("---TO NEXTPAGE---");
		String BillingInformation =driver.getTitle();
		System.out.println("BillingInformation:"+BillingInformation);
		Assert.assertEquals(BillingInformation,"Billing Information");
	
		 driver.findElement(By.name("billName")).sendKeys("Swapna Koora");
		 driver.findElement(By.name("billAddress")).sendKeys("1234 Spring St.");
		 driver.findElement(By.name("billCity")).sendKeys("Wonder City");
		 driver.findElement(By.name("billState")).sendKeys("Dream State");
		 driver.findElement(By.name("billZipCode")).sendKeys("98765");
		 driver.findElement(By.name("billPhone")).sendKeys("56789999999");
		driver.findElement(By.name("billEmail")).sendKeys("later@gmail.com");
		 
		 
WebElement ShipTo=driver.findElement(By.name("shipSameAsBill"));
ShipTo.click();

		
		
	
		
		
			
		
	

	}

}
