package demo;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginToActitime {
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://127.0.0.1/login.do;jsessionid=8mro7g1nof7jq");	
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	@Test()
	public void login()
	{
		driver.findElement(By.name("username")).sendKeys("manager");
		driver.findElement(By.name("pwd")).sendKeys("123");
		driver.findElement(By.id("loginButton")).click();
		
	}
	
	@Test(priority = 1)
	public void createuser() throws Throwable 
	{
		login();
		driver.findElement(By.linkText("Users")).click();
		driver.findElement(By.xpath("(//input[@type=\"button\"])[3]")).click();
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='timeZoneName']"));
		Select sel=new Select(dropdown);
		sel.selectByIndex(4);
		Thread.sleep(3000);
		
	}
	
	
	
		
	
	

}
