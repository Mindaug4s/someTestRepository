package tests.administration.countyResults;

import org.testng.Assert;
import org.testng.annotations.Test;

import tests.BaseTestPattern;
import website.voting.system.administrator.CountyResults;

public class TestCountyResultsPageIsAvailable extends BaseTestPattern {
	
	CountyResults countyResults;
	
	@Test
	public void testIfMainElementsAreAvailable(){
		
		countyResults = new CountyResults(driver);
		
		Assert.assertTrue(countyResults.getDistrictResultsHeaderElement().isDisplayed(), "Main element is missing");
		System.out.println("Main element is in place");
	}
	
	

}
