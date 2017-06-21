package website.voting.system.county.representative;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleMandateResultsFillingSection extends CountyRepresentativeImplementation {

	private WebDriver driver;

	@FindBy(xpath = "//div[contains(@id, 'candidate-name-')]")
	private List<WebElement> singleMandateCandidateElementList;
	
	@FindBy(xpath = "//div[contains(@id, 'votes-for-candidate-')]")
	private List<WebElement> singleMandateCandidateVoteElementList;

	public SingleMandateResultsFillingSection(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		navigateToSingleMandateResults();
	}

	public List<WebElement> getSingleMandateCandidateList() {

		return singleMandateCandidateElementList;
	}

	public WebElement getCandidateElementByNameAndSurname(String candidateName, String candidateSurename) {
		return driver.findElement(By.id("candidate-name-" + candidateName + "-" + candidateSurename));
	}

	public WebElement getCandidatePartyDependencyElementByNameAndSurname(String candidateName,
			String candidateSurename) {
		return driver.findElement(By.id("party-name-" + candidateName + "-" + candidateSurename));
	}

	public WebElement getVotesInputFieldElementByNameAndSurname(String candidateName, String candidateSurename) {
		return driver.findElement(By.id("votes-for-candidate-" + candidateName + "-" + candidateSurename));
	}
}
