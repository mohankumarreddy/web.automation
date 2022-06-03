package seleniumPack;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverUtil {
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public String homePath = System.getProperty("user.dir");
	public static String browserName;

	public WebDriver getDriverWithName(String browser) {
		
		browserName = browser;
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			throw new IllegalArgumentException("Invalid browser name, please use chrome or firefox only");
		}

		js = ((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.abhibus.com/");
		return driver;
	}

	public WebDriver getDriver() {

		WebDriverManager.chromedriver().setup(); // setting up the browser - is used instead of System.setProperty

		driver = new ChromeDriver();
		js = ((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.mycontactform.com/samples.php");
		return driver;
	}

	public WebDriver getDriver(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		js = ((JavascriptExecutor) driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get(url);
		return driver;
	}

	// takeScreenshot with specific name
		public void takeScreenshot(String fileName) {
			File screens = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileHandler.copy(screens, new File(homePath + "\\Screenshot" +"\\" + fileName + ".png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	public void selectCheckbox(WebElement element) {
		if (!element.isSelected())
			element.click();
	}

	public void deselectCheckbox(WebElement element) {
		if (element.isSelected())
			element.click();
	}

	public void setText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void selectFromDropDown(WebElement element, int index) {
		Select dd = new Select(element);
		dd.selectByIndex(index);
	}

	public void selectFromDropDown(WebElement element, String value) {
		Select dd = new Select(element);
		dd.selectByValue(value);
	}

	public void selectFromDropDownVisibleText(WebElement element, String visibletext) {
		Select dd = new Select(element);
		dd.selectByVisibleText(visibletext);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public void closeBrowser() {
		driver.close();
	}

	public void executeJS(WebElement target, String jsScript) {
		js.executeScript(jsScript, target);
	}

}

/*
 * public WebDriver getDriver(String url) {
 * 
 * WebDriverManager.chromedriver().setup(); // setting up the browser - is used
 * instead of System.setProperty
 * 
 * driver = new ChromeDriver(); driver.manage().window().maximize();
 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 * 
 * driver.get(url); return driver; }
 * 
 * public void screenCapture(String fileName) throws IOException {
 * 
 * File screens = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
 * FileHandler.copy(screens, new File(homePath +
 * "\\Screenshot\\" + fileName + ".png")); }
 * 
 * public void selectCheckbox(WebElement element) {
 * 
 * if(!element.isSelected()) element.click(); }
 * 
 * public void deselectCheckbox(WebElement element) {
 * 
 * if(element.isSelected()) element.click(); }
 * 
 * public void setText(WebElement element, String text) {
 * 
 * element.clear(); element.sendKeys(text); }
 * 
 * public void selectFromDropDown(WebElement element, int index) {
 * 
 * Select dd = new Select(element); dd.selectByIndex(index); }
 * 
 * public void selectFromDropDown(WebElement element, String value) {
 * 
 * Select dd = new Select(element); dd.selectByValue(value); }
 * 
 * public void selectFromDropDownVisibleText(WebElement element, String
 * visibletext) {
 * 
 * Select dd = new Select(element); dd.selectByVisibleText(visibletext); }
 * 
 * public String getTitle() { return driver.getTitle(); }
 * 
 * public void closeBrowser() { driver.close(); }
 * 
 * }
 */
