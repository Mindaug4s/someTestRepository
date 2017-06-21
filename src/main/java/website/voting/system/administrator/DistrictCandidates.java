package website.voting.system.administrator;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DistrictCandidates extends AdministratorPage {

	private WebDriver driver;
	private boolean isDistrictFieldCollapsed = false;

	@FindBy(xpath = "//div[@style = 'cursor: pointer;']")
	private List<WebElement> districtsList;

	public DistrictCandidates(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		getUserButtonElement().click();
		getUserProfileEnviromentButtonElement().click();
		navigateToDistrictCandidates();
	}

	public Integer districtCount() {
		return districtsList.size();
	}

	public WebElement getDistrictByName(String districtName) {

		return driver.findElement(By.id("district-title-" + districtName));

	}

	public WebElement getSpecificDistrictUploadCandidatesField(String districtName) {
		return driver.findElement(By.id("input-file-" + districtName));
	}

	public WebElement getSpecificDistrictUploadCandidatesButton(String districtName) {
		return driver.findElement(By.id("send-csv-file-button-" + districtName));
	}

	public void uploadCandidatesForSpecificDistrict(String districtName, String pathToFile) {
		Path currentRelativePath = Paths.get("");
		String s = currentRelativePath.toAbsolutePath().toString();
		String pathToADistrictCandidateList = "file:///" + s + "/" + pathToFile;

		assureThatfDistrictFieldIsCollapsed(districtName);
		try {
			getSpecificDistrictUploadCandidatesField(districtName).sendKeys(pathToADistrictCandidateList);
			getSpecificDistrictUploadCandidatesButton(districtName).click();
		} catch (Exception e) {
		}

	}

	public void assureThatfDistrictFieldIsCollapsed(String districtName) {

		if (!isDistrictFieldCollapsed) {
			getDistrictByName(districtName).click();
			isDistrictFieldCollapsed = true;
		}

	}

	public void deleteCandidatesFromSpecificDistrict(String districtName) {
		getSpecificDistrictDeleteCandidatesButton(districtName).click();
		getConfirmDeleteActionButtonElement().click();
	}

	public WebElement getSpecificDistrictDeleteCandidatesButton(String districtName) {
		assureThatfDistrictFieldIsCollapsed(districtName);
		return driver.findElement(By.id("remove-candidates-" + districtName));
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
}
