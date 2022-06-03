package seleniumPack;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HandlingWindowFramesandAlert extends DriverUtil{
	
	public static void main(String[] args) throws Exception {
		
		HandlingWindowFramesandAlert obj = new HandlingWindowFramesandAlert();
		WebDriver driver = obj.getDriver("https://www.w3schools.com/jsref/met_win_alert.asp");
		
		obj.takeScreenshot("HomePage");
		
		driver.findElement(By.linkText("Try it Yourself »")).click();
				
		Set<String> allWindIDs = driver.getWindowHandles();
		driver.switchTo().window(allWindIDs.toArray()[1].toString());
		
		obj.takeScreenshot("TryPage");
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text() = 'Try it']")).click();
		
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept(); //ok or yes
		// driver.switchTo().alert().dismiss(); //Cancel or No or Close
		
	}

}
