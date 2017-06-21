package tests.administration.districts;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import data.providers.TestDataProviders;
import tests.BaseTestPattern;
import website.voting.system.administrator.Districts;

/**
 * 
 * @author Mindaug4s
 * @class A class tests if a District can be created by the admin. Additionally,
 *        field validation is checked - creating a district with latin symbols,
 *        which are not allowed, and creating a district with an empty name.
 */

public class TestDistrictCreation extends BaseTestPattern {

	private Districts districts;

	/**
	 * 
	 * @param districtName
	 *            - parameter received through the DataProvider, which provides
	 *            the list of VALID District names(from file
	 *            "ListOfValidDistricts.csv"), which later are used by methods
	 *            to create respectively named class, and after the test is
	 *            complete, delete it in order to avoid unnecessary test data
	 *            leftovers on the webpage;
	 */

	@Test(priority = 0, dataProvider = "DistrictsValidDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfSingleDistrictCanBeCreatedWithValidData(String districtName) {

		districts = new Districts(driver);

		districts.createNewDistrict(districtName);

		Assert.assertTrue(districts.getExistingDistrictByName(districtName).isDisplayed(),
				"The District " + districtName + " was not created");

		System.out.println("The District \"" + districtName + "\" was successfully created");

		districts.deleteSpecificDistrict(districtName);

	}

	/**
	 * 
	 * @param districtName
	 *            - parameter received through the DataProvider, which provides
	 *            the list of INVALID District names(from file
	 *            "ListOfValidDistricts.csv").
	 */
	@Test(priority = 1, dataProvider = "DistrictsInvalidDataProvider", dataProviderClass = TestDataProviders.class)
	public void testIfSingleDistrictCanBeCreatedWithInvalidData(String districtName) {

		boolean isDistrictVisible = true;

		districts = new Districts(driver);

		districts.createNewDistrict(districtName);

		Assert.assertTrue(districts.getWarningMessegeElement().isDisplayed(), "The warning message has not appeared");
		System.out.println("The warning message is shown, stating: \""
				+ districts.getWarningMessegeElement().getText().trim() + "\"");

		try {
			districts.getExistingDistrictByName(districtName);
		} catch (NoSuchElementException e) {
			isDistrictVisible = false;
		}

		Assert.assertFalse(isDistrictVisible, "District, named \"" + districtName + "\" was created eventually");

		System.out.println("The District \"" + districtName + "\" was not created");

	}

	/**
	 * @method tests if a District with an empty name can be created.
	 */
	@Test(priority = 2)
	public void testIfSingleDistrictCanBeCreatedWithNullData() {

		districts = new Districts(driver);

		districts.getCreateNewDistrictButton().click();

		Assert.assertTrue(districts.getWarningMessegeElement().isDisplayed(), "The District  was not created");
		System.out.println(
				"The warning message is shown, stating: \"" + districts.getWarningMessegeElement().getText().trim()
						+ "\" \nThe district with an empty name was not created");

	}

}
