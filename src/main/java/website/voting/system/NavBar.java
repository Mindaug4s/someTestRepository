package website.voting.system;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class NavBar {
	
	@FindBy (xpath = "//a[text() = 'PRISIJUNGTI']")
	private WebElement navigateToAuthorizedAreaButton;
	
	@FindBy (id = "loging-input")
	private WebElement loginUserNameField;
	
	@FindBy (id = "password-input")
	private WebElement loginPasswordField;
	
	@FindBy (id = "login-button")
	private WebElement loginConfirmButton;

	@FindBy(id = "homeButton")
	private WebElement homeButtonElement;

	@FindBy(id = "website-page-title")
	private WebElement webPageTitleElement;

	@FindBy(id = "user-menu")
	private WebElement userMenuButtonElement;

	@FindBy(id = "user-menu-option1")
	private WebElement userProfileEnviromentButtonElement;

	@FindBy(id = "user-menu-option2-logout")
	private WebElement logoutButtonElement;

//	@FindBy(xpath = "//button[@class = 'btn btn-danger' and contains(text(), 'Patvirtinti')]")
//	private WebElement confirmDeleteActionButtonElement;
	@FindBy(xpath = "//button[@class = 'btn btn-danger']")
	private WebElement confirmDeleteActionButtonElement;

//	@FindBy(xpath = "//button[@class = 'btn btn-default' and contains(text(), 'Atšaukti')]")
//	private WebElement cancelDeleteActionButtonElement;
	@FindBy(xpath = "//button[@class = 'btn btn-default']")
	private WebElement cancelDeleteActionButtonElement;

	@FindBy(xpath = "//div[contains(@class, 'alert alert-danger')]")
	private WebElement warningMessageElement;

	public void goToHomePage() {
		homeButtonElement.click();
	}
	
	public WebElement getNavigateToAuthorizedAreaButton() {
		return navigateToAuthorizedAreaButton;
	}
	
	public WebElement getLoginUserNameField() {
		return loginUserNameField;
	}
	
	public WebElement getLoginPasswordField() {
		return loginPasswordField;
	}
	
	public WebElement getLoginConfirmButton() {
		return loginConfirmButton;
	}

	public WebElement getHomePageButtonElement() {
		return homeButtonElement;
	}

	public WebElement getWebPageTitleElement() {
		return webPageTitleElement;
	}

	public WebElement getUserButtonElement() {
		return userMenuButtonElement;
	}

	public WebElement getUserProfileEnviromentButtonElement() {
		return userProfileEnviromentButtonElement;
	}

	public WebElement getLogoutButtonElement() {
		return logoutButtonElement;
	}

	public void logoutUser() {
		try {
			logoutButtonElement.click();

		} catch (Exception e) {
			userMenuButtonElement.click();
			logoutButtonElement.click();

		}

	}

	public void goToUserEnviromentSection() {
		try {
			userProfileEnviromentButtonElement.click();

		} catch (Exception e) {
			userMenuButtonElement.click();
			logoutButtonElement.click();

		}

	}

	public WebElement getConfirmDeleteActionButtonElement() {
		return confirmDeleteActionButtonElement;
	}

	public WebElement getCancelDeleteActionButtonElement() {
		return cancelDeleteActionButtonElement;
	}

	public WebElement getWarningMessegeElement() {
		return warningMessageElement;
	}
}
