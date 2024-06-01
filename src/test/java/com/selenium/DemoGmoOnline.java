package com.selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DemoGmoOnline {
	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		driver = new ChromeDriver();
		driver.get("https://demo.borland.com/gmopost/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(80));
		System.out.println("------------HOME PAGE----------");
		String Title = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, "Welcome to Green Mountain Outpost");
		driver.findElement(By.name("bSubmit")).click();
		System.out.println("-------Next page------");
		String OnlineCatalogTitle = driver.getTitle();
		System.out.println(OnlineCatalogTitle);
		Assert.assertEquals(OnlineCatalogTitle, "OnLine Catalog");
		System.out.println("-----------ADD Catalog Items page...........");
		driver.findElement(By.name("QTY_TENTS")).clear();
		driver.findElement(By.name("QTY_TENTS")).sendKeys("3");
		driver.findElement(By.name("QTY_BACKPACKS")).clear();
		driver.findElement(By.name("QTY_BACKPACKS")).sendKeys("4");
		driver.findElement(By.name("QTY_GLASSES")).clear();
		driver.findElement(By.name("QTY_GLASSES")).sendKeys("2");
		driver.findElement(By.name("QTY_SOCKS")).clear();
		driver.findElement(By.name("QTY_SOCKS")).sendKeys("1");
		driver.findElement(By.name("QTY_BOOTS")).clear();
		driver.findElement(By.name("QTY_BOOTS")).sendKeys("5");
		driver.findElement(By.name("QTY_SHORTS")).clear();
		driver.findElement(By.name("QTY_SHORTS")).sendKeys("7");
		driver.findElement(By.name("bSubmit")).click();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		System.out.println("------------place order page");
		String placeorderTitle = driver.getTitle();
		System.out.println(placeorderTitle);
		Assert.assertEquals(placeorderTitle, "Place Order");
		System.out.println("-----Calcualting Price Total of DemoTent------");
		String UnitPrice1 = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[2]/td[4]")).getText();
		System.out.println("UnitPrice1:" + UnitPrice1);
		String floatValueofUnitPrice1 = UnitPrice1.substring(2).trim();
		System.out.println("floatValueOfUnitPrice1:" + floatValueofUnitPrice1);
		float calculatedUnitPrice1 = Float.parseFloat(floatValueofUnitPrice1) * 3;
		System.out.println("calcutatedUnitPrice:" + calculatedUnitPrice1);
		System.out.println("-----Calcualting Price Total of Back Packs------");
		String UnitPrice2 = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[3]/td[4]")).getText();
		System.out.println("UnitPrice2:" + UnitPrice2);
		String floatValueofUnitPrice2 = UnitPrice2.substring(2).trim();
		System.out.println("floatValueOfUnitPrice2:" + floatValueofUnitPrice2);
		float calculatedUnitPrice2 = Float.parseFloat(floatValueofUnitPrice2) * 4;
		System.out.println("calcutatedUnitPrice:" + calculatedUnitPrice2);
		System.out.println("-----Calcualting Price Total of Sun Glasses------");
		String UnitPrice3 = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[4]/td[4]")).getText();
		System.out.println("UnitPrice:" + UnitPrice3);
		String floatValueofUnitPrice3 = UnitPrice3.substring(2).trim();
		System.out.println("floatValueOfUnitPrice3:" + floatValueofUnitPrice3);
		float calculatedUnitPrice3 = Float.parseFloat(floatValueofUnitPrice3) * 2;
		System.out.println("calcutatedUnitPrice:" + calculatedUnitPrice3);
		System.out.println("-----Calcualting Price Total of Padded Socks------");
		String UnitPrice4 = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[5]/td[4]")).getText();
		System.out.println("UnitPrice:" + UnitPrice4);
		String floatValueofUnitPrice4 = UnitPrice4.substring(2).trim();
		System.out.println("floatValueOfUnitPrice4:" + floatValueofUnitPrice4);
		float calculatedUnitPrice4 = Float.parseFloat(floatValueofUnitPrice1) * 1;
		System.out.println("calcutatedUnitPrice:" + calculatedUnitPrice4);
		System.out.println("-----Calcualting Price Total of Hikking Boots------");
		String UnitPrice5 = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[6]/td[4]")).getText();
		System.out.println("UnitPrice:" + UnitPrice5);
		String floatValueofUnitPrice5 = UnitPrice1.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:" + floatValueofUnitPrice5);
		float calculatedUnitPrice5 = Float.parseFloat(floatValueofUnitPrice5) * 5;
		System.out.println("calcutatedUnitPrice:" + calculatedUnitPrice5);
		System.out.println("-----Calcualting Price Total of Shorts------");
		String UnitPrice6 = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[7]/td[4]")).getText();
		System.out.println("UnitPrice:" + UnitPrice6);
		String floatValueofUnitPrice6 = UnitPrice6.substring(2).trim();
		System.out.println("floatValueOfUnitPrice:" + floatValueofUnitPrice6);
		float calculatedUnitPrice6 = Float.parseFloat(floatValueofUnitPrice6) * 7;
		System.out.println("calcutatedUnitPrice:" + calculatedUnitPrice6);
		System.out.println("---calculate ProductTotal------");
		String PRODUCTTOTAL = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[8]/td[3]")).getText();
		float SumofPRODUCTTOTAL = Float.parseFloat(PRODUCTTOTAL.substring(2).trim());
		System.out.println("SumofPRODUCTTOTAL:" + SumofPRODUCTTOTAL);
		System.out.println("---SALES TAX---");
		String SalesTax = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[9]/td[2]")).getText();
		float floatSalesTax = Float.parseFloat(SalesTax.substring(2).trim());
		System.out.println("floatSales Tax:" + floatSalesTax);
		float AddedSalesTax = (floatSalesTax + SumofPRODUCTTOTAL);
		System.out.println("AddedSalesTax:" + AddedSalesTax);

		System.out.println("---ADDING SHIPPING AND HANDLING---");
		String Shipping = driver.findElement(By.xpath("//table[@border='1']/tbody/tr[10]/td[2]")).getText();
		System.out.println("Shipping:" + Shipping);
		float floatShippingPrice = Float.parseFloat(Shipping.substring(2).trim());
		Float GrandTotalPrice = (floatShippingPrice + AddedSalesTax);
		System.out.println("GRANDTotalPrice:" + GrandTotalPrice);

		driver.findElement(By.name("bSubmit")).click();
		System.out.println("-----Next Biiling Page------");

		String BillingInformationPage = driver.getTitle();
		System.out.println(BillingInformationPage);
		Assert.assertEquals(BillingInformationPage, "Billing Information");
		driver.findElement(By.name("billName")).clear();
		driver.findElement(By.name("billName")).sendKeys("venky");
		driver.findElement(By.name("billAddress")).clear();
		driver.findElement(By.name("billAddress")).sendKeys("5435 main st");
		driver.findElement(By.name("billCity")).clear();
		driver.findElement(By.name("billCity")).sendKeys("Diamond City");
		driver.findElement(By.name("billState")).clear();
		driver.findElement(By.name("billState")).sendKeys("Golden State");
		driver.findElement(By.name("billZipCode")).clear();
		driver.findElement(By.name("billZipCode")).sendKeys("54360");
		driver.findElement(By.name("billPhone")).clear();
		driver.findElement(By.name("billPhone")).sendKeys("5787688698");
		driver.findElement(By.name("billEmail")).clear();
		driver.findElement(By.name("billEmail")).sendKeys("venky@gmail.com");
		driver.findElement(By.name("CardType")).sendKeys("MasterCard");
		driver.findElement(By.name("CardNumber")).sendKeys("1234-1234-1234-1234");
		driver.findElement(By.name("CardDate")).sendKeys("10/45");
		WebElement ShipTo = driver.findElement(By.name("shipSameAsBill"));
		ShipTo.click();
		System.out.println("-----Place on Order-----");
		driver.findElement(By.name("bSubmit")).click();
	}

}
