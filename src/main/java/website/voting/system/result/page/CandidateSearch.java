package website.voting.system.result.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import website.voting.system.HomePage;
import website.voting.system.NavBar;

public class CandidateSearch extends NavBar {

	private WebDriver driver;

	@FindBy(xpath = "img[@src = 'app/imgs/boss.png']")
	WebElement candidatesTable;
	
	@FindBy(id = "system-search")
	WebElement candidateSearchField;
	

	public CandidateSearch(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		new HomePage(driver).navigateToCandidateSearchSection();
	}

	public WebElement getcandidatesTable() {
		return candidatesTable;
	}

	
	public WebElement getCandidateSearchField() {
		return candidateSearchField;
	}
}
