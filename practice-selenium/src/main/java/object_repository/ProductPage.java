package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (css = "[title='Create Product...']")
	private WebElement createProductIcon;
	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}
	
}
