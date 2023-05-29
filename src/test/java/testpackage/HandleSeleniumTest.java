package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HandleSeleniumTest {
	
	String projectPath = System.getProperty("user.dir");
	String chromeDriverPath = System.setProperty("webdriver.chrome.driver", projectPath + "\\drivers\\chromedriver.exe");
	String url = "https://parabank.parasoft.com/parabank/index.htm";
	
  @Test
  public void test01() throws InterruptedException {
	  
		
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		
		WebElement usernameTextbox = driver.findElement(By.name("username"));
		usernameTextbox.sendKeys("john");
		
		WebElement passwordTextbox = driver.findElement(By.name("password"));
		passwordTextbox.sendKeys("demo");
		
		Thread.sleep(5000);
		
		WebElement LoginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
		LoginButton.click();
		
		Thread.sleep(3000);
		
		String expectedTitle = "ParaBank | Accounts Overview";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println(actualTitle);
	
		
		Thread.sleep(3000);
		
		WebElement logoutButton = driver.findElement(By.linkText("Log Out"));
		logoutButton.click();
	
		Thread.sleep(2000);
		
		driver.quit();
		
	  
  }
}
