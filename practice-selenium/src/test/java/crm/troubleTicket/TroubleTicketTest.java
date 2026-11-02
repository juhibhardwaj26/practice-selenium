package crm.troubleTicket;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import object_repository.HomePage;
import object_repository.TroubleTicketFormPage;
import object_repository.TroubleTicketInfoPage;
import object_repository.TroubleTicketPage;
@Listeners (listener_utility.ListenerUtility.class)
public class TroubleTicketTest extends BaseClass{
	@Test
	public void createTroubleTicket() throws IOException, ParseException, InterruptedException {
	
		
		HomePage hp = new HomePage(driver);
		hp.getTroubleTicketLink().click();
		
		String ticketTitle=FileUtility.getDataFromExcelFile("ticket test data", 2, 0)+JavaUtility.createRandom();
		String status=FileUtility.getDataFromExcelFile("ticket test data", 3, 1);
		
		TroubleTicketPage ttp= new TroubleTicketPage(driver);
		ttp.clickCreateTicketIcon();
		
		TroubleTicketFormPage ttfp= new TroubleTicketFormPage(driver);
		ttfp.getTitle().sendKeys(ticketTitle);
		WebElement stat = ttfp.getTicketStatus();
		Select sel = new Select(stat);
		sel.selectByValue(status);
		ttfp.clickSaveBtn();
		
		TroubleTicketInfoPage ttip= new TroubleTicketInfoPage(driver);
		String actualTicketTitle=ttip.getActualTicketTitle().getText();
		Assert.assertEquals(ticketTitle, actualTicketTitle+123);
		
		
	}
}
