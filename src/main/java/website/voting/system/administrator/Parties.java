package website.voting.system.administrator;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Parties extends AdministratorPage {

	WebDriver driver;
	private boolean isPartyCollapsed = false;

	@FindBy(id = "party-list-header")
	private WebElement partyListHeaderElement;

	@FindBy(id = "input-county-name")
	private WebElement inputNewCountyNameField;

	@FindBy(id = "input-file-attach")
	private WebElement uploadPartyCandidatesButton;

	@FindBy(id = "create-party-button")
	private WebElement submitPartyCreationButton;

	public Parties(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		navigateToParties();
	}

	public WebElement getInputNewCountyNameField() {
		return inputNewCountyNameField;
	}

	public WebElement getUploadPartyCandidatesButton() {
		return uploadPartyCandidatesButton;
	}

	public WebElement getSubmitPartyCreationButton() {
		return submitPartyCreationButton;

	}

	public WebElement getPartyByName(String partyName) {

		return driver.findElement(By.id("party-" + partyName));
	}

	public void createPartyAndUploadCandidatesForTHatParty(String partyName, String pathToFile) {

		getInputNewCountyNameField().sendKeys(partyName);

		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String pathToThePartyCandidateList = "file:///" + s + "/" + pathToFile;

		try {
			getUploadPartyCandidatesButton().sendKeys(pathToThePartyCandidateList);
			getSubmitPartyCreationButton().click();
		} catch (Exception e) {
		}

	}

	private void assureThatfPartyFieldIsCollapsed(String partyName) {

		if (!isPartyCollapsed) {
			getSpecificPartyByName(partyName).click();
			isPartyCollapsed = true;

		}

	}

	public WebElement getSpecificPartyByName(String partyName) {
		return driver.findElement(By.id("party-" + partyName));
	}

	public WebElement getSpecificCancidateNameAndSurname(String candidateID) {
		return driver.findElement(By.id("candidate-name-main-" + candidateID));
	}

	public WebElement getSpecificCancidateParty(String candidateID) {
		return driver.findElement(By.id("party-name-main-" + candidateID));
	}

	public WebElement getSpecificCancidateID(String candidateID) {
		return driver.findElement(By.id("candidate-id-main-" + candidateID));
	}

	public WebElement getSpecificCancidateAdditionalInfo(String candidateID) {
		return driver.findElement(By.id("candidate-description-main-" + candidateID));
	}

	public WebElement getDeleteCandidatesFromSpecificPartyButton(String partyName) {
		return driver.findElement(By.id("delete-party-members-" + partyName));
	}

	public WebElement getSpecificPartyEditButton(String partyName) {
		return driver.findElement(By.id("edit-party-" + partyName));
	}

	public WebElement getSpecificPartyDeleteButton(String partyName) {
		return driver.findElement(By.id("delete-party-" + partyName));
	}

	public void deleteCandidatesFromSpecificParty(String partyName) {
		assureThatfPartyFieldIsCollapsed(partyName);
		getDeleteCandidatesFromSpecificPartyButton(partyName).click();
		getConfirmDeleteActionButtonElement().click();
	}

	public void deleteSpecificParty(String partyName) {
		assureThatfPartyFieldIsCollapsed(partyName);
		getSpecificPartyDeleteButton(partyName).click();
		getConfirmDeleteActionButtonElement().click();
	}

	public WebElement getSpecificPartyUploadCandidatesButton(String partyName) {
		return driver.findElement(By.id("send-csv-file-button-" + partyName));
	}
}
