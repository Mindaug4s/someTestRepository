package tests.representative;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import tests.BaseTestPattern;
import website.voting.system.administrator.CountyResults;
import website.voting.system.county.representative.MultiMandateResultsFillingSection;
import website.voting.system.county.representative.SingleMandateResultsFillingSection;

public class TestIfRepresentativeCanUploadResultsAndAdminRejectThem extends BaseTestPattern {

	private SingleMandateResultsFillingSection representativeSingle;
	private MultiMandateResultsFillingSection representativeMulti;
	private String districtName;
	private String countyName;
	private CountyResults results;

	@Test(priority = 0, dataProvider = "ValidVotesDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfSingleMandateVotingResultsCanBeUploaded(String spoiledTickets, String votesForCandidates) {
		representativeSingle = new SingleMandateResultsFillingSection(driver);

		this.districtName = representativeSingle.getCountyInfoDistrictNameElement().getText().trim();
		this.countyName = representativeSingle.getCountyInfoTitleElement().getText().trim();

		representativeSingle.fillSingleMandateVotingResults(spoiledTickets, votesForCandidates);

		Assert.assertTrue(representativeSingle.getConfirmationThatResultsHaveBeenUploadedElement().isDisplayed(),
				"Single-mandate Voting results has not been uploaded");
		System.out.println("Single-mandate Voting results has been successfully uploaded!");
	}

	@Test(priority = 1, dataProvider = "ValidVotesDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfMultiMandateVotingResultsCanBeUploaded(String spoiledTickets, String votesForCandidates) {
		representativeMulti = new MultiMandateResultsFillingSection(driver);

		representativeMulti.fillMultiMandateVotingResults(spoiledTickets, votesForCandidates);

		Assert.assertTrue(representativeMulti.getConfirmationThatResultsHaveBeenUploadedElement().isDisplayed(),
				"Multi-mandate Voting results has not been uploaded");
		System.out.println("Multi-mandate Voting results has been successfully uploaded!");
	}

	@Test(priority = 2)
	public void testIfAdministratorCanRejectVotingResults() {

		results = new CountyResults(driver);

		results.rejectVotingResults(districtName, countyName);
		
		System.out.println("Success, voting result data have been deleted!");

	}

}
