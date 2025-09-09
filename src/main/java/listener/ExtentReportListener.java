package listener;

//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import appUtils.ConfigReader;
//import appUtils.ScreenshotUtils;
//import baseClass.AppBaseClass;
//import appUtils.ExcelUtils;  

//public class ExtentReportListener implements ITestListener {
//    private ExtentReports extent;
//    private ExtentTest test;
//
//    @Override
//    public void onStart(ITestContext context) {
//        // Extent report setup
//        String reportPath = ConfigReader.getExtentReportFile();
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
//
//        htmlReporter.config().setDocumentTitle("Amazon Test Report");
//        htmlReporter.config().setReportName("Amazon Automation Test Results");
//        htmlReporter.config().setTheme(Theme.STANDARD);
//
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Browser", ConfigReader.getBrowser());
//        extent.setSystemInfo("URL", ConfigReader.getUrl());
//
//       
//        ExcelUtils.createExcelFile();
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getMethod().getMethodName(),
//                result.getMethod().getDescription());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.log(Status.PASS, "Test passed: " + result.getName());
//
//        // ✅ Write to Excel
//        ExcelUtils.writeResult(result.getName(), "PASS", "Test passed successfully");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.log(Status.FAIL, "Test failed: " + result.getName());
//        test.log(Status.FAIL, "Failure reason: " + result.getThrowable());
//
//        // Capture screenshot
//        String screenshotPath = ScreenshotUtils.captureScreenshot(
//                ((AppBaseClass) result.getInstance()).getDriver(), result.getName());
//        if (!screenshotPath.isEmpty()) {
//            test.addScreenCaptureFromPath(screenshotPath);
//        }
//
//        // ✅ Write to Excel
//        ExcelUtils.writeResult(result.getName(), "FAIL", result.getThrowable().getMessage());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        test.log(Status.SKIP, "Test skipped: " + result.getName());
//
//        // ✅ Write to Excel
//        ExcelUtils.writeResult(result.getName(), "SKIPPED", "Test skipped");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extent.flush();
//    }
//}


//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.configuration.Theme;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//
//import appUtils.ConfigReader;
//import appUtils.ScreenshotUtils;
//import baseClass.AppBaseClass;
//import appUtils.ExcelUtils;
//import appUtils.ExtentManager;
//
//public class ExtentReportListener implements ITestListener {
//    private ExtentReports extent;
//    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
//
//    @Override
//    public void onStart(ITestContext context) {
//        // Extent report setup
//        String reportPath = ConfigReader.getExtentReportFile();
//        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(reportPath);
//
//        htmlReporter.config().setDocumentTitle("Amazon Test Report");
//        htmlReporter.config().setReportName("Amazon Automation Test Results");
//        htmlReporter.config().setTheme(Theme.STANDARD);
//
//        extent = new ExtentReports();
//        extent.attachReporter(htmlReporter);
//
//        // System Info
//        extent.setSystemInfo("Environment", "QA");
//        extent.setSystemInfo("Browser", ConfigReader.getBrowser());
//        extent.setSystemInfo("URL", ConfigReader.getUrl());
//
//        // Create Excel file at start
//        ExcelUtils.createExcelFile();
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName(),
//                result.getMethod().getDescription());
//
//        // Add class & groups info
//        extentTest.assignCategory(result.getTestClass().getName());
//        if (result.getMethod().getGroups().length > 0) {
//            extentTest.assignCategory(result.getMethod().getGroups());
//        }
//
//        test.set(extentTest);
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.get().log(Status.PASS, "✅ Test Passed: " + result.getName());
//        ExcelUtils.writeResult(result.getName(), "PASS", "Test passed successfully");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.get().log(Status.FAIL, "❌ Test Failed: " + result.getName());
//        test.get().log(Status.FAIL, "Reason: " + result.getThrowable());
//
//        // Screenshot capture
//        String screenshotPath = ScreenshotUtils.captureScreenshot(
//                ((AppBaseClass) result.getInstance()).getDriver(), result.getName());
//        if (!screenshotPath.isEmpty()) {
//            try {
//                test.get().addScreenCaptureFromPath(screenshotPath);
//            } catch (Exception e) {
//                test.get().log(Status.WARNING, "Screenshot attach failed: " + e.getMessage());
//            }
//        }
//
//        ExcelUtils.writeResult(result.getName(), "FAIL", result.getThrowable().getMessage());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        test.get().log(Status.SKIP, "⚠️ Test Skipped: " + result.getName());
//        if (result.getThrowable() != null) {
//            test.get().log(Status.SKIP, "Reason: " + result.getThrowable());
//        }
//        ExcelUtils.writeResult(result.getName(), "SKIPPED", "Test skipped");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extent.flush();
//    }
//}


