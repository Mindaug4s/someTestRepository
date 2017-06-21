package website.voting.system.county.representative;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import website.voting.system.HomePage;
import website.voting.system.NavBar;

public class CountyRepresentativeProfilePage extends NavBar {

	private WebDriver driver;

	@FindBy(id = "location8")
	private WebElement representativeProfileMenuElement;

	@FindBy(id = "location6")
	private WebElement singleMandateResultsMenuElement;

	@FindBy(id = "location7")
	private WebElement multiMandateResultsMenuElement;

	public CountyRepresentativeProfilePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		new HomePage(driver).getNavigateToAuthorizedAreaButton().click();

		getLoginUserNameField().sendKeys("as.as");
		getLoginPasswordField().sendKeys("asas");
		getLoginConfirmButton().click();
		getUserButtonElement().click();
		getUserProfileEnviromentButtonElement().click();

		// driver.get("http://localhost:8080/#/atstovui/");

	}

	public void navigateToRepresentativeProfile() {
		representativeProfileMenuElement.click();
	}

	public void navigateToSingleMandateResults() {
		singleMandateResultsMenuElement.click();
	}

	public void navigateToMultiMandateResults() {
		multiMandateResultsMenuElement.click();
	}

	public WebElement getRepresentativeProfileMenuElement() {
		return representativeProfileMenuElement;
	}

	public WebElement getSingleMandateResultsMenuElement() {
		return singleMandateResultsMenuElement;

	}

	public WebElement getMultiMandateResultsMenuElement() {
		return multiMandateResultsMenuElement;

	}
}
