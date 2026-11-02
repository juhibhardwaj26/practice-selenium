package object_repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductFormPage {
	public ProductFormPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy (name = "productname")
	private WebElement productName;
	public WebElement getProductName() {
		return productName;
	}
	@FindBy (name="sales_start_date")
	private WebElement salesStartDate;
	public WebElement getSalesStartDate() {
		return salesStartDate;
	}
	@FindBy (name="productcategory")
	private WebElement productCategory;
	public WebElement getProductCategory() {
		return productCategory;
	}
	@FindBy (css = "[title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public void saveProduct() {
		saveBtn.click();
	}
}
