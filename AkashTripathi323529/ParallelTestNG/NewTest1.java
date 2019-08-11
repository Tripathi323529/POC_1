package ParallelTestNG;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BASE_CLASSES.ShoppingMethods;

public class NewTest1{
	
	ShoppingMethods sm;
	WebDriver dr;
	String str;
	String xp;
	String price1, price2;
	Logger log;
	String nodeURL;
	
//	@BeforeClass
//	  public void setup() throws MalformedURLException 
//	  {
//		 nodeURL = "http://192.168.0.104:5566/wd/hub";	
//		  DesiredCapabilities cap = DesiredCapabilities.firefox();
//		  cap.setBrowserName("firefox");
//		  cap.setPlatform(Platform.WINDOWS);
//		  dr = new RemoteWebDriver(new URL(nodeURL), cap);
//		  
//	  }

@Test
  public void f() {
	
	System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	dr = new FirefoxDriver();
	
	dr.get("http://automationpractice.com/index.php");
	sm = new ShoppingMethods(dr);
	sm.login();
	System.out.println("Login Successfully");
	log=Logger.getLogger("devpinoyLogger");
	log.info("Login Successfully");
}
	

@Test
public void f1() {
	
	sm = new ShoppingMethods(dr);
	xp = "//*[@class='account']";
	str = sm.verifyName(xp);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(str, "abc def");
	System.out.println("Username Verified");
	log=Logger.getLogger("devpinoyLogger");
	log.info("Expected Value : abc def -- Actual Value : "+str+" -- Test Result: Passed");

}

//@Test
//public void f2() {
//	
//	SoftAssert sa = new SoftAssert();
//	sa.assertEquals(str, "abcdef");
//	System.out.println("Username is wrong");
//
//}

@Test
public void f3() {
	
	sm = new ShoppingMethods(dr);
	sm.addToCart();
	System.out.println("Products added to the cart");
	log=Logger.getLogger("devpinoyLogger");
	log.info("Products added to the cart");

}

@Test
public void f4() {
	
	sm = new ShoppingMethods(dr);
	xp = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[2]/p/a";
	str = sm.verifyName(xp);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(str, "Printed Dress");
	System.out.println("Name of Product 1 is correct");
	log=Logger.getLogger("devpinoyLogger");
	log.info("Expected Value : Printed Dress -- Actual Value : "+str+" -- Test Result: Passed");

}

@Test
public void f5() {
	
	sm = new ShoppingMethods(dr);
	xp = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[2]/p/a";
	str = sm.verifyName(xp);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(str, "Fade Short Sleeve T-Shirt");
	System.out.println("Name of Product 2 is correct");
	log=Logger.getLogger("devpinoyLogger");
	log.info("Expected Value : Fade Short Sleeve T-Shirt -- Actual Value : "+str+" -- Test Result: Passed");

}

@Test
public void f6() {
	
	sm = new ShoppingMethods(dr);
	xp = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[1]/td[4]/span/span";
	price1 = sm.unitPrice(xp);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(price1, "26.00");
	System.out.println("Price of Product 1 is correct");
	log=Logger.getLogger("devpinoyLogger");
	log.info("Expected Value : $26.00 -- Actual Value : $"+price1+" -- Test Result: Passed");

}
  
@Test
public void f7() {
	
	sm = new ShoppingMethods(dr);
	xp = "/html/body/div/div[2]/div/div[3]/div/div[2]/table/tbody/tr[2]/td[4]/span/span";
	price2 = sm.unitPrice(xp);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(price2, "16.51");
	System.out.println("Price of Product 1 is correct");
	log=Logger.getLogger("devpinoyLogger");
	log.info("Expected Value : $16.51 -- Actual Value : $"+price2+" -- Test Result: Passed");

}

@Test
public void f8() {
	
	sm = new ShoppingMethods(dr);
	xp = "//*[@id=\"total_price\"]";
	str = sm.totalPrice(xp);
	double total = (Double.parseDouble(price1))*1 + (Double.parseDouble(price2))*2 + 2 ;
	String totalPrice = Double.toString(total);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(str, totalPrice);
	System.out.println("Total price is correct");
	log=Logger.getLogger("devpinoyLogger");
	log.info("Expected Value : $"+total+" -- Actual Value : $"+totalPrice+" -- Test Result: Passed");
}

}
