package MCompleteSeleniumFramework.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MExtentReports {
	
	
	public static ExtentReports configExtentReports() {
		
		String path = System.getProperty("user.dir")+"\\Mreports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("MTestResults");
		reporter.config().setReportName("MWebAutomation Results");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "MMIR");
		
		return extent;
		
		
	}

}
