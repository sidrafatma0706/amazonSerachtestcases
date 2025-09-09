package appUtils;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
           // String reportPath = System.getProperty("user.dir") + "/reports/AmazonSearchReport.html";
        	String reportPath = ConfigReader.getExtentReportFile();
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Amazon Search Functional Tests");
            reporter.config().setReportName("Amazon Search Automation Report");
            reporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(reporter);
            extent.setSystemInfo("Tester", "Sid");
            extent.setSystemInfo("Browser", "Chrome");
        }
        return extent;
    }
}
