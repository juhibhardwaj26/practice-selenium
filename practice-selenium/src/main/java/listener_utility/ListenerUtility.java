package listener_utility;  
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import base_utility.BaseClass;
import generic_utility.JavaUtility;

public class ListenerUtility implements ITestListener {
	public ExtentReports report;
	
	@Override
	public void onStart(ITestContext context) {
		String time= JavaUtility.getCurrentTime();
		ExtentSparkReporter spark= new ExtentSparkReporter("./reports/"+time+".html");
		spark.config().setDocumentTitle("V-tiger report");
		spark.config().setReportName(context.getName());
		spark.config().setTheme(Theme.DARK);
		
		report= new ExtentReports();
		
		report.attachReporter(spark);
		
		report.setSystemInfo("bro", "Chrome");
		report.setSystemInfo("tester","Juhi");
		
		}
	@Override
	public void onFinish(ITestContext context) {
		report.flush();
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName= result.getName();
		ExtentTest test= report.createTest(methodName);
		test.log(Status.PASS, methodName+" is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String methodName= result.getName();
		ExtentTest test = report.createTest(methodName);
		test.log(Status.FAIL, methodName+" is failed");
		TakesScreenshot tks = (TakesScreenshot) BaseClass.sdriver;
		String ss= tks.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(ss);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getName();
		ExtentTest test = report.createTest(methodName);
		test.log(Status.SKIP, methodName+" is skipped");
	}
}
