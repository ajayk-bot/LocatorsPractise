package staleExceptionInterview;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingHiddenWebELements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\test\\resources\\execuatbles\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		/*--------------Mukesh otwani solution ---------------- */

		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().window().maximize();

		// driver.findElement(By.xpath("//input[@id='male']")).click();

		// int x_cordinates =
		// driver.findElement(By.xpath("//input[@id='male']")).getLocation().getX();
		// int y_cordinates =
		// driver.findElement(By.xpath("//input[@id='male']")).getLocation().getY();

		// "If element is on the DOm it should have x amd y cordinates but we know it is
		// hidden web elements it will be 0 for x and y"
		// System.out.println(x_cordinates + " ------ " + y_cordinates);

		List<WebElement> ele = driver.findElements(By.xpath("//input[@id='male']"));
		int count = ele.size();
		// solving org.openqa.selenium.ElementNotInteractableException: element not
		// interactable
		for (int i = 0; i < count; i++) {
			int x_cordinates = ele.get(i).getLocation().getX();
			if (x_cordinates != 0) {
				ele.get(i).click();
				System.out.println("Selected the option button:" + ele.get(i).isSelected());
				break;
			}

		}

		System.out.println();

		/*--------------Lets code it solution ---------------- */

		driver.get("https://www.expedia.co.in/");
		WebElement childDropDOwn = driver.findElement(By.xpath("//select[@id='child-age-input-0-0']"));
		// ChildDropdown age box will appear when children is added here from DOM
		// element is complete destroyed.
		System.out.println(childDropDOwn.isDisplayed());
		// so when element is not present on the DOM then
		// Exception NoSuchElementException: no such element: Unable to locate element

		driver.quit();

	}

}
