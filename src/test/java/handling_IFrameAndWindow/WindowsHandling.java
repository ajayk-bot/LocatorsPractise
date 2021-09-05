package handling_IFrameAndWindow;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

//https://www.youtube.com/watch?v=-RkjM9Uh7Ac

public class WindowsHandling {
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://demoqa.com/browser-windows");
		driver.get("https://www.behance.net/");
		
		
		driver.findElement(By.xpath("//button[@id='windowButton']")).click();
		String mainWin = driver.getWindowHandle();
		Set<String> allwindowsCollected = driver.getWindowHandles();
		Iterator<String> itr = allwindowsCollected.iterator();
		
		while (itr.hasNext()) {
			String childWinID = itr.next();
			if(!mainWin.equalsIgnoreCase(childWinID)) {
				driver.switchTo().window(childWinID);
				System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());			
			}

		}	
		driver.quit();

	}
}