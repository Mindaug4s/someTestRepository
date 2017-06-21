package tests.administration.districtCandidates;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.providers.LinksToDataFiles;
import data.providers.TestDataProviders;
import tests.BaseTestPattern;
import website.voting.system.administrator.DistrictCandidates;
import website.voting.system.administrator.Districts;

public class TestIfCandidatesCanBeAddedAndDeleted extends BaseTestPattern {
	private final String districtName = "ImanigableDistrict";
	DistrictCandidates candidates;
	Districts districts;

	@Test(priority = 0)
	public void prepareTheDistrict() {
		districts = new Districts(driver);
		districts.createNewDistrict(districtName);
	}

	@Test(priority = 1, dataProvider = "DistrictCandidatedDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfDistrictCandidatesCanBeAddedToSpecificDistrict(String candidateName, String candidateSurname,
			String candidateID, String candidateParty, String candidateAdditionalInfo) {

		candidates = new DistrictCandidates(driver);

		candidates.uploadCandidatesForSpecificDistrict(districtName, LinksToDataFiles.listOfDistrictCandidates);

		Assert.assertEquals(candidates.getSpecificCancidateNameAndSurname(candidateID).getText().trim(),
				candidateName + " " + candidateSurname, "Candidate name and surname don't match");

		System.out.println("Candidate's name and surname match !");

		Assert.assertEquals(candidates.getSpecificCancidateID(candidateID).getText().trim(), candidateID,
				"Candidate ID does not match");

		System.out.println("Candidate's ID matches !");
		

		Assert.assertTrue(candidateAdditionalInfo.contains(
				candidates.getSpecificCancidateAdditionalInfo(candidateID).getText().trim().replaceAll("...", "")),
				"Candidate describtion does not match");

		System.out.println("Candidate's describtion matches !");

	}

	@Test(priority=2)
	public void testIfCandidatsCanBeRemovedFromTheDistrict() {
		candidates = new DistrictCandidates(driver);
		candidates.deleteCandidatesFromSpecificDistrict(districtName);

		Assert.assertTrue(candidates.getSpecificDistrictUploadCandidatesButton(districtName).isDisplayed(),
				"Candidates haven't been removed");
		
		System.out.println("Candidates have been successfully removed");
	}

	@Test(priority = 3)
	public void removeTheDistrict() {
		districts = new Districts(driver);
		districts.deleteSpecificDistrict(districtName);
	}

}
