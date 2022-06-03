package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AbhiBus extends DriverUtil {

	public static void main(String[] args) {

		AbhiBus obj = new AbhiBus();
		WebDriver driver = obj.getDriver("https://www.abhibus.com/");
		
		String fromCity = "Chennai";
		String toCity= "Bangalore";

		driver.findElement(By.xpath("//input[@id = 'source']")).sendKeys(fromCity);
		driver.findElement(By.xpath("//li[text() = '" + fromCity + "']")).click();

		driver.findElement(By.xpath("//input[@id = 'destination']")).sendKeys(toCity);
		driver.findElement(By.xpath("//li[text() = '" + toCity + "']")).click();

		
		  driver.findElement(By.xpath("//input[@id = 'datepicker1']")).click();
		  driver.findElement(By.xpath("//div[@id = 'ui-datepicker-div']")).findElement(
		  By.xpath("//a[@title = 'Next']")) .click();
		 
		
//		driver.findElement(By.xpath("//input[@id='datepicker1']")).click();
//		driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]/a")).click();

		driver.findElement(By.xpath("//td[@data-month = '5']")).findElement(By.xpath("//a[text() = '6']")).click();

		driver.findElement(By.xpath("//a[text() = 'Search']")).click();
		
		String seatsAvailable = driver.findElement(By.xpath("//p[contains(text(),'Seats Available')]")).getText();
		seatsAvailable = seatsAvailable.split(" ")[0];
		
		int seatsAvailableExpected = Integer.parseInt(seatsAvailable);		
				
		driver.findElement(By.xpath("//span[text()='Select Seat']")).click();
		
		int seatsAvailableActual  = driver.findElements(By.xpath("//div[@class='borderdtd']//li[not(contains(@class,'unavailable')) and not(@class='noseat')]/a")).size();
		
		System.out.println(seatsAvailableExpected + " - " + seatsAvailableActual);
		
		if (seatsAvailableExpected == seatsAvailableActual) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		driver.close();
	}

}
