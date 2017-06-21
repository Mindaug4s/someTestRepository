package website.voting.system.county.representative;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

abstract class CountyRepresentativeImplementation extends CountyRepresentativeProfilePage {

	private WebDriver driver;

	@FindBy(id = "header-title-spoiled-votes")
	private WebElement spoiledVotesHeaderElement;

	@FindBy(id = "header-title-result-form")
	private WebElement resultFormHeaderElement;

	@FindBy(xpath = "//div[text()='Apylinkės duomenys']")
	private WebElement countyInformationHeaderElement;

	@FindBy(id = "input-field-spoiled-votes")
	private WebElement spoiledVotesInputFieldElement;

	@FindBy(id = "county-title-info")
	private WebElement countyInfoTitleElement;

	@FindBy(id = "voters-count-info")
	private WebElement countyInfoVotersCountElement;

	@FindBy(id = "county-address-info")
	private WebElement countyInfoAdressElement;

	@FindBy(id = "district-title-info")
	private WebElement countyInfoDistrictNameElement;

	@FindBy(id = "send-county-results-button")
	private WebElement confirmAndSendVotingResultsButtonElement;

	@FindBy(id = "clear-form-button")
	private WebElement clearTheVotingResultsButtonEleMent;

	@FindBy(xpath = "//input[contains(@id, 'votes-for-candidate-')]")
	private List<WebElement> singleMandateResultFields;

	@FindBy(xpath = "//input[contains(@id, 'party-votes-input-')]")
	private List<WebElement> multiMandateResultFields;

	@FindBy(xpath = "//img[@src = 'app/imgs/time.png']")
	private WebElement confirmationThatResultsHaveBeenUploadedElement;

	CountyRepresentativeImplementation(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getspoiledVotesHeaderElement() {
		return spoiledVotesHeaderElement;
	}

	public WebElement getResultFormHeaderElement() {
		return resultFormHeaderElement;
	}

	public WebElement getCountyInformationHeaderElement() {
		return countyInformationHeaderElement;
	}

	public WebElement getSpoiledVotesInputFieldElement() {
		return spoiledVotesInputFieldElement;
	}

	public WebElement getCountyInfoTitleElement() {
		return countyInfoTitleElement;
	}

	public WebElement getCountyInfoVotersCountElement() {
		return countyInfoVotersCountElement;
	}

	public WebElement getCountyInfoAdressElement() {
		return countyInfoAdressElement;
	}

	public WebElement getCountyInfoDistrictNameElement() {
		return countyInfoDistrictNameElement;
	}

	public WebElement getConfirmAndSendVotingResultsButtonElement() {
		return confirmAndSendVotingResultsButtonElement;
	}

	public WebElement getClearTheVotingResultsButtonEleMent() {
		return clearTheVotingResultsButtonEleMent;
	}

	public List<WebElement> getSingleMandateResultFields() {
		return singleMandateResultFields;
	}

	public List<WebElement> getMultiMandateResultFields() {
		return multiMandateResultFields;
	}

	public void fillSingleMandateVotingResults(String spoiledTickets, String votesForCandidates) {

		try {
			getSpoiledVotesInputFieldElement().sendKeys(spoiledTickets);
			getSingleMandateResultFields().forEach(vote -> vote.sendKeys(votesForCandidates));

			getConfirmAndSendVotingResultsButtonElement().click();
		} catch (Exception e) {
		}
	}

	public void fillMultiMandateVotingResults(String spoiledTickets, String votesForCandidates) {

		try {
			getSpoiledVotesInputFieldElement().sendKeys(spoiledTickets);
			getMultiMandateResultFields().forEach(vote -> vote.sendKeys(votesForCandidates));

			getConfirmAndSendVotingResultsButtonElement().click();
		} catch (Exception e) {
		}

	}

	public WebElement getConfirmationThatResultsHaveBeenUploadedElement() {
		return confirmationThatResultsHaveBeenUploadedElement;
	}
}
