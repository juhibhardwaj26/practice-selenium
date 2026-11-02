package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (name = "user_name")
	private WebElement userName;
	public WebElement getUserName() {
		return userName;
	}
	@FindBy (name = "user_password")
	private WebElement password;
	public WebElement getPassword() {
		return password;
	}
	@FindBy (id = "submitButton")
	private WebElement loginBtn;
	public WebElement getLoginBtn() {
		return loginBtn;
	}
}
