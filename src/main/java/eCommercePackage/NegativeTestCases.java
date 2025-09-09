package eCommercePackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class NegativeTestCases {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        try {
            driver.get("https://www.mycontactform.com/samples/rental.php");
            driver.manage().window().maximize();

            driver.findElement(By.name("submit")).click();
            Thread.sleep(2000);

            WebElement error = driver.findElement(By.xpath("//body"));
            System.out.println("Negative Test Case Output:");
            System.out.println(error.getText());

            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }
 }
