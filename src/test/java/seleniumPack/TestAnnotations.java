package seleniumPack;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestAnnotations {

	@Test(priority = -2, invocationCount = 11)
	public void recordCreation() {
		System.out.println("recordCreation");
	}

	@Test(priority = 1, dependsOnMethods = { "recordCreation" })
	public void paginationTest() {
		System.out.println("paginationTest");
	}

	@Test
	public void noPriority() {
		System.out.println("noPriority");
	}
	@Test(dataProvider = "dataProvider")
	public void testCase(Integer n, String s) {
		System.out.println("testCase");
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("afterMethod");
	}

	@DataProvider
	public Object[][] dataProvider() {
		System.out.println("dataProvider");
		return new Object[][] { new Object[] { 1, "a" }, new Object[] { 2, "b" }, };
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}
}
