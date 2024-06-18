package TestNGDemo;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClassDemo implements ITestListener
{
	public ExtentReports extent;  //populate common info in the report
	public ExtentSparkReporter sparkReporter;  //UI of the report 
	public ExtentTest test; //create TC enteries in the reports
	
	public void onTestStart(ITestResult result) {
		System.out.println("Test execution started.....");
		
		
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());		
		sparkReporter = new ExtentSparkReporter("D:/eclipse/eclipse/eclipse-workspace/selenium/BankingAutomation_v1/Reports/"+dateName+".html");
		
		sparkReporter.config().setDocumentTitle("Automation Test Report");  //set title of the report
		sparkReporter.config().setReportName("Learning Extent Reports");
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA Testing");
		extent.setSystemInfo("Tester Name", "Dikshita");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Broswer Name", "Chrome");
		
		
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test execution success.....");
		
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test Case Passed :- "+result.getName());
	}
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test execution failed.....");
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test Case Failed :- "+result.getName());
	}
	
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test execution skipped.....");
		
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test Case Skipped :- "+result.getName());
	}
	
	public void onFinish(ITestContext context) {
		System.out.println("Test execution finished.....");
		
		extent.flush(); //mandatory for creating report
	}

}
