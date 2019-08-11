package BASE_CLASSES;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingMethods {
	
	WebDriver dr;
	Logger log;
	
	
	public ShoppingMethods(WebDriver dr) {
		this.dr = dr;
	}

	public void launchBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver_v75.exe");
		dr = new ChromeDriver();
		dr.get("http://automationpractice.com/index.php");
	}
	
	public void login()
	{
		
		
		dr.findElement(By.linkText("Sign in")).click();
		dr.findElement(By.xpath("//*[@id='email']")).sendKeys("a11@gmail.com");
		dr.findElement(By.xpath("//input[@name=\"passwd\"]")).sendKeys("pass123$");
		dr.findElement(By.xpath("//button[@name=\"SubmitLogin\"]")).click();
		
	}
	
	
	public String verifyName(String xp)
	{
		String str = dr.findElement(By.xpath(xp)).getText();
		
		return str;
	}
	
	
	public void addToCart()
	{
		log=Logger.getLogger("devpinoyLogger");
		
		WebDriverWait wait;
		
		dr.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[2]/a")).click();
		dr.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[1]/div/div[1]/div/a[1]/img")).click();
		dr.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")).click();
		
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")));
		
		dr.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")).click();
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a")));
		
		
		dr.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[3]/a")).click();
		dr.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[1]/div/a[1]/img")).click();
		
		dr.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/a[2]/span")).click();	
		dr.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button/span")).click();
		
		wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")));
		
		dr.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/span/span")).click();
		dr.findElement(By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a/b")).click();

	}
	
	public String unitPrice(String xp)
	{
		String str = dr.findElement(By.xpath(xp)).getText();
		str = str.substring(1);
		return str;
	}
	
	public String totalPrice(String xp)
	{
		String str = dr.findElement(By.xpath(xp)).getText();
		str = str.substring(1);
		return str;
	}
	
	
	
	

}
