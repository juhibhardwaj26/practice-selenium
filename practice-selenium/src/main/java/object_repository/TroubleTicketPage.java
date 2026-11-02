package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage {
	public TroubleTicketPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (css = "[title='Create Ticket...']")
	private WebElement createTicketIcon;
	public void clickCreateTicketIcon() {
		createTicketIcon.click();
	}
}
