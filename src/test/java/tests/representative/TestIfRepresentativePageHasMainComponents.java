package tests.representative;

import org.testng.Assert;
import org.testng.annotations.Test;

import tests.BaseTestPattern;
import website.voting.system.county.representative.CountyRepresentativeProfilePage;

public class TestIfRepresentativePageHasMainComponents extends BaseTestPattern {

	CountyRepresentativeProfilePage representative;

	@Test(priority=0)
	public void testIfSingleMandateVotingResultsWebpartIsAvailable() {
		representative = new CountyRepresentativeProfilePage(driver);

		Assert.assertTrue(representative.getSingleMandateResultsMenuElement().isDisplayed(),
				"Single-mandate Voting results menu element is not available");

		representative.getSingleMandateResultsMenuElement().click();
		System.out.println("Single-mandate Voting results menu element is available");
	}
	
	@Test(priority=1)
	public void testIfMultisMandateVotingResultsWebpartIsAvailable() {
		representative = new CountyRepresentativeProfilePage(driver);

		Assert.assertTrue(representative.getMultiMandateResultsMenuElement().isDisplayed(),
				"Multi-mandate Voting results menu element is not available");

		representative.getMultiMandateResultsMenuElement().click();
		System.out.println("Multi-mandate Voting results menu element is available");
	}
}
