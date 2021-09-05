package salesforceTestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTestCase {

	
	
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://login.salesforce.com/?locale=in");
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	//	driver.findElement(By.cssSelector("#username")).sendKeys("ajayk131989-xt54@force.com");
		//driver.findElement(By.cssSelector("#password")).sendKeys("Sherya@1234");
		//driver.findElement(By.cssSelector("#Login")).click();
		
		
		driver.findElement(By.cssSelector("input#identifierId.whsOnd.zHQkBf")).sendKeys("ajayk131989@gamil.com");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		driver.findElement(By.cssSelector("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]")).sendKeys("9890081663");
		driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
		
		
		
	}
	
	

	
}
