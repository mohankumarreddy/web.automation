package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDiffElements extends DriverUtil{
	
	public static void main(String[] args) throws Exception {
		
		HandlingDiffElements obj = new HandlingDiffElements();
		WebDriver driver = obj.getDriver();
		
		// Check box		
		driver.findElement(By.name("email_to[]")).click();
		
		// Text box
		driver.findElement(By.name("subject")).sendKeys("Selenium Webdriver");
		
		driver.findElement(By.name("email")).sendKeys("test123@mail.com");
		
		// Check box with same name and type - used xpath
		// xpath syntax = //tagname[@attributeName='attribute value']
		
		driver.findElement(By.xpath("//input[@value='Third Check Box']")).click();
	
		
		//Drop-down
		Select dd = new Select(driver.findElement(By.name("q3")));
		
		dd.selectByIndex(1);
		Thread.sleep(2000);
		dd.selectByValue("Fourth Option");
		Thread.sleep(2000);
		dd.selectByVisibleText("Third Option");
		Thread.sleep(2000);
		
		//Radio
		driver.findElement(By.name("q4")).click();
		
		//FileUpload
		driver.findElement(By.name("attach4589")).sendKeys("C:\\Users\\smoha\\Downloads\\Test.txt");
		
		//Button
		driver.findElement(By.name("submit")).click();
		
		// Text or Paragraph or Label or Error Message or Success Message
		String err = driver.findElement(By.xpath("//li")).getText();
		// above step using tagName String err = driver.findElement(By.tagName("li")).getText();
		System.out.println(err);
		
		driver.navigate().back();
		
		// links
		driver.findElement(By.linkText("Course Evaluation")).click();
		// using partial link text - driver.findElement(By.partialLinkText("Course Eval")).click();
		
		//Locators - 8
		// id, name, linkText, partialLinkText
		// tagName, className, xpath, cssSelector
				
	}

}
