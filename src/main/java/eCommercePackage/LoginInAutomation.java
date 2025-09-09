package eCommercePackage;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.sql.*;
import java.time.Duration;
import java.util.Properties;

public class LoginInAutomation {

    public static void main(String[] args) throws Exception {
        // Load DB props
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/db.properties"));

        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        // Connect DB
        Connection conn = DriverManager.getConnection(url, user, password);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT username, password FROM users");

        // Setup Excel
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Login Results");
        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Username");
        header.createCell(1).setCellValue("Password");
        header.createCell(2).setCellValue("Result");

        // Setup Selenium
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        String loginUrl = "http://parabank.parasoft.com/parabank/index.htm";
        int rowNum = 1;

        while (rs.next()) {
            String uname = rs.getString("username");
            String pwd = rs.getString("password");

            driver.get(loginUrl);
            driver.findElement(By.name("username")).sendKeys(uname);
            driver.findElement(By.name("password")).sendKeys(pwd);
            driver.findElement(By.cssSelector("input.button")).click();

            String result;
            if (driver.getPageSource().contains("Accounts Overview")) {
                result = "PASS";
            } else {
                result = "FAIL";
            }

            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(uname);
            row.createCell(1).setCellValue(pwd);
            row.createCell(2).setCellValue(result);

            driver.manage().deleteAllCookies(); // reset session
        }

        // Save Excel
        FileOutputStream fos = new FileOutputStream("LoginResults.xlsx");
        workbook.write(fos);
        fos.close();
        workbook.close();

        // Cleanup
        driver.quit();
        rs.close();
        stmt.close();
        conn.close();

        System.out.println("✅ Automation complete. Results in LoginResults.xlsx");
    }
}
