package baseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import appUtils.Popuphandler;
public class AppBaseClass {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeMethod
    public void setup() {
    	
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
        
        Popuphandler popup = new Popuphandler(driver, wait);
        popup.handleContinueShopping(); }
    @AfterMethod
    public void tearDown() {
      if (driver != null) {
            driver.quit();
        }
        
    }
    public WebDriver getDriver() {
        return driver;
    }
}






    
  