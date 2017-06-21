package website.voting.system.administrator;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import methods.explicit.waits.ExplicitWaits;

public class CountyResults extends AdministratorPage {

	private WebDriver driver;

	@FindBy(xpath = "//span[text() = 'Apylinkių rezultatai']")
	private WebElement districtsResultsHeaderElement;

	@FindBy(xpath = "//div[contains(@id, 'county-tab-')]")
	private List<WebElement> districtResultElementsList;

	@FindBy(xpath = "//p[@id = 'sort-select-district']//select")
	private WebElement districtList;

	@FindBy(xpath = "//p[@id = 'sort-select-county']//select")
	private WebElement countlyList;

	public CountyResults(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		navigateToCountyResults();

	}

	public WebElement getDistrictResultsHeaderElement() {
		return districtsResultsHeaderElement;
	}

	private void assureThatDistricResultFieldIsCollapsed(String districtName, String countyName) {
		// WebElement requiredDistrictResultsElement;
		try {
			while (!driver.findElement(By.id(countyName + "-" + districtName + "-single-mandate")).isDisplayed()) {
				// requiredDistrictResultsElement =
				getSpecificResultsElementByDistrictAndCounty(districtName, countyName).click();
				// requiredDistrictResultsElement.click();
			}

		} catch (NoSuchElementException e) {
			getSpecificResultsElementByDistrictAndCounty(districtName, countyName).click();

		}
	}

	public void filterResultElementsByDistrictAndCounty(String districtName, String countyName) {

		getDistrictListSelect().selectByValue(districtName);
		getCountyListSelect().selectByValue(countyName);

	}

	public WebElement getTheSingleMandateResultsElement(String districtName, String countyName) {

		assureThatDistricResultFieldIsCollapsed(districtName, countyName);
		return driver.findElement(By.id(countyName + "-" + districtName + "-single-mandate"));
	}

	public WebElement getTheMultiMandateResultsElement(String districtName, String countyName) {

		assureThatDistricResultFieldIsCollapsed(districtName, countyName);
		return driver.findElement(By.id(countyName + "-" + districtName + "-multi-mandate"));
	}

	public WebElement getSpecificResultsElementByDistrictAndCounty(String districtName, String countyName) {
		filterResultElementsByDistrictAndCounty(districtName, countyName);

		return driver.findElement(By.id("county-tab-" + countyName + "-" + districtName));

	}

	public List<WebElement> getResultElementListByDistrict(String districtName) {
		return driver.findElements(
				By.xpath("//div[contains(@id, 'county-tab-') and contains(@id, '-" + districtName + "')]"));
	}

	public List<WebElement> getResultElementLisByDistrictAndCount(String districtName, String countyName) {
		return driver.findElements(By.id("county-tab-" + countyName + "-" + districtName));
	}

	public Select getDistrictListSelect() {
		return new Select(districtList);
	}

	public Select getCountyListSelect() {
		return new Select(countlyList);
	}

	public List<WebElement> getCompleteDistricResultElementsList() {
		return districtResultElementsList;
	}

	public WebElement getSpecificRejectVotingResulsButton(String districtName, String countyName) {
		return driver.findElement(By.id("delete-results-button-" + countyName + "-" + districtName));
	}

	public void rejectVotingResults(String districtName, String countyName) {

		filterResultElementsByDistrictAndCounty(districtName, countyName);

		getTheSingleMandateResultsElement(districtName, countyName).click();
		getSpecificRejectVotingResulsButton(districtName, countyName).click();
		getConfirmDeleteActionButtonElement().click();

		try {
			ExplicitWaits.fluentWait(getTheMultiMandateResultsElement(districtName, countyName), driver);
		} catch (Exception e) {
			getTheMultiMandateResultsElement(districtName, countyName);
			getSpecificRejectVotingResulsButton(districtName, countyName);
			getConfirmDeleteActionButtonElement().click();
		}

	}

}
