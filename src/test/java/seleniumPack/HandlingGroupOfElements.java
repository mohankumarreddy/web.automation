package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HandlingGroupOfElements extends DriverUtil {
	
	public static void main(String[] args) {
		
		HandlingGroupOfElements obj = new HandlingGroupOfElements();
		WebDriver driver = obj.getDriver();
		
		List<WebElement> allCheckbox = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		System.out.println(allCheckbox.size());
		
		for(int i = 0; i < allCheckbox.size(); i++) {
			allCheckbox.get(i).click();
		}
		for (WebElement ch : allCheckbox) {
			ch.click();
		}
		
		allCheckbox.stream().forEach(ch -> ch.click());
		
	}

}
