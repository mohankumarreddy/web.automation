package selPractice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup(); // setting up the browser - is used instead of System.setProperty

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		driver.findElement(By.linkText("Register")).click();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.navigate().back();
		
		driver.findElement(By.xpath("//input[@value='Log In']")).click();
		
		System.out.println(driver.findElement(By.xpath("//p[@class='error']")).getText());
		
		driver.close();
	}

}
