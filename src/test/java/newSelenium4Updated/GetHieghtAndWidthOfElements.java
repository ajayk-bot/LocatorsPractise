package newSelenium4Updated;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetHieghtAndWidthOfElements {

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
		
		//capturing height and width of element
		System.out.println(courseName.getRect().getDimension().getHeight());
		System.out.println(courseName.getRect().getDimension().getWidth());
		
		
		int Height = courseName.getSize().getHeight();
		int widht = courseName.getSize().getWidth();
		Point point = courseName.getLocation();

		System.out.println("Height: " +Height+ " widht :" +widht+ " point :"+ point);
		
	}

}
