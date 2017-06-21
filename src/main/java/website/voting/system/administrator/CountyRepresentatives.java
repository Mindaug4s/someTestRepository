package website.voting.system.administrator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import methods.explicit.waits.ExplicitWaits;

public class CountyRepresentatives extends AdministratorPage {

	private WebDriver driver;

	@FindBy(xpath = "//div[contains(@id, 'representative-name-and-surname')]")
	private List<WebElement> countyRepresentativeElementList;

	@FindBy(xpath = "//button[contains(text(), 'Rodyti visus atstovus')]")
	private WebElement showRepresentativesButton;

	@FindBy(id = "representative-name")
	private WebElement inputRepresentativeNameField;

	@FindBy(id = "representative-surname")
	private WebElement inputRepresentativeSurnameField;

	@FindBy(id = "representative-email")
	private WebElement inputRepresentativeEmailField;

	@FindBy(id = "representative-district")
	private WebElement selectRepresentativeDistrictField;

	@FindBy(id = "representative-county")
	private WebElement selectRepresentativeCountyField;

	@FindBy(id = "create-representative-button")
	private WebElement createRepresentativeButton;

	@FindBy(id = "show-hide-button")
	private WebElement showHideButton;

	@FindBy(id = "representatives-search")
	private WebElement representativeSearchField;

	public CountyRepresentatives(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		navigateToCountyRepresentatives();
	}

	public Integer getCountyRepresentativeListSize() {
		return countyRepresentativeElementList.size();
	}

	public WebDriver returnDriver() {
		return driver;
	}

	public WebElement getShowRepresentativesButton() {
		return showRepresentativesButton;
	}

	public WebElement getInputRepresentativeNameField() {
		return inputRepresentativeNameField;
	}

	public WebElement getInputRepresentativeSurnameField() {
		return inputRepresentativeSurnameField;
	}

	public WebElement getInputRepresentativeEmailField() {
		return inputRepresentativeEmailField;
	}

	public Select getSelectRepresentativeDistrictField() {
		return new Select(selectRepresentativeDistrictField);

	}

	public Select getSelectRepresentativeCountyField() {
		return new Select(selectRepresentativeCountyField);
	}

	public WebElement getCreateRepresentativeButton() {
		return createRepresentativeButton;
	}

	public WebElement getShowHideButton() {
		return showHideButton;
	}

	public WebElement getRepresentativeSearchField() {
		return representativeSearchField;
	}

	public WebElement getSpecificRepresentativeNameAndSurname(String representativeName, String representativeSurname) {

		return driver.findElement(
				By.id("representative-name-and-surname-" + representativeName + " " + representativeSurname));
	}

	public WebElement getSpecificRepresentativeDistrictAndCountyElement(String representativeName,
			String representativeSurname) {

		return driver.findElement(By.id("representative-location-" + representativeName + " " + representativeSurname));
	}

	public WebElement getSpecificRepresentativeEmailElement(String representativeName, String representativeSurname) {

		return driver.findElement(By.id("representative-email-" + representativeName + " " + representativeSurname));
	}

	public WebElement getSpecificRepresentativeDeleteButton(String representativeName, String representativeSurname) {

		return driver.findElement(By.id("remove-representative-" + representativeName + " " + representativeSurname));
	}

	public void findTheRepresentativeByNameAndSurename(String representativeName, String representativeSurname) {
		getRepresentativeSearchField().sendKeys(representativeName);
		ExplicitWaits.fluentWait(getSpecificRepresentativeNameAndSurname(representativeName, representativeSurname),
				driver);

	}

	public void createNewCountyRepresentative(String representativeName, String representativeSurname,
			String representativeEmail, String representativeDistrict, String representativeCounty) {

		getInputRepresentativeNameField().sendKeys(representativeName);
		getInputRepresentativeSurnameField().sendKeys(representativeSurname);
		getInputRepresentativeEmailField().sendKeys(representativeEmail);
		getSelectRepresentativeDistrictField().selectByVisibleText(representativeDistrict);
		getSelectRepresentativeCountyField().selectByVisibleText(representativeCounty);
		getCreateRepresentativeButton().click();
	}

	public String normalizeLettersToMatchArchitecture(String currentWord) {

		currentWord.toLowerCase();

		return StringUtils.capitalize(currentWord);
	}

	public void deleteSpecificRepresentative(String representativeName, String representativeSurname) {

		getSpecificRepresentativeDeleteButton(representativeName, representativeSurname).click();
		getConfirmDeleteActionButtonElement().click();
	}

}
