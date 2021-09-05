package testngAnnotationPractise;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotationInterview {

	@BeforeSuite
	public void beforeSuit() {
		System.out.println("beforeSuit() is execuated");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass() is execuated");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest() is execuated");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod() is execuated");
	}

//----------------------------------------	
	@Test
	public void testcase1() {
		System.out.println("@Test testcase1()");
	}
	@Test
	public void testcase2() {
		System.out.println("@Test testcase2()");
	}

//-----------------------------------------
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod() is execuated");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest() is execuated");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass() is execuated");
	}

	@AfterSuite
	public void afterSuit() {
		System.out.println("afterSuit() is execuated");
	}

	
	
	@BeforeGroups
	public void beforeGroups() {
		System.out.println("beforeGroups() is execuated");
	}
	
	@AfterGroups
	public void afterGroups() {
		System.out.println("afterGroups() is execuated");
	}
}






