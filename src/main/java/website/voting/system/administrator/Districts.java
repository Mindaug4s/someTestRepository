package website.voting.system.administrator;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import methods.explicit.waits.ExplicitWaits;

import org.hamcrest.text.*;

public class Districts extends AdministratorPage {

	WebDriver driver;
	private boolean isDistrictCollapsed = false;

	@FindBy(id = "district-list-header")
	private WebElement districtsListHeaderElement;

	@FindBy(id = "sorting-button")
	private WebElement sortingButton;

	@FindBy(xpath = "//div[contains(@id, 'district-')]")
	private List<WebElement> districtElementList;

	@FindBy(xpath = "//p[contains(@id, 'county-title-')]")
	private List<WebElement> countyElementList;

	@FindBy(id = "input-district-name")
	private WebElement inputNewDistrictNameField;

	@FindBy(id = "add-new-county-button")
	private WebElement addNewCountytButton;

	@FindBy(id = "input-county-name")
	private WebElement inputNewCountyNameField;

	@FindBy(id = "input-county-voters")
	private WebElement inputQuantityOfCitizenField;

	@FindBy(id = "input-county-address")
	private WebElement inputCountyAddressField;

	@FindBy(id = "create-county-button")
	private WebElement createNewCountyButton;

	@FindBy(id = "cancel-county-creation-button")
	private WebElement cancelCountyCreationButton;

	@FindBy(id = "create-district-button")
	private WebElement createNewDistrictButton;

	public Districts(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		navigateToDistricts();
	}

	public List<WebElement> getCountyElementList() {
		return countyElementList;
	}

	public WebElement getDistrictListHeaderElement() {
		return districtsListHeaderElement;
	}

	public WebElement getSortingButtonElement() {
		return sortingButton;
	}

	public Integer districtCount() {
		return districtElementList.size();
	}

	public WebElement getInputNewDistrictNameField() {
		return inputNewDistrictNameField;
	}

	public WebElement getAddNewCountytButton() {
		return addNewCountytButton;
	}

	public WebElement getInputNewCountyNameField() {
		return inputNewCountyNameField;
	}

	public WebElement getInputQuantityOfCitizenField() {
		return inputQuantityOfCitizenField;
	}

	public WebElement getNewCountyAddressField() {
		return inputCountyAddressField;
	}

	public WebElement getCreateNewCountyButton() {
		return createNewCountyButton;
	}

	public WebElement getCancelCountyCreationButton() {
		return cancelCountyCreationButton;
	}

	public WebElement getCreateNewDistrictButton() {
		return createNewDistrictButton;
	}

	public WebElement getSpecificCountyListHeaderByDistrict(String districtName) {
		return driver.findElement(By.id("counties-header-" + districtName));
	}

	private void assureThatfDistrictFieldIsCollapsed(String districtName) {

		if (!isDistrictCollapsed) {
			getExistingDistrictByName(districtName).click();
			isDistrictCollapsed = true;
		}

	}

	private void assureThatfEditCountyButtonIsPressed(String districtName, String countyName) {
		List<WebElement> editableCOuntyFieldsList = new ArrayList<>();

		getSpecificCountiesEditButton(districtName, countyName).click();
		editableCOuntyFieldsList = driver.findElements(By.xpath("//input[contains(@id, '" + countyName + "')]"));
		editableCOuntyFieldsList.forEach(element -> element.clear());

	}

	public WebElement getExistingDistrictByName(String districtName) {
		return driver.findElement(By.id("district-" + districtName));
	}

	public WebElement getSpecificDistrictSortButtonByName(String districtName) {
		assureThatfDistrictFieldIsCollapsed(districtName);
		return driver.findElement(By.id("sorting-button-" + districtName));
	}

	public WebElement getSpecificCountyByName(String districtName, String countyName) {
		assureThatfDistrictFieldIsCollapsed(districtName);
		return driver.findElement(By.id("county-title-" + countyName));
	}

	public WebElement getSpecificCountyVoteCount(String districtName, String countyName) {

		assureThatfDistrictFieldIsCollapsed(districtName);
		return driver.findElement(By.id("county-voters-count-" + countyName));

	}

	public WebElement getSpecificCountiesAddress(String districtName, String countyName) {

		assureThatfDistrictFieldIsCollapsed(districtName);
		return driver.findElement(By.id("county-address-" + countyName));

	}

	public WebElement getSpecificCountiesEditButton(String districtName, String countyName) {

		assureThatfDistrictFieldIsCollapsed(districtName);
		return driver.findElement(By.id("edit-county-button-" + countyName));

	}

