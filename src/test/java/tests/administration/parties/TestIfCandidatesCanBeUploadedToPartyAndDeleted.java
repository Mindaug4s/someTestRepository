package tests.administration.parties;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.providers.LinksToDataFiles;
import data.providers.TestDataProviders;
import tests.BaseTestPattern;
import website.voting.system.administrator.Parties;

public class TestIfCandidatesCanBeUploadedToPartyAndDeleted extends BaseTestPattern {

	private String partyName = "testNParty";
	Parties party;

	@Test(priority = 0, dataProvider = "PartyCandidateDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfDistrictCandidatesCanBeAddedToSpecificDistrict(String index, String candidateName,
			String candidateSurname, String candidateID, String candidateAdditionalInfo) {

		party = new Parties(driver);
		party.createPartyAndUploadCandidatesForTHatParty(partyName, LinksToDataFiles.listOfPartyCandidates);
		party.getSpecificPartyByName(partyName).click();

		Assert.assertTrue(party.getSpecificPartyByName(partyName).isDisplayed(), "Party has not been created");
		System.out.println("Party, named \"" + partyName + "\" has been successfully created");

		Assert.assertEquals(party.getSpecificCancidateNameAndSurname(candidateID).getText().trim(),
				candidateName + " " + candidateSurname, "Candidate name and surname don't match");

		System.out.println("Candidate's name and surname match !");

		Assert.assertEquals(party.getSpecificCancidateID(candidateID).getText().trim(), candidateID,
				"Candidate ID does not match");

		System.out.println("Candidate's ID matches !");

		Assert.assertTrue(
				candidateAdditionalInfo.contains(
						party.getSpecificCancidateAdditionalInfo(candidateID).getText().trim().replaceAll("...", "")),
				"Candidate describtion does not match");

		System.out.println("Candidate's describtion matches !");
	}

	@Test(priority = 1)
	public void testIfCandidatesCanBeDeletedFromTheParty() {
		party = new Parties(driver);

		party.deleteCandidatesFromSpecificParty(partyName);

		Assert.assertTrue(party.getSpecificPartyUploadCandidatesButton(partyName).isDisplayed(),
				"The candidates haven't been removed yet");
		System.out.println("Candidates have been removed successfully");

	}

	@Test(priority = 2)
	public void testIfPartyCanBeDeletedFromTheDistrict() {
		boolean isPartyAvailable = true;
		party = new Parties(driver);

		party.deleteSpecificParty(partyName);

		try {
			party.getSpecificPartyByName(partyName);
		} catch (NoSuchElementException e) {
			isPartyAvailable = false;

		}

		Assert.assertFalse(isPartyAvailable, "The candidates haven't been removed yet");
		System.out.println("Party has been removed successfully");

	}

	@Test(priority = 3)
	public void testIfPartyCanBeCreatedWithNullParameters() {
		party = new Parties(driver);

		party.getSubmitPartyCreationButton().click();

		Assert.assertTrue(party.getWarningMessegeElement().isDisplayed(), "The Party was created");
		System.out.println("It is not allowed to create a party with an empty name or without uploadig the Candidates");

	}

}
