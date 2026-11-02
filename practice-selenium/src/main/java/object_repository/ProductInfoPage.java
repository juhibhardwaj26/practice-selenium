package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage {
	public ProductInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (id = "dtlview_Product Name")
	private WebElement actualProductName;
	public WebElement getActualProductName() {
		return actualProductName;
	}
	@FindBy (id = "dtlview_Sales Start Date")
	private WebElement actualSalesStartDate;
	public WebElement getActualSalesStartDate() {
		return actualProductName;
	}
	@FindBy (id = "dtlview_Product Category")
	private WebElement actualProductCategory;
	public WebElement getActualProductCategory() {
		return actualProductCategory;
	}
}
