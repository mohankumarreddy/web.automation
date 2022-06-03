package seleniumPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AllDropDown extends DriverUtil {

	public static void main(String[] args) {

		AllDropDown obj = new AllDropDown();
		WebDriver driver = obj.getDriver();

		List<WebElement> allDropDown = driver.findElements(By.tagName("select"));
		System.out.println(allDropDown.size());

		for (int i = 0; i < allDropDown.size(); i++) {

			Select dd = new Select(allDropDown.get(i));

			List<WebElement> dropDownValues = allDropDown.get(i).findElements(By.tagName("option"));

			System.out.println(dropDownValues.size() + "  " + dropDownValues.get(dropDownValues.size() - 1).getText());

			dd.selectByIndex(dropDownValues.size() - 1);
		}
		driver.close();
	}

}
