package seleniumPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions extends DriverUtil {

	public static void main(String[] args) throws InterruptedException {

		MouseActions obj = new MouseActions();
		WebDriver driver = obj.getDriver();

		WebElement e1 = driver.findElement(By.xpath("//h1[@class='topbullet']"));
		WebElement e2 = driver.findElement(By.xpath("//input[@name='subject']"));
		WebElement e3 = driver.findElement(By.xpath("//a[text()='Testimonials']"));
		WebElement e4 = driver.findElement(By.xpath("//h5[text()='Registration & Reservation']"));

		Actions actions = new Actions(driver);
		// click
		actions.click(e2).build().perform();
		Thread.sleep(3000);

		// double click
		actions.doubleClick(e4).build().perform();
		Thread.sleep(3000);
		// right click
				actions.contextClick(e1).build().perform();
				Thread.sleep(3000);

				// mouse hover
				actions.moveToElement(e3).build().perform();
				Thread.sleep(3000);

				// drag and drop
				actions.dragAndDrop(e1, e2).build().perform();

				// scroll
				js.executeScript("window.scrollBy(0,500);");

			}

		}

