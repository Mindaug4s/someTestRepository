package data.providers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

import tests.BaseTestPattern;
import website.voting.system.HomePage;

public class TestDataProviders extends BaseTestPattern{

	@DataProvider(name = "DistrictsAndCountiesValidDataProvider")

	public static Object[][] getValidDistrictAndCountiesData() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfValidDistrictsAndCounties);

	}
	
	@DataProvider(name = "DistrictsAndCountiesValidDataProviderForEditing")

	public static Object[][] getValidDistrictAndCountiesDataForEditing() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfValidDistrictsAndCountiesForEditing);

	}
	
	@DataProvider(name = "DistrictsAndCountiesInvalidDataProvider")

	public static Object[][] getInvalidDistrictAndCountiesData() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfInvalidDistrictsAndCounties);

	}
	
	
	
	@DataProvider(name = "DistrictsValidDataProvider")

	public static Object[][] getValidDistrictsData() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfValidDistricts);

	}
	
	@DataProvider(name = "DistrictsInvalidDataProvider")

	public static Object[][] getInvalidDistrictsData() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfInvalidDistricts);

	}
	
	@DataProvider(name = "DistrictCandidatedDataProvider")

	public static Object[][] getDistrictCandidateData() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfDistrictCandidates);

	}
	
	@DataProvider(name = "CountyRepresentativeValidDataProvider")

	public static Object[][] getValidCountyRepresentativeData() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfValidCountyRepresentatives);

	}
	

	@DataProvider(name = "PartyCandidateDataProvider")

	public static Object[][] getPartyCandidateData() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfPartyCandidates);

	}
	
	
	@DataProvider(name = "ValidVotesDataProvider")

	public static Object[][] getVotesData() {

		return TestDataFileReader.fillArrayWithDataFromFile(LinksToDataFiles.listOfValidVotes);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@DataProvider(name = "TestDataProviderHomePage")

	public static Object[][] getDataFromWebPage() {

	WebDriver driver = new FirefoxDriver();
	HomePage homePage = new HomePage(driver);
	

		return new Object[][] { { homePage.getWebPageTitleElement() },
			{ homePage.getNavigateToAuthorizedAreaButton() },
			{ homePage.getCandidateSearchMenuElement() },
			{ homePage.getSingleMandateResultsMenuElement() },
			{ homePage.getMultiMandateResultsMenuElement() },
			{ homePage.getCombinedResultsMenuElement() },
			
		};
	}

}
