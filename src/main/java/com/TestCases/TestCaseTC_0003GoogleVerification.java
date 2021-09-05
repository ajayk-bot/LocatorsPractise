package com.TestCases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.baseLibraries.TestBase;
import com.loggerLib.Logs;

public class TestCaseTC_0003GoogleVerification extends TestBase{

	
	
	@Test
	public void getTitile_Google() {
		Logs.info("Launching the browser");
		driver.get("https://www.google.com/");
		
		driver.getTitle();
		Logs.info("Fail this test case to take screeenshot.");
		Assert.assertEquals(driver.getTitle(),"google12345");
		
	}
	
	@Test
	public void searchedOnGoogle() {
		throw new SkipException("Skipping the test3 test method!");
	}

	
	
	
}
