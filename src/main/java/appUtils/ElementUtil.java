//package appUtils;
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import java.time.Duration;
//
//public class ElementUtil {
//	@SuppressWarnings("unused")
//    private WebDriver driver;
//    private WebDriverWait wait;
//     public ElementUtil(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    }public void clickElement(WebElement element, String elementName) {
//        try {
//            wait.until(ExpectedConditions.elementToBeClickable(element));
//            element.click();
//            System.out.println("Clicked on: " + elementName);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to click on " + elementName + ": " + e.getMessage());
//        }
//    }public void typeText(WebElement element, String text, String elementName) {
//        try {
//            wait.until(ExpectedConditions.visibilityOf(element));
//            element.clear();
//            element.sendKeys(text);
//            System.out.println("Typed '" + text + "' in: " + elementName);
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to type in " + elementName + ": " + e.getMessage());
//        }
//    } public String getText(WebElement element, String elementName) {
//        try {
//            wait.until(ExpectedConditions.visibilityOf(element));
//            return element.getText();
//        } catch (Exception e) {
//            throw new RuntimeException("Failed to get text from " + elementName + ": " + e.getMessage());
//        }
//    }public boolean isElementDisplayed(WebElement element, String elementName) {
//        try {
//            wait.until(ExpectedConditions.visibilityOf(element));
//            return element.isDisplayed();
//        } catch (Exception e) {
//            return false;
//        }
//    }
//}
package appUtils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ElementUtil {
    private WebDriver driver;
    private WebDriverWait wait;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickElement(By locator, String elementName) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            System.out.println("Clicked on: " + elementName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to click on " + elementName + ": " + e.getMessage());
        }
    }

    public void typeText(By locator, String text, String elementName) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
            element.sendKeys(text);
            System.out.println("Typed '" + text + "' in: " + elementName);
        } catch (Exception e) {
            throw new RuntimeException("Failed to type in " + elementName + ": " + e.getMessage());
        }
    }

    public String getText(By locator, String elementName) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        } catch (Exception e) {
            throw new RuntimeException("Failed to get text from " + elementName + ": " + e.getMessage());
        }
    }

    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
