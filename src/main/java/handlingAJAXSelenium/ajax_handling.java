package handlingAJAXSelenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ajax_handling {

	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().window().maximize();
		driver.manage().timeouts().setScriptTimeout(20,TimeUnit.SECONDS);
		long start_time = System.currentTimeMillis();
		System.out.println(start_time);
		
		//This tell the webdriver to wait for script execution
		js.executeAsyncScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
		/* with this method it wont for wait javascript to execute*/
		//js.executeScript("window.setTimeout(arguments[arguments.length - 1], 5000);");
		  System.out.println("Passed time: " + (System.currentTimeMillis() - start_time));
		 
		  driver.quit();
	}
	
	
}
