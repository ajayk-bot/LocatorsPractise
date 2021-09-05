package handling_IFrameAndWindow;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UtilityForIframeAndNewWindow {

	public WebDriver webdriver;

	//Utiltiy method to handling window in selenium
	public void goto_new_tab() {
		try {
			String parentWindow;
			String childWindow;
			
			parentWindow = webdriver.getWindowHandle();
			childWindow = null;
			
			Set<String> allWindows = webdriver.getWindowHandles();
			
			// Only attempt to switch to RecentTab, if a new tab exists.
			for (String wHandle : allWindows) {
				if (wHandle != parentWindow) {
					childWindow = wHandle;
				}
			}

			int attempts = 1;
			if (!childWindow.equals(parentWindow)) {
				while (webdriver.getWindowHandle().equals(parentWindow)) {
					webdriver.switchTo().window(childWindow);
					// Reporter.log("Switch window attempt:" + attempts,true);
					attempts++;
				}
			}

		} catch (Throwable t) {
			// standard_warning_output(t.getMessage());
		}

	}
	
	

	
	@Test
	public void testWindowsHandles() {
		System.setProperty("webdriver.chrome.driver",
				"E:\\NewIDEEclipse\\NewIDEWorkspace\\LocatorsPractices\\src\\test\\resources\\execuatbles\\chromedriver.exe");
		webdriver = new ChromeDriver();
		webdriver.get("https://demoqa.com/browser-windows");

		
		// 
		
		webdriver.findElement(By.xpath("//button[@id='windowButton']")).click();

		goto_new_tab();
		
		System.out.println(webdriver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());	
		
		webdriver.switchTo().defaultContent();
		System.out.println("come back to parent window and get the Title :"+webdriver.getTitle());
		
		//webdriver.switchTo().parentFrame();
		
		webdriver.quit();
		
	}
	
	
	

}
