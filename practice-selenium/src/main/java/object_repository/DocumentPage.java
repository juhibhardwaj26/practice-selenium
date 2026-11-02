package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentPage {
	public DocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (css = "[src='themes/softed/images/btnL3Add.gif']")
	private WebElement createDocumentIcon;
	public WebElement getCreateDocumentIcon() {
		return createDocumentIcon;
	}
}
