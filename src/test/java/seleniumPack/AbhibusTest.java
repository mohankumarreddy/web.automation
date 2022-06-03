/*
 * package seleniumPack;
 * 
 * import org.assertj.core.api.Assertions; import
 * org.testng.annotations.AfterMethod; import
 * org.testng.annotations.BeforeMethod; import org.testng.annotations.Test;
 * 
 * import objectRepository.BusSearchPage;
 * 
 * public class AbhibusTest extends DriverUtil {
 * 
 * BusSearchPage busSearchPage;
 * 
 * @Test public void verifyBusSearchFunctionWorkingForValidInput() { String
 * fromCity = "Chennai"; String toCity = "Bangalore";
 * 
 * busSearchPage.setBusSearchDetails(fromCity, toCity);
 * busSearchPage.clickSearchButton();
 * 
 * String title = driver.getTitle();
 * Assertions.assertThat(title).as("Title is not matching with some conditions")
 * .startsWith(fromCity)
 * .contains(toCity).endsWith("Bus Tickets at Abhibus.com"); }
 * 
 * @BeforeMethod public void beforeMethod() {
 * getDriver("https://www.abhibus.com/"); busSearchPage = new
 * BusSearchPage(driver); }
 * 
 * @AfterMethod public void afterMethod() { driver.close(); }
 * 
 * }
 */

package seleniumPack;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import objectRepository.BusSearchPage;
import objectRepository.BusSearchResultPage;

public class AbhibusTest extends DriverUtil {

	BusSearchPage busSearchPage;
	BusSearchResultPage busSearchResultPage;
	
	
	

	@DataProvider // Egar
	public String[][] getTravelDetails() {
		String[][] data = { { "Chennai", "Bangalore" }, { "Bangalore", "Chennai" }, { "Hyderabad", "Bangalore" } };
		return data;
	}
	
	@DataProvider
	public String[][] getTravelDetailsExcel() throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./src/test/resources/TravelDetails.xlsx");
		XSSFSheet sh1 = wb.getSheet("Sheet1");

		int rowsCount = sh1.getLastRowNum() + 1;
		String[][] data = new String[rowsCount][2];
		for (int i = 0; i < rowsCount; i++) {
			data[i][0] = sh1.getRow(i).getCell(0).getStringCellValue();
			data[i][1] = sh1.getRow(i).getCell(1).getStringCellValue();
			wb.close();
		}
		return data;
	}


	@Test(enabled = false, dataProvider = "getTravelDetailsExcel")
	public void verifyBusSearchFunctionWorkingForValidInput(String fromCity, String toCity) {
		busSearchPage.setBusSearchDetails(fromCity, toCity).clickSearchButton();

		assertThat(getTitle()).as("Title is not matching with some conditions").startsWith(fromCity).contains(toCity)
				.endsWith("Bus Tickets at Abhibus.com");
	}

	/*
	 * @Test public void verifyBusSearchFunctionWorkingForValidInput() { String
	 * fromCity = "Chennai"; String toCity = "Bangalore";
	 * 
	 * busSearchPage.setBusSearchDetails(fromCity, toCity).clickSearchButton();
	 * 
	 * assertThat(getTitle()) .as("Title is not matching with some conditions")
	 * .startsWith(fromCity)
	 * .contains(toCity).endsWith("Bus Tickets at Abhibus.com");
	 * 
	 * }
	 */

	@DataProvider
	public String[][] getFromAndTo() {
		String[][] fromTo = { { "Chennai", "Bangalore" } };
		return fromTo;
	}

	@Test(enabled = true, dataProvider = "getFromAndTo")
	public void verifyTotalFare(String fromCity, String toCity) throws Exception {
		
		int numberOfSeats = 2;
		busSearchPage.setBusSearchDetails(fromCity, toCity).clickSearchButton();
		busSearchResultPage.clickSelectSeatButton();
		busSearchResultPage.selectAvailableSeats(numberOfSeats);
		float actualTotallFare = busSearchResultPage.getTotalFare();
		float expectedTotalFare = numberOfSeats*busSearchResultPage.getSeatPrice();
		
		assertThat(actualTotallFare)
		.as("Actual and Expected Total Price not matching")
		.isGreaterThanOrEqualTo(expectedTotalFare);
		
		/*
		 * busSearchResultPage.selectBoardingPoint();
		 * busSearchResultPage.selectDroppingPoint();
		 * busSearchResultPage.continuePayment();
		 */
	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(String browser) {

		PropertyConfigurator.configure("./log4j.properties");

		getDriverWithName(browser);
		busSearchPage = new BusSearchPage(driver);
	}

	@AfterMethod
	public void afterMethod() {
		closeBrowser();
	}

}
