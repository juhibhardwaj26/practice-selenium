package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (linkText = "Documents")
	private WebElement documentLink;
	public WebElement getDocumentLink() {
		return documentLink;
	}
	@FindBy (linkText = "Products")
	private WebElement productLink;
	public WebElement getProductLink() {
		return productLink;
	}
	@FindBy (linkText = "Trouble Tickets")
	private WebElement troubleTicketLink;
	public WebElement getTroubleTicketLink() {
		return troubleTicketLink;
	}
	@FindBy (css = "[src='themes/softed/images/user.PNG']")
	private WebElement profileIcon;
	public WebElement getProfileIcon() {
		return profileIcon;
	}
	@FindBy (linkText = "Sign Out")
	private WebElement signOutOption;
	public void signOut() {
		signOutOption.click();
	}
}