	public WebElement getSpecificCountiesEditableNameField(String districtName, String countyName) {
		driver.findElement(By.id("input-county-" + countyName)).clear();

		return driver.findElement(By.id("input-county-" + countyName));

	}

	public WebElement getSpecificCountiesEditableVoterCountField(String districtName, String countyName) {
		driver.findElement(By.id("input-voters-count-" + countyName)).clear();
		return driver.findElement(By.id("input-voters-count-" + countyName));

	}

	public WebElement getSpecificCountiesEditableAddressField(String districtName, String countyName) {
		driver.findElement(By.id("input-county-address-" + countyName)).clear();
		return driver.findElement(By.id("input-county-address-" + countyName));

	}

	public WebElement getSpecificCountiesConfirmUpdateButton(String districtName, String countyName) {

		return driver.findElement(By.id("create-county-btn-" + countyName));

	}

	public WebElement getSpecificCountiesCancelUpdateButton(String districtName, String countyName) {

		return driver.findElement(By.id("cancel-county-creation-" + countyName));

	}

	public WebElement getSpecificCountiesDeleteButton(String districtName, String countyName) {

		assureThatfDistrictFieldIsCollapsed(districtName);
		return driver.findElement(By.id("remove-county-button-" + countyName));

	}

	public WebElement getSpecificDistrictDeleteButton(String districtName) {

		assureThatfDistrictFieldIsCollapsed(districtName);

		return driver.findElement(By.id("remove-district-" + districtName));
	}

	public WebElement getSpecificDistrictEditButton(String districtName) {

		assureThatfDistrictFieldIsCollapsed(districtName);
		return driver.findElement(By.id("edit-district-" + districtName));
	}

	public void createNewDistrict(String districName) {

		getInputNewDistrictNameField().clear();

		getInputNewDistrictNameField().sendKeys(districName);

		getCreateNewDistrictButton().click();

	}

	public void createNewDistrictAndCounty(String districtName, String countyName, String quantityOfVoters,
			String address) {

		getAddNewCountytButton().click();

		getNewCountyAddressField().sendKeys(address);
		try {
			ExplicitWaits.waitUntilAddressFieldIsLoaded(driver,
					driver.findElement(By.xpath("//li[contains(@class, 'geo')]")));
		} catch (NoSuchElementException e) {
		}

		getInputNewDistrictNameField().clear();

		getInputNewDistrictNameField().sendKeys(districtName);

		getInputNewCountyNameField().sendKeys(countyName);

		getInputQuantityOfCitizenField().sendKeys(quantityOfVoters);

		getCreateNewCountyButton().click();

		try {

			if (!getWarningMessegeElement().isDisplayed()) {
				getCreateNewDistrictButton().click();
			}
		} catch (NoSuchElementException e) {
			getCreateNewDistrictButton().click();
		}

	}

	public void deleteSpecificDistrict(String districtName) {

		getSpecificDistrictDeleteButton(districtName).click();
		getConfirmDeleteActionButtonElement().click();

	}

	public void editSpecificCounty(String districtName, String countyName, String newCountyName, String newVoterCount,
			String newAddress) {

		assureThatfEditCountyButtonIsPressed(districtName, countyName);
		getSpecificCountiesEditableAddressField(districtName, countyName).sendKeys(newAddress);
		getSpecificCountiesEditableNameField(districtName, countyName).sendKeys(newCountyName);

		try {
			ExplicitWaits.waitUntilAddressFieldIsLoaded(driver,
					driver.findElement(By.xpath("//li[contains(@class, 'geo')]")), newAddress);
		} catch (Exception e) {
		}

		getSpecificCountiesEditableVoterCountField(districtName, countyName).sendKeys(newVoterCount);

		getSpecificCountiesConfirmUpdateButton(districtName, countyName).click();

	}

	public void editSpecificDistrict(String districtName, String newDistrictName) {

		getSpecificDistrictEditButton(districtName).click();
		getSpecificDistrictEditableNameField(districtName).sendKeys(newDistrictName);
		getDistrictConfirmEditButton().click();

	}

	public WebElement getSpecificDistrictEditableNameField(String districtName) {

		driver.findElement(By.id("edit-district-name-field-" + districtName)).clear();

		return driver.findElement(By.id("edit-district-name-field-" + districtName));
	}

	public WebElement getDistrictConfirmEditButton() {
		return driver.findElement(By.xpath("//button[text() = 'Atnaujinti']"));
	}

	public WebElement getDistrictCancelEditButton() {
		return driver.findElement(By.xpath("//button[contains(@id, 'inline-cancel-btn-')]"));
	}

}
