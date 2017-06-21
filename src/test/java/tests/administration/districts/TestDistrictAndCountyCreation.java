package tests.administration.districts;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import tests.BaseTestPattern;
import website.voting.system.administrator.Districts;

public class TestDistrictAndCountyCreation extends BaseTestPattern {

	private Districts districts;
	private boolean isDistrictVisible = true;

	@Test(priority = 0, dataProvider = "DistrictsAndCountiesValidDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfDistrictAndCountyCanBeCreatedWithValidData(String districtName, String countyName,
			String quantityOfVoters, String address) {

		districts = new Districts(driver);

		districts.createNewDistrictAndCounty(districtName, countyName, quantityOfVoters, address);

		Assert.assertTrue(districts.getSpecificCountyByName(districtName, countyName).isDisplayed(),
				"District and county was not created");

		System.out.println("District named \"" + districtName + "\" and County named \"" + countyName
				+ " has been successfully created.");

		districts.deleteSpecificDistrict(districtName);

	}

	@Test(priority = 1, dataProvider = "DistrictsAndCountiesInvalidDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfDistrictAndCountyCanBeCreatedWithInvalidData(String districtName, String countyName,
			String quantityOfVoters, String address) {

		districts = new Districts(driver);

		districts.createNewDistrictAndCounty(districtName, countyName, quantityOfVoters, address);

		Assert.assertTrue(districts.getWarningMessegeElement().isDisplayed(), "The warning message has not appeared");
		System.out.println("The warning message is shown, stating: \""
				+ districts.getWarningMessegeElement().getText().trim() + "\"");

		try {
			districts.getSpecificCountyByName(districtName, countyName);
		} catch (NoSuchElementException e) {
			isDistrictVisible = false;
		}

		Assert.assertFalse(isDistrictVisible, "District, named \"" + districtName + "\" was created eventually");

		System.out.println("The District \"" + districtName + "\" and County \"" + countyName + "\"was not created");

//		try {
//			districts.deleteSpecificDistrict(districtName);
//		} catch (NoSuchElementException e) {
//
//		}

	}

	@Test(priority = 2)
	public void testIfDistrictAndCountyCanBeCreatedWithdNullData() {

		districts = new Districts(driver);

		districts.getAddNewCountytButton().click();
		districts.getCreateNewDistrictButton().click();

		Assert.assertTrue(districts.getWarningMessegeElement().isDisplayed(), "The District  was not created");
		System.out.println(
				"The warning message is shown, stating: \"" + districts.getWarningMessegeElement().getText().trim()
						+ "\" \nThe district with an empty name was not created");

	}

}
