package appUtils;


//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.apache.commons.io.FileUtils;
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Date;

//public class ScreenshotUtils {
//    
//    public static String captureScreenshot(WebDriver driver, String testName) {
//        try {
//            // Create screenshot directory if it doesn't exist
//            String screenshotDirPath = ConfigReader.getProperty("screenshot.path");
//            File screenshotDir = new File(screenshotDirPath);
//            if (!screenshotDir.exists()) {
//                screenshotDir.mkdirs();
//                System.out.println("Created screenshot directory: " + screenshotDir.getAbsolutePath());
//            }
//            
//            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//            String screenshotName = testName + "_" + timeStamp + ".png";
//            String screenshotPath = screenshotDirPath + screenshotName;
//            
//            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//            File destination = new File(screenshotPath);
//            FileUtils.copyFile(source, destination);
//            
//            System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
//            return screenshotPath;
//        } catch (IOException e) {
//            System.out.println("Failed to capture screenshot: " + e.getMessage());
//            return "";
//        }
//    }
//    
//    // Method to capture screenshot for any test
//    public static String captureScreenshot(WebDriver driver) {
//        return captureScreenshot(driver, "Test_" + System.currentTimeMillis());
//    }
//}


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {
    
    public static String captureScreenshot(WebDriver driver, String testName) {
        try {
            // Create screenshot directory if it doesn't exist
            String screenshotDirPath = ConfigReader.getScreenshot();
            File screenshotDir = new File(screenshotDirPath);
            if (!screenshotDir.exists()) {
                screenshotDir.mkdirs();
                System.out.println("Created screenshot directory: " + screenshotDir.getAbsolutePath());
            }
            
            String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String screenshotName = testName + "_" + timeStamp + ".png";
            String screenshotPath = screenshotDirPath + screenshotName;
            
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(screenshotPath);
            FileUtils.copyFile(source, destination);
            
            System.out.println("Screenshot saved to: " + destination.getAbsolutePath());
            return screenshotPath;
        } catch (IOException e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }
    
    // Method to capture screenshot for any test
    public static String captureScreenshot(WebDriver driver) {
        return captureScreenshot(driver, "Test_" + System.currentTimeMillis());
    }
}