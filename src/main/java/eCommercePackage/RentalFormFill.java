package eCommercePackage;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RentalFormFill{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mycontactform.com/samples/rental.php");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        
        driver.findElement(By.cssSelector("[name='q[21]']")).sendKeys("Ms.");
        driver.findElement(By.cssSelector("[name='q[1]']")).sendKeys("Sidra");
        driver.findElement(By.cssSelector("[name='q[2]']")).sendKeys("Fatima");
        driver.findElement(By.id("email")).sendKeys("Sidra@example.com");
        driver.findElement(By.name("q[3]")).sendKeys("912345678");
        driver.findElement(By.xpath("//input[@name='q[4]' and @value='Phone']")).click();
        driver.findElement(By.xpath("//input[@name='q[5]' and @value='Morning']")).click();
        
        Select moveDateSelect = new Select(driver.findElement(By.name("q[6]")));
        moveDateSelect.selectByVisibleText("Other");
        
        Select primaryPropertyType = new Select(driver.findElement(By.name("q[19]")));
        primaryPropertyType.selectByVisibleText("Single Family Dwelling");
        Select alternatePropertyType = new Select(driver.findElement(By.name("q[20]")));
        alternatePropertyType.selectByVisibleText("Hi-rise");
        
        new Select(driver.findElement(By.name("q[7]"))).selectByVisibleText("$600");
        new Select(driver.findElement(By.name("q[8]"))).selectByVisibleText("$1000");
        new Select(driver.findElement(By.name("q[9]"))).selectByVisibleText("600");
        new Select(driver.findElement(By.name("q[10]"))).selectByVisibleText("1500");
        driver.findElement(By.name("q[11]")).sendKeys("uttar pradesh");
        new Select(driver.findElement(By.name("q[12]"))).selectByVisibleText("1");
        new Select(driver.findElement(By.name("q[16]"))).selectByVisibleText("3");
        
        new Select(driver.findElement(By.name("q[13"))).selectByVisibleText("1");
        new Select(driver.findElement(By.name("q[17]"))).selectByVisibleText("4");
        new Select(driver.findElement(By.name("q[14]"))).selectByVisibleText("Yes-Cats Only");
        
        driver.findElement(By.xpath("//input[@name='q[15]' and @value='Yes - Cats Only']")).click();
        driver.findElement(By.name("q[21]")).sendKeys("Looking for a nice place.");
        
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("[name='submit']")).click();
        Thread.sleep(3000);
        
        System.out.println("Form has been successfully submitted with rental details.");
        driver.quit();
    }
}



