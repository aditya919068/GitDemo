package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting {
		public static ExtentReports extent;
		
		public static ExtentReports config() {
		String path= System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("Practice");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Automation Result");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Aditya Bhatt");
		extent.setSystemInfo("OS", "Windows");
		return extent;
	}
}
