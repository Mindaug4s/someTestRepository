package tests.administration.countyRepresentatives;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import tests.BaseTestPattern;
import website.voting.system.administrator.CountyRepresentatives;
import website.voting.system.administrator.Districts;

public class TestIfCountyRepresentativeCanBeCreatedAndDeleted extends BaseTestPattern {
	private Districts districts;
	private String districtName = "districtForTesting";
	private String countyName = "countyForTesting";
	private String quantityOfVoters = "5000";
	private String address = "Žirmūnų";

	CountyRepresentatives representatives;

	@Test(priority = 0)
	public void prepareTheDistrictAndCounty() {
		districts = new Districts(driver);
		districts.createNewDistrictAndCounty(districtName, countyName, quantityOfVoters, address);
	}

	@Test(priority = 1, dataProvider = "CountyRepresentativeValidDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfRepresentativeCanBeCreatedAndDeleted(String representativeName, String representativeSurname,
			String representativeEmail) {

		representatives = new CountyRepresentatives(driver);

		representativeName = representatives.normalizeLettersToMatchArchitecture(representativeName);
		representativeSurname = representatives.normalizeLettersToMatchArchitecture(representativeSurname);

		representatives.createNewCountyRepresentative(representativeName, representativeSurname, representativeEmail,
				districtName, countyName);

		representatives.findTheRepresentativeByNameAndSurename(representativeName, representativeSurname);

		Assert.assertEquals(
				representatives.getSpecificRepresentativeNameAndSurname(representativeName, representativeSurname)
						.getText().trim(),
				representativeName + " " + representativeSurname, "Representative name and surname don't match");

		System.out.println("Representative name and surename match");

		Assert.assertTrue((countyName + " (" + districtName + ")").contains(representatives
				.getSpecificRepresentativeDistrictAndCountyElement(representativeName, representativeSurname).getText()
				.trim()), "Representative District and County don't match");

		System.out.println("Representative District and County do match");

		Assert.assertTrue(representativeEmail.contains(representatives
				.getSpecificRepresentativeEmailElement(representativeName, representativeSurname).getText().trim()),
				"Rpresentative Email does not match");

		System.out.println("Representative Email do match");

		representatives.deleteSpecificRepresentative(representativeName, representativeSurname);
		System.out.println("The Representative was succesfully deleted");

	}

	@Test(priority = 2)
	public void testIfRepresentativeCanNotBeCreatedWithNullParameters() {

		representatives = new CountyRepresentatives(driver);
		representatives.getCreateRepresentativeButton().click();

		Assert.assertFalse(representatives.getCreateRepresentativeButton().isEnabled(), "The Button was enabled");
		System.out.println("Representative with null parameters can not be created");

	}

	@Test(priority = 3)
	public void removeTheDistrict() {
		districts = new Districts(driver);
		districts.deleteSpecificDistrict(districtName);
	}

}
