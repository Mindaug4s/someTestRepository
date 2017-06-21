package website.voting.system;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends NavBar {

	@FindBy(id = "candidate-search-button")
	private WebElement candidateSearchMenuElement;

	@FindBy(id = "single-mandate-results-button")
	private WebElement singleMandateResultsMenuElement;

	@FindBy(id = "multi-mandate-results-button")
	private WebElement multiMandateResultsMenuElement;

	@FindBy(id = "combined-results-button")
	private WebElement combinedResultsMenuElement;

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
		driver.get("http://localhost:8080");

	}

	public void navigateToCandidateSearchSection() {

		candidateSearchMenuElement.click();
	}

	public void navigateSingleMandateResultsSection() {

		singleMandateResultsMenuElement.click();
	}

	public void navigateMultiMandateResultsSection() {

		multiMandateResultsMenuElement.click();
	}

	public void navigateToCombinedResultsSection() {

		combinedResultsMenuElement.click();
	}

	public WebElement getCandidateSearchMenuElement() {
		return candidateSearchMenuElement;
	}

	public WebElement getSingleMandateResultsMenuElement() {
		return singleMandateResultsMenuElement;
	}

	public WebElement getMultiMandateResultsMenuElement() {
		return multiMandateResultsMenuElement;
	}

	public WebElement getCombinedResultsMenuElement() {
		return combinedResultsMenuElement;
	}
}
