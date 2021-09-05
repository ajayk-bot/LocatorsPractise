package newSelenium4Updated;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingTAB_and_Window_Selenium4 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		//this will open new TAB in browser
		driver.switchTo().newWindow(WindowType.TAB); // you can use .WINDOW it will popup new window.
		driver.get("https://rahulshettyacademy.com/");
	
		Set<String> windows = driver.getWindowHandles(); 
		Iterator<String> itr = windows.iterator(); 
		String parentWindow = itr.next(); 
		String childWindow =itr.next(); 
		//driver.switchTo().window(childWindow); without using this it move to next TAB
		 		
		String text = driver.findElement(By.xpath("//a[contains(text(),'Core java for Automation Testers + Interview Progr')]")).getText();	
		System.out.println(text);
		driver.switchTo().window(parentWindow);
		driver.findElement(By.xpath("//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[1]/input[1]")).sendKeys(text);
		System.out.println("succesfully");
		
		driver.quit();
		
	}

}
