package appUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Popuphandler {
	@SuppressWarnings("unused")
    private WebDriver driver;
    private WebDriverWait wait;

    private By continueBtn = By.xpath("/html/body/div/div[1]/div[3]/div/div/form/div/div/span/span/button");

    public Popuphandler(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void handleContinueShopping() {
        try {
            WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(continueBtn));
            if (btn.isDisplayed()) {
                btn.click();
                System.out.println("✅ Clicked on 'Continue shopping' button.");
            }
        } catch (Exception e) {
            System.out.println("⚠️ No 'Continue shopping' popup, proceeding normally.");
        }
    }
}
