package crm.document;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import object_repository.DocumentFormPage;
import object_repository.DocumentInfoPage;
import object_repository.DocumentPage;
import object_repository.HomePage;
@Listeners (listener_utility.ListenerUtility.class)
public class DocumentTest extends BaseClass {
		@Test
		public void createDocumentTest() throws IOException, ParseException, InterruptedException{
		
		
		HomePage hp = new HomePage(driver);
		hp.getDocumentLink().click();
		
		DocumentPage dp= new DocumentPage(driver);
		dp.getCreateDocumentIcon().click();
		
		String title= FileUtility.getDataFromExcelFile("document test data", 5, 0);
		DocumentFormPage dfp= new DocumentFormPage(driver);
		dfp.getTitle().sendKeys(title);
		dfp.clickSaveBtn();
		
		DocumentInfoPage dip= new DocumentInfoPage(driver);
		String actualTitle= dip.getActualTitle().getText();
		Assert.assertEquals(title, actualTitle);
		
		
	}
}
