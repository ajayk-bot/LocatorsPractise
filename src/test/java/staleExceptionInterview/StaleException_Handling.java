package staleExceptionInterview;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleException_Handling {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.freecrm.com/index.html");
		
		WebElement username =  driver.findElement(By.xpath("//input[@type='text'][@name='username']"));
		username.sendKeys("test");
		WebElement pwd =  driver.findElement(By.xpath("//input[@type='password'][@name='password']"));
		pwd.sendKeys("dsjdjsd");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("ENd here");
		driver.quit();
	}
	
	
	
	
	
	
	
}
