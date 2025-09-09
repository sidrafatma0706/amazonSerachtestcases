//package appPages;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import java.util.List;
//
//public class AmazonHomePage {
//
//    private WebDriver driver;
//
//    // Locators
//    private By searchBox = By.id("twotabsearchtextbox");
//    private By searchButton = By.id("nav-search-submit-button");
//    private By suggestionList = By.cssSelector("div.autocomplete-results-container div.s-suggestion");
//
//    // Constructor
//    public AmazonHomePage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    // Actions
//    public void enterSearchText(String product) {
//        driver.findElement(searchBox).clear();
//        driver.findElement(searchBox).sendKeys(product);
//    }
//
//    public void clickSearchButton() {
//        driver.findElement(searchButton).click();
//    }
//
//    public String getPageTitle() {
//        return driver.getTitle();
//    }
//
//    // Suggestion handling
//    public List<WebElement> getSuggestions() {
//        return driver.findElements(suggestionList);
//    }
//
//    public void selectFirstSuggestion() {
//        List<WebElement> suggestions = getSuggestions();
//        if (!suggestions.isEmpty()) {
//            suggestions.get(0).click();
//        }
//    }
//}
package appPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class AmazonHomePage {

    private WebDriver driver;

    // Locators
    private By searchBox = By.id("twotabsearchtextbox");
    private By searchButton = By.id("nav-search-submit-button");
    private By suggestionList = By.cssSelector("div.autocomplete-results-container div.s-suggestion");
    private By searchResults = By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']");

    // Constructor
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterSearchText(String product) {
        WebElement box = driver.findElement(searchBox);
        box.clear();
        box.sendKeys(product);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public List<WebElement> getSuggestions() {
        return driver.findElements(suggestionList);
    }

    public List<WebElement> getSearchResults() {
        return driver.findElements(searchResults);
    }
}
