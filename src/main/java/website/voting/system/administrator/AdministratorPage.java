package website.voting.system.administrator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import website.voting.system.HomePage;
import website.voting.system.NavBar;

public class AdministratorPage extends NavBar{


	@FindBy(id = "location1")
	private WebElement districtsMenuElement;

	@FindBy(id = "location2")
	private WebElement districtCandidatesMenuElement;

	@FindBy(id = "location3")
	private WebElement countyRepresentativesMenuElement;

	@FindBy(id = "location4")
	private WebElement partiesMenuElement;

	@FindBy(id = "location5")
	private WebElement countyResultsMenuElement;

	public AdministratorPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		//driver.get("http://localhost:9000/#/administravimas");
		//new HomePage(driver).navigateToAdministration();
		driver.get("http://localhost:8080/");
		getNavigateToAuthorizedAreaButton().click();
		getLoginUserNameField().sendKeys("admin.admin");
		getLoginPasswordField().sendKeys("admin");
		getLoginConfirmButton().click();
		getUserButtonElement().click();
		getUserProfileEnviromentButtonElement().click();
	}

	public void navigateToDistricts() {

		districtsMenuElement.click();
	}

	public void navigateToDistrictCandidates() {

		districtCandidatesMenuElement.click();
	}

	public void navigateToCountyRepresentatives() {

		countyRepresentativesMenuElement.click();

	}

	public void navigateToParties() {

		partiesMenuElement.click();
	}

	public void navigateToCountyResults() {

		countyResultsMenuElement.click();

	}

	public WebElement getDistrictsMenuElement() {
		return districtsMenuElement;
	}

	public WebElement getDistrictCandidatesMenuElement() {
		return districtCandidatesMenuElement;

	}

	public WebElement getCountyRepresentativesMenuElement() {
		return countyRepresentativesMenuElement;

	}

	public WebElement getPartiesMenuElement() {
		return partiesMenuElement;

	}

	public WebElement getCountyResultsMenuElement() {
		return countyResultsMenuElement;

	}
}
