package newSelenium4Updated;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewScreenshotsforField {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().window().maximize();
		driver.switchTo().newWindow(WindowType.TAB); 
		driver.get("https://rahulshettyacademy.com/");	
		Set<String> windows = driver.getWindowHandles(); 
		Iterator<String> itr = windows.iterator(); 
		String parentWindow = itr.next(); 
		String childWindow =itr.next(); 				 		
		String text = driver.findElement(By.xpath("//a[contains(text(),'Core java for Automation Testers + Interview Progr')]")).getText();	
		System.out.println(text);
		driver.switchTo().window(parentWindow);
		WebElement courseName = driver.findElement(By.xpath("//body/app-root[1]/form-comp[1]/div[1]/form[1]/div[1]/input[1]"));
		courseName.sendKeys(text);
		
		//get the screenshot of specific element
		File file =  courseName.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file,new File("logo.png"));
		
		//get the page screenshot
		File completeScreenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(completeScreenshot, new File("pagescreen.png"));
		
		//
		
		System.out.println("succesfully");
		
	}

}
