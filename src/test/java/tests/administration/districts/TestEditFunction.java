package tests.administration.districts;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import tests.BaseTestPattern;
import website.voting.system.administrator.Districts;

public class TestEditFunction extends BaseTestPattern {

	Districts districts;

	@Test(priority = 0, dataProvider = "DistrictsAndCountiesValidDataProviderForEditing", dataProviderClass = TestDataProviders.class)
	public void testIfSingleDistrictCanBeCreatedWithValidData(String districtName, String countyName,
			String quantityOfVoters, String address, String newDistrictName, String newCountyName, String newVoterCount,
			String newAddress) {

		districts = new Districts(driver);

		districts.createNewDistrictAndCounty(districtName, countyName, quantityOfVoters, address);

		districts.editSpecificDistrict(districtName, newDistrictName);

		/**
		 * Asserting if District name has been Changed.
		 */
		Assert.assertEquals(districts.getExistingDistrictByName(newDistrictName).getText().trim(), newDistrictName,
				"The District was not renamed properly");

		System.out.println("District name has been changed successfully");

		/**
		 * Editing County info, and then refreshing the browser.
		 */
		districts.editSpecificCounty(newDistrictName, countyName, newCountyName, newVoterCount, newAddress);

		driver.navigate().refresh();
		districts.getExistingDistrictByName(newDistrictName).click();

		/**
		 * Asserting that County info was changed.
		 */
		try {
			Assert.assertEquals(districts.getSpecificCountyByName(newDistrictName, newCountyName).getText().trim(),
					newCountyName, "County name has not ben changed");

			System.out.println("County name has been changed successfully");

			Assert.assertEquals(districts.getSpecificCountyVoteCount(newDistrictName, newCountyName).getText().trim(),
					newVoterCount, "Quantity of voters has not ben changed");

			System.out.println("County quantity of voters has been changed successfully");

			Assert.assertEquals(districts.getSpecificCountiesAddress(newDistrictName, newCountyName).getText().trim(),
					newAddress, "Address has not ben changed");

			System.out.println("County address has been changed successfully");

		} catch (NoSuchElementException e) {
			throw new NoSuchElementException("Test failed");
		} finally {
			districts.deleteSpecificDistrict(newDistrictName);
		}
	}

}
