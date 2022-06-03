package seleniumPack;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumBasics {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup(); // setting up the browser - is used instead of System.setProperty 
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.gmail.com");
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		// System.out.println(driver.getPageSource());
		
		// Navigation methods
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
				
		driver.close();
	}
   	

}
