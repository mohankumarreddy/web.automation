package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestingMethods extends DriverUtil{
	
	public static void main(String[] args) throws InterruptedException {
		
		TestingMethods obj = new TestingMethods();
		WebDriver driver = obj.getDriver();
		
		WebElement e1 = driver.findElement(By.name("email_to[]"));
		WebElement e2 = driver.findElement(By.id("subject"));
		WebElement e3 = driver.findElement(By.id("q3"));
		WebElement e4 = driver.findElement(By.id("q8"));
		WebElement e5 = driver.findElement(By.id("q9"));
		String t = "Selenium";
		int n = 2;
		String v = "CA";
		String vt = "Argentina";
		
		obj.selectCheckbox(e1);
		Thread.sleep(2000);
		
		obj.deselectCheckbox(e1);
		
		obj.setText(e2, t);
		
		obj.selectFromDropDown(e3, n);
		
		obj.selectFromDropDown(e4, v);
		
		obj.selectFromDropDownVisibleText(e5, vt);
		
		driver.close();
		
	}

}
