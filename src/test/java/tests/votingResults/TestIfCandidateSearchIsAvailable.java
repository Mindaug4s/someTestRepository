package tests.votingResults;

import org.testng.Assert;
import org.testng.annotations.Test;

import tests.BaseTestPattern;
import website.voting.system.result.page.CandidateSearch;

public class TestIfCandidateSearchIsAvailable extends BaseTestPattern {

	CandidateSearch candidateSearch;

	@Test
	public void testIfMainCandidateSearchComponentsAreAvailable() {

		candidateSearch = new CandidateSearch(driver);

		Assert.assertTrue(candidateSearch.getCandidateSearchField().isDisplayed(), "Main element is not available");

		System.out.println("Main element is present");

	}

}
