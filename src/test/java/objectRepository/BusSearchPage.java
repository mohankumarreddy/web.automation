package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.log4testng.Logger;

import seleniumPack.DriverUtil;

public class BusSearchPage extends DriverUtil {

	@FindBy(xpath = "//input[@id='source']")
	WebElement txtFromCity;
	@FindBy(xpath = "//input[@id='destination']")
	WebElement txtToCity;
	@FindBy(xpath = "//input[@id='datepicker1']")
	WebElement txtCalander;
	@FindBy(xpath = "//td[contains(@class,'ui-datepicker-today')]/a")
	WebElement celTravalDateToday;
	@FindBy(xpath = "//a[text()='Search']")
	WebElement btnSearch;

	private WebDriver driver;
	static Logger log = Logger.getLogger(BusSearchPage.class);

	public BusSearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public BusSearchPage setBusSearchDetails(String fromCity, String toCity) {
		log.info("Select from city : " + fromCity);
		setText(txtFromCity, fromCity);
		driver.findElement(By.xpath("//li[text()='" + fromCity + "']")).click();

		log.info("Select to city : " + toCity);
		setText(txtToCity, toCity);
		driver.findElement(By.xpath("//li[text()='" + toCity + "']")).click();

		/*
		 * txtCalander.click(); celTravalDateToday.click();
		 */
		log.info("Select travel date");
		driver.findElement(By.xpath("//input[@id = 'datepicker1']")).click();
		driver.findElement(By.xpath("//div[@id = 'ui-datepicker-div']")).findElement(By.xpath("//a[@title = 'Next']"))
				.click();

		driver.findElement(By.xpath("//td[@data-month = '5']")).findElement(By.xpath("//a[text() = '6']")).click();

		return this;
	}

	public BusSearchResultPage clickSearchButton() {
		
		log.info("Search the bus for given travel date");
		btnSearch.click();
		return new BusSearchResultPage(driver);
	}

}