//
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import appUtils.ScreenshotUtils;
//import baseClass.AppBaseClass;
//import appUtils.ExcelUtils;
//import appUtils.ExtentManager;
//
//public class ExtentReportListener implements ITestListener {
//    private static ExtentReports extent = ExtentManager.getInstance();
//    private ExtentTest test;
//
//    @Override
//    public void onStart(ITestContext context) {
//        // Excel file create on suite start
//        ExcelUtils.createExcelFile();
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getMethod().getMethodName(),
//                result.getMethod().getDescription());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.log(Status.PASS, "Test passed: " + result.getName());
//        ExcelUtils.writeResult(result.getName(), "PASS", "Test passed successfully");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.log(Status.FAIL, "Test failed: " + result.getName());
//        test.log(Status.FAIL, "Failure reason: " + result.getThrowable());
//
//        // Screenshot capture
//        String screenshotPath = ScreenshotUtils.captureScreenshot(
//                ((AppBaseClass) result.getInstance()).getDriver(), result.getName());
//        if (!screenshotPath.isEmpty()) {
//            try {
//                test.addScreenCaptureFromPath(screenshotPath);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        ExcelUtils.writeResult(result.getName(), "FAIL", result.getThrowable().getMessage());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        test.log(Status.SKIP, "Test skipped: " + result.getName());
//        ExcelUtils.writeResult(result.getName(), "SKIPPED", "Test skipped");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extent.flush();  // ✅ close and write report
//    }
//}
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.MediaEntityBuilder;
//import org.testng.ITestContext;
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import appUtils.ScreenshotUtils;
//import baseClass.AppBaseClass;
//import appUtils.ExcelUtils;
//import appUtils.ExtentManager;
//
//public class ExtentReportListener implements ITestListener {
//    private static ExtentReports extent = ExtentManager.getInstance();
//    private ExtentTest test;
//
//    @Override
//    public void onStart(ITestContext context) {
//        // Excel file create on suite start
//        ExcelUtils.createExcelFile();
//    }
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        test = extent.createTest(result.getMethod().getMethodName(),
//                result.getMethod().getDescription());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        test.log(Status.PASS, "Test passed: " + result.getName());
//        ExcelUtils.writeResult(result.getName(), "PASS", "Test passed successfully");
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
//        test.log(Status.FAIL, "Test failed: " + result.getName());
//        test.log(Status.FAIL, "Failure reason: " + result.getThrowable());
//
//        // ✅ Screenshot capture and attach
//        String screenshotPath = ScreenshotUtils.captureScreenshot(
//                ((AppBaseClass) result.getInstance()).getDriver(), result.getName());
//        if (!screenshotPath.isEmpty()) {
//            try {
//                test.fail("Screenshot of failure",
//                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        ExcelUtils.writeResult(result.getName(), "FAIL", result.getThrowable().getMessage());
//    }
//
//    @Override
//    public void onTestSkipped(ITestResult result) {
//        test.log(Status.SKIP, "Test skipped: " + result.getName());
//        ExcelUtils.writeResult(result.getName(), "SKIPPED", "Test skipped");
//    }
//
//    @Override
//    public void onFinish(ITestContext context) {
//        extent.flush();  // ✅ close and write report
//    }
//}
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import appUtils.ScreenshotUtils;
import baseClass.AppBaseClass;
import appUtils.ExcelUtils;
import appUtils.ExtentManager;

public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.getInstance();
    private ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        // Excel file create on suite start
        ExcelUtils.createExcelFile();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName(),
                result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed: " + result.getName());

        // ✅ Screenshot capture for passed tests also
        String screenshotPath = ScreenshotUtils.captureScreenshot(
                ((AppBaseClass) result.getInstance()).getDriver(), result.getName());
        if (!screenshotPath.isEmpty()) {
            try {
                test.pass("Screenshot of success",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ExcelUtils.writeResult(result.getName(), "PASS", "Test passed successfully");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed: " + result.getName());
        test.log(Status.FAIL, "Failure reason: " + result.getThrowable());

        // ✅ Screenshot capture and attach for failed tests
        String screenshotPath = ScreenshotUtils.captureScreenshot(
                ((AppBaseClass) result.getInstance()).getDriver(), result.getName());
        if (!screenshotPath.isEmpty()) {
            try {
                test.fail("Screenshot of failure",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ExcelUtils.writeResult(result.getName(), "FAIL", result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.log(Status.SKIP, "Test skipped: " + result.getName());

        // (Optional) Screenshot for skipped tests
        String screenshotPath = ScreenshotUtils.captureScreenshot(
                ((AppBaseClass) result.getInstance()).getDriver(), result.getName());
        if (!screenshotPath.isEmpty()) {
            try {
                test.skip("Screenshot of skipped test",
                        MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        ExcelUtils.writeResult(result.getName(), "SKIPPED", "Test skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();  // ✅ close and write report
    }
}

