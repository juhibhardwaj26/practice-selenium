package crm.product;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.ProductFormPage;
import object_repository.ProductInfoPage;
import object_repository.ProductPage;
@Listeners (listener_utility.ListenerUtility.class)
public class ProductTest extends BaseClass{
	@Test
	public void createProductTest() throws IOException, ParseException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getProductLink().click();
		
		ProductPage pp= new ProductPage(driver);
		pp.getCreateProductIcon().click();
		
		String productName=FileUtility.getDataFromExcelFile("product test data", 4, 0);
		String saleStartDate=FileUtility.getDataFromExcelFile("product test data", 4, 1);
		String productCategory=FileUtility.getDataFromExcelFile("product test data", 3, 2);
		
		ProductFormPage pfp = new ProductFormPage(driver);
		pfp.getProductName().sendKeys(productName);
		pfp.getSalesStartDate().sendKeys(saleStartDate);
		
		WebElement productCat= pfp.getProductCategory();
		Select sel= new Select(productCat);
		sel.selectByValue(productCategory);
		pfp.saveProduct();
		ProductInfoPage pip = new ProductInfoPage(driver);
		String actualProductName= pip.getActualProductName().getText();
		String actualProductCategory = pip.getActualProductCategory().getText();
		String actualSalesStartDate = pip.getActualSalesStartDate().getText();
		
		Assert.assertEquals(productName, actualProductName);
		Assert.assertEquals(productCategory, actualProductCategory);
		Assert.assertEquals(saleStartDate, actualSalesStartDate);
		
	}
}
