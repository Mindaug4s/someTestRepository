package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTestPattern {

	double testStartTime;
	double testEndTime;
	protected WebDriver driver;

	@BeforeMethod
	public void prepareForTest() {

		testStartTime = System.currentTimeMillis();

		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void closeBrowser() {

		testEndTime = System.currentTimeMillis();
		System.out.println("Time tests took: " + (testEndTime - testStartTime));

		driver.close();
	}

}
