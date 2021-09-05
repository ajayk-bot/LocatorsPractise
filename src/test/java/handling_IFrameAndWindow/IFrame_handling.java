package handling_IFrameAndWindow;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/* To move back to the parent frame, you can either use switchTo().parentFrame() or
 *  if you want to get back to the main (or most parent) frame, you can use
 *  switchTo().defaultContent(); 
 */

public class IFrame_handling {

	static WebDriver driver;

	//overloaded methods to handle Iframe windows
	public static void goto_new_Iframe(int index) {
		// String parentFrame;
		// String childFrame;
		driver.switchTo().frame(index);
	}
	
	public static void goto_new_Iframe(String frameNameorFrameID) {

		driver.switchTo().frame(frameNameorFrameID);

	}
	
	public static void goto_new_Iframe(WebElement framewebEle) {

		driver.switchTo().frame(framewebEle);

	}
	
	

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver",
				"E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_submit");
		driver.manage().window().maximize();

		List<WebElement> listFrame = driver.findElements(By.tagName("iframe"));
		int numberOfFrameonPage = listFrame.size();
		System.out.println(numberOfFrameonPage);

		// <iframe frameborder="0" id="iframeResult" name="iframeResult"
		// allowfullscreen="true" xpath="1"></iframe>

		// switching using INdex
		// driver.switchTo().frame(0);
		// switching by using nameOrID
		//driver.switchTo().frame("iframeResult");
		//switch using frame webelement
		WebElement eleFrame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(eleFrame);
		
		
		//goto_new_Iframe("iframeResult");
		
		
		
		
		System.out.println(driver.findElement(By.xpath("//h2[contains(text(),'HTML Forms')]")).getText());
		driver.switchTo().defaultContent();
		System.out.println(driver.getTitle());

		driver.quit();

		// File file = listFrame.get(i).getScreenshotAs(OutputType.FILE);
		// get the screenshot of specific element
		// FileUtils.copyFile(file,new File(i+"logo.png"));
	}

}
