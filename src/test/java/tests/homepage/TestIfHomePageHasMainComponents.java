package tests.homepage;

import org.testng.Assert;
import org.testng.annotations.Test;

import tests.BaseTestPattern;
import website.voting.system.HomePage;

public class TestIfHomePageHasMainComponents extends BaseTestPattern {

	private HomePage homePage;

	@Test(priority = 0)
	public void testIfWebPageTitleHeaderIsAvailable() {

		homePage = new HomePage(driver);

		Assert.assertTrue(homePage.getWebPageTitleElement().isDisplayed(),
				"WebPage title header element is not available");
		System.out.println("PASSED: WebPage title header element is available");
	}

	@Test(priority = 1)
	public void testIfLoginButtonAvailble() {

		homePage = new HomePage(driver);

		Assert.assertTrue(homePage.getNavigateToAuthorizedAreaButton().isDisplayed(),
				"Navigate to authorized are / log-in button is not available");

		System.out.println("PASSED: Navigate to authorized are / log-in button is available");

	}

	@Test(priority = 2)
	public void testIfCandidateSearchMenuElementAvailble() {

		homePage = new HomePage(driver);

		Assert.assertTrue(homePage.getCandidateSearchMenuElement().isDisplayed(),
				"Candidate Search menu element is not available");

		System.out.println("PASSED: Candidate Search menu element is available");

	}

	@Test(priority = 3)
	public void testIfSingleMandateResultsMenuElementAvailble() {

		homePage = new HomePage(driver);

		Assert.assertTrue(homePage.getSingleMandateResultsMenuElement().isDisplayed(),
				"Single-mandate voting results menu element is not available");

		System.out.println("PASSED: Single-mandate voting results menu element is available");

	}

	@Test(priority = 4)
	public void testIfMultiMandateResultsMenuElementAvailble() {

		homePage = new HomePage(driver);

		Assert.assertTrue(homePage.getMultiMandateResultsMenuElement().isDisplayed(),
				"PASSED: Multi-mandate voting results menu element is not available");

		System.out.println("PASSED: Multi-mandate voting results menu element is available");
	}

	@Test(priority = 5)
	public void testIfSummarizedResultsMenuElementAvailble() {

		homePage = new HomePage(driver);

		Assert.assertTrue(homePage.getCombinedResultsMenuElement().isDisplayed(),
				"Combined/ summarized voting results menu element is not available");

		System.out.println("PASSED: Combined/ summarized voting results menu element is available");
	}

}
