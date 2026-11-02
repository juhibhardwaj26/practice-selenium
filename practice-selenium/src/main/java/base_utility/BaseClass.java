package base_utility;

import java.io.IOException;
import java.time.Duration;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import generic_utility.FileUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class BaseClass {

	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeClass
	public void setUp() throws IOException, ParseException {
		String url = FileUtility.getDataFromJsonFile("url");
		String bro = FileUtility.getDataFromJsonFile("bro");
		if (bro.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (bro.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (bro.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(url);
	}
	@BeforeMethod
	public void login() throws IOException, ParseException {
		String un = FileUtility.getDataFromJsonFile("un");
		String pwd = FileUtility.getDataFromJsonFile("pwd");
		LoginPage lp = new LoginPage(driver);
		lp.getUserName().sendKeys(un);
		lp.getPassword().sendKeys(pwd);
		lp.getLoginBtn().click();
	}
	@AfterMethod
	public void logout() {
		HomePage hp = new HomePage(driver);
		WebElement profile= hp.getProfileIcon();
		Actions act= new Actions(driver);
		act.moveToElement(profile).build().perform();
		hp.signOut();
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
	
	
}
