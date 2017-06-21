package tests.administration;

import org.testng.Assert;
import org.testng.annotations.Test;

import tests.BaseTestPattern;
import website.voting.system.administrator.AdministratorPage;

public class TestIfAdministratorPageHasMainComponents extends BaseTestPattern {

	AdministratorPage admin;

	@Test(priority = 0)
	public void testIfDistrictsMenuElementIsAvailable() {

		admin = new AdministratorPage(driver);

		Assert.assertTrue(admin.getDistrictsMenuElement().isDisplayed(), "Districts menu element is not available");

		System.out.println("Districts menu element is available");

	}

	@Test(priority = 1)
	public void testIfDistrictCandidatesMenuElementIsAvailable() {

		admin = new AdministratorPage(driver);

		Assert.assertTrue(admin.getDistrictCandidatesMenuElement().isDisplayed(),
				"District Candidates menu element is not available");

		System.out.println("District Candidates menu element is available");

	}

	@Test(priority = 2)
	public void testIfCountyRepresentativesMenuElementIsAvailable() {

		admin = new AdministratorPage(driver);

		Assert.assertTrue(admin.getCountyRepresentativesMenuElement().isDisplayed(),
				"County Representatives menu element is not available");

		System.out.println("County Representatives menu element is available");

	}

	@Test(priority = 3)
	public void testIfPartiesMenuElementIsAvailable() {

		admin = new AdministratorPage(driver);

		Assert.assertTrue(admin.getPartiesMenuElement().isDisplayed(), "Parties menu element is not available");

		System.out.println("Parties menu element is available");

	}

	@Test(priority = 4)
	public void testIfCountyResultsMenuElementIsAvailable() {

		admin = new AdministratorPage(driver);

		Assert.assertTrue(admin.getCountyResultsMenuElement().isDisplayed(), "County Results menu element is not available");

		System.out.println("County Results menu element is available");

	}

}
