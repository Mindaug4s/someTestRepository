package tests.administration.countyRepresentatives;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class testas {

	WebDriver driver = new FirefoxDriver();
	Select select;
	List<WebElement> someList = new ArrayList<WebElement>();

	@Test
	public void testSomethign() {

		driver.get("http://88.119.151.54/opencartone/index.php?route=account/register");

		WebElement country = driver.findElement(By.id("input-country"));
		WebElement zone = driver.findElement(By.id("input-zone"));

		select = createASelect(country);
		someList.addAll(select.getOptions());

		select = createASelect(zone);
		someList.addAll(select.getOptions());

		someList.stream().filter(element -> element.getText().contains("Lithuania"))
				.forEach(element -> System.out.println(element.getText()));

		
		
		// someList.forEach(element->System.out.println(element.getText()));

//		for (WebElement element : someList) {
//			System.out.println(element.getText());
//
//		}

	}

	public Select createASelect(WebElement element) {
		return new Select(element);
	}
}
