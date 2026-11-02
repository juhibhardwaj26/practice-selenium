package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketFormPage {
	public TroubleTicketFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (name = "ticket_title")
	private WebElement title;
	public WebElement getTitle() {
		return title;
	}
	@FindBy (name = "ticketstatus")
	private WebElement ticketStatus;
	public WebElement getTicketStatus() {
		return ticketStatus;
	}
	@FindBy (css = "[title='Save [Alt+S]']")
	private WebElement saveBtn;
	public void clickSaveBtn() {
		saveBtn.click();
	}
}
