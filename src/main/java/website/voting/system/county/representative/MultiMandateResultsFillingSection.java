package website.voting.system.county.representative;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultiMandateResultsFillingSection extends CountyRepresentativeImplementation {

	private WebDriver driver;

	@FindBy(xpath = "//div[contains(@id, 'party-name-')]")
	private List<WebElement> multiMandatePartyList;

	public MultiMandateResultsFillingSection(WebDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		navigateToMultiMandateResults();
	}

	public List<WebElement> getMultiMandatePartyList() {

		return multiMandatePartyList;
	}

	public WebElement getMultiMandatePartyElementByName(String partyName) {
		return driver.findElement(By.id("party-name-" + partyName));
	}

	
	public WebElement getMultiMandateVotesInputFieldElementByPartyName(String partyName) {
		return driver.findElement(By.id("party-votes-input-" + partyName));
	}
}
