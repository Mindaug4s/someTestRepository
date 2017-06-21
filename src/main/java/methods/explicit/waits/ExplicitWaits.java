package methods.explicit.waits;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;
import com.thoughtworks.selenium.webdriven.commands.Open;

public class ExplicitWaits {

	WebDriver driver;

	public ExplicitWaits(WebDriver driver) {
		this.driver = driver;

	}

	public void fluentWait(final WebElement nameOfTheElement) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		if (nameOfTheElement.isEnabled()) {
			System.out.println("Element is present");

			WebElement alertElement = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {

					if (nameOfTheElement.isDisplayed()) {
						return nameOfTheElement;
					} else {
						return null;

					}

				}
			});

		}
	}

	public static void fluentWait(final WebElement nameOfTheElement, WebDriver driver) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(10, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		if (nameOfTheElement.isEnabled()) {
			// System.out.println("Element is present");

			WebElement alertElement = wait.until(new Function<WebDriver, WebElement>() {
				public WebElement apply(WebDriver driver) {

					if (nameOfTheElement.isDisplayed()) {
						return nameOfTheElement;
					} else {
						return null;

					}

				}
			});

		}
	}

	public void waitForJavascript() {
		new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
			}
		});
	}

	public static void waitForJavascript(WebDriver driver) {
		new WebDriverWait(driver, 5).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		});
	}

	public static boolean waitForJStoLoad(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 30);

		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		// wait for Javascript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};

		return wait.until(jQueryLoad) && wait.until(jsLoad);
	}

	public static void waitUntilAddressFieldIsLoaded(WebDriver driver, WebElement element) {

		new WebDriverWait(driver, 2).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return element.getAttribute("class").contains("geo");
			}
		});

	}

	public static void waitUntilAddressFieldIsLoaded(WebDriver driver, WebElement element, String expectedValue) {

		new WebDriverWait(driver, 2).until(new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				return element.getText().trim().equals(expectedValue);
			}
		});

	}

	public static void waitUntilAddressGeoFieldIsLoaded(WebDriver driver, WebElement element) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(2, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				if (element.getAttribute("class").equals("geo")) {
					return true;
				}
				return false;
			}
		};

		wait.until(function);
	}

	public static void waitUntilAttributeEqualsRequiredValue(WebDriver driver, WebElement element, String attributeName,
			String expectedValue) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(2, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> function = new Function<WebDriver, Boolean>() {
			public Boolean apply(WebDriver driver) {
				if (element.getAttribute(attributeName).equals(expectedValue)) {
					return true;
				}
				return false;
			}
		};

		wait.until(function);
	}
}
