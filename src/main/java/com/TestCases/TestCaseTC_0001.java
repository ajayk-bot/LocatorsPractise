package com.TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.baseLibraries.TestBase;
import com.loggerLib.Logs;

public class TestCaseTC_0001 extends TestBase {

	@Test(priority = 1)
	public void verifyTitle_Page() {

		// initializeMethod();
		Logs.info("Launching the browser");
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		// Login Here
		Logs.info("Making entries in UserName and Password and click");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();

		// check user is on landing page
		Logs.debug("make sure it collect the menu properly");
		List<WebElement> listEle = driver.findElements(By.cssSelector("div.quickLaunge>a>span"));
		for (WebElement webElement : listEle) {
			System.out.println(webElement.getText());
		}

		System.out.println("----------------------------");

		for (WebElement webElement : driver
				.findElements(By.cssSelector("#mainMenuFirstLevelUnorderedList > li > a > b"))) {
			System.out.println(webElement.getText());
		}

		Logs.warn("tear down is called here goign to close everyting.");
		// tearDown();
	}

	@Test(priority = 2)
	public void verifyTitleOfthePage() {

		Logs.info("Faling this test case to verify screenshotcapturing code have been written in Listners");
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM3232");

	}

}
