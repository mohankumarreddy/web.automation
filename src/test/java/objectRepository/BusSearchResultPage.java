package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import seleniumPack.DriverUtil;

public class BusSearchResultPage extends DriverUtil {

	@FindBy(xpath = "//span[text() = 'Select Seat']")
	WebElement btnSearchSeat;
	@FindBy(xpath = "//div[@class='borderdtd']//li[not(contains(@class,'unavailable')) and not(@class='noseat')]/a")
	List<WebElement> seatsAvailableAll;
	@FindBy(xpath = "//p[text()='Total Fare']/following-sibling::p//span[@id='ticketfare']")
	WebElement totalFare;
	@FindBy(xpath = "//select[@id = 'boardingpoint_id']")
	WebElement drdBoardingPoint;
	@FindBy(xpath = "//select[@id = 'droppingpoint_id']")
	WebElement drdDroppingPoint;
	@FindBy(xpath = "//input[@value= 'Continue to Payment']")
	WebElement btnContinuePayment;
	@FindBy(xpath = "//strong[contains(@class, 'TickRate')]")
	WebElement lblSingleSeatPrice;

	private WebDriver driver;
	public float total = 0;

	public BusSearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void clickSelectSeatButton() {
		btnSearchSeat.click();
	}

	public float getTotalFare() {
		return Float.parseFloat(totalFare.getText().trim());
	}

	public BusSearchResultPage selectAvailableSeats(int numberOfSeats) {
		for (int i = 0; i < numberOfSeats; i++) {
			seatsAvailableAll.get(i).click();
		}
		return this;
	}

	public float getSeatPrice() {
		return Float.parseFloat(lblSingleSeatPrice
				.getText()
				.replaceAll("[^0-9]", ""));
	}

	public void selectBoardingPoint() {
		selectFromDropDown(drdBoardingPoint, 1);
	}

	public void selectDroppingPoint() {
		selectFromDropDown(drdDroppingPoint, 1);
	}

	public void continuePayment() {
		btnContinuePayment.click();
	}

}
