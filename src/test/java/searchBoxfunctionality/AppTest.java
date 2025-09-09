//package searchBoxfunctionality;
//import baseClass.AppBaseClass;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import java.util.List;
//
//public class AppTest extends AppBaseClass {
//
//	
//	//1.Combination of string, character, number, it should load result page (as per requirement)
//
//	@Test(priority=1)
//	public void testStringcharacterNumberValidInput() {
//	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//	    searchBox.clear();
//	    searchBox.sendKeys("Samsung@A54");
//
//	    WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
//	    searchBtn.click();
//
//	    // Wait for results
//	    List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//	            By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']")));
//
//	    Assert.assertTrue(results.size() > 0, "String+Character+Number product search failed - No results found!");
//	}
//
//   //  2.Enter a valid product name and click on the search icon. It should show the result with the given product name.
//
//	@Test(priority = 2)
////    public void testValidProductSearch() {
////        WebElement searchBox = wait.until(
////                ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox"))
////        );
////        searchBox.sendKeys("Laptop");
////        searchBox.submit();
////
////        Assert.assertTrue(driver.getTitle().toLowerCase().contains("laptop"),
////                "Title me Laptop word nahi mila!");
////    }
//	
//	public void testValidProductSearch() {
//	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//	    searchBox.clear();
//	    searchBox.sendKeys("Tv");
//	    searchBox.submit();
//
//	    // Wait until title or search heading loads
//	    wait.until(ExpectedConditions.or(
//	            ExpectedConditions.titleContains("Tv"),
//	            ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.a-color-state"))
//	    ));
//
//	    Assert.assertTrue(driver.getTitle().toLowerCase().contains("Tv")
//	            || driver.findElement(By.cssSelector("span.a-color-state")).getText().toLowerCase().contains("Tv"),
//	            "Laptop search result not validate ");
//	}
//
//
//    // 3.Enter nothing/ click on the search button, it should show the same page without refreshing the page.
//
//    @Test(priority = 3)
//    public void testEmptySearch() {
//        WebElement searchBtn = wait.until(
//                ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))
//        );
//        searchBtn.click();
//        Assert.assertTrue(driver.getTitle().contains("Amazon"),
//                "Empty search did not stay on Amazon home page!");
//    }
//
//    // 4.Typing any single character in the search box, it should show a list of product suggestions starting with the entered character.
//    @Test(priority = 4)
//    public void testSingleCharSuggestion() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("M");
//
//        List<WebElement> suggestions = wait.until(
//                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.autocomplete-results-container div.s-suggestion"))
//        );
//        Assert.assertTrue(suggestions.size() > 0, "No suggestions displayed for single character input!");
//    }
//
//    // 5.Type any two-character, the user should be able to see an updated list with the product starting from given two-character
//
//    @Test(priority = 5)
//    public void testTwoCharSearch() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("Mo");
//
//        List<WebElement> suggestions = wait.until(
//                ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div.autocomplete-results-container div.s-suggestion"))
//        );
//        Assert.assertTrue(suggestions.size() > 0, "No suggestions for two-character input!");
//    }
//
//    // 6.Enter a random character, it should load the result page with an error message.
//    @Test(priority = 6)
////   public void testInvalidRandomInput() {
////        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
////        searchBox.clear();
////        searchBox.sendKeys("zzzzzzzzzzzz");
////
////        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
////        searchBtn.click();
////
////        Assert.assertTrue(driver.getTitle().contains("zzzzzzzzzzzz"),
////                "Invalid input did not reflect in search result!");
////    }
//   
//    public void testInvalidRandomInput() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("spjhughvgfhvhjf");
//
//        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
//        searchBtn.click();
//
//        // Wait for result container
//        WebElement noResultMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[contains(text(),'No results') or contains(text(),'did not match any products')]")));
//
//        Assert.assertTrue(noResultMessage.isDisplayed(),
//                "Invalid input did not show 'No results' message!");
//    }
//
//    
//
//    // 7. Long String Input (under 650 chars)
//    @Test(priority = 7)
//    public void testLongStringInput() {
//        String longStr = "a".repeat(500);
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys(longStr);
//
//        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
//        searchBtn.click();
//
//        Assert.assertTrue(driver.getTitle().contains("a"),
//                "Long string input did not load results properly!");
//    }
//
//    //8Combination of alphanumeric character, it should load result page (as per requirement)
//
//    @Test(priority = 8)
////    public void testAlphanumericValidInput() {
////        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
////        searchBox.clear();
////        searchBox.sendKeys("iPhone 14");
////
////        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
////        searchBtn.click();
////
////        Assert.assertTrue(driver.getTitle().contains("iPhone 14"),
////                "Alphanumeric product search failed!");
////    }
//    
//    public void testAlphanumericValidInput() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("iPhone 14");
//
//        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
//        searchBtn.click();
//
//        // Title check
//        wait.until(ExpectedConditions.titleContains("iPhone 14"));
//        Assert.assertTrue(driver.getTitle().toLowerCase().contains("iphone"),
//                "Alphanumeric product search failed - Title mismatch!");
//
//        // Results check
//        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//                By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']")));
//        Assert.assertTrue(results.size() > 0, "Alphanumeric product search failed - No results found!");
//    }
//
//    // 9. Search Submission via Keyboard vs Button
//    @Test(priority = 9)
////    public void testKeyboardVsButtonSearch() {
////        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
////        searchBox.clear();
////        searchBox.sendKeys("Camera");
////
////        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
////        searchBtn.click();
////        String titleWithButton = driver.getTitle();
////
////        WebElement searchBox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
////        searchBox2.clear();
////        searchBox2.sendKeys("Camera\n");
////        String titleWithEnter = driver.getTitle();
////
////        Assert.assertEquals(titleWithButton, titleWithEnter,
////                "Search results differ between Button click and Enter key!");
////    }
//    
//    public void testKeyboardVsButtonSearch() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("Camera");
//
//        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
//        searchBtn.click();
//
//        // Wait page load ho
//        wait.until(ExpectedConditions.titleContains("Camera"));
//        String titleWithButton = driver.getTitle();
//
//        // Keyboard search
//        WebElement searchBox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox2.clear();
//        searchBox2.sendKeys("Camera\n");
//
//        wait.until(ExpectedConditions.titleContains("Camera"));
//        String titleWithEnter = driver.getTitle();
//
//        // Instead of exact match, check keyword presence
//        Assert.assertTrue(titleWithButton.contains("Camera") && titleWithEnter.contains("Camera"),
//                "Either search did not contain expected keyword!");
//    }
//
//
//    // 10. UI Hover Behavior on Search Button
//    @Test(priority = 10)
//    public void testHoverOnSearchButton() {
//        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-search-submit-button")));
//        Actions actions = new Actions(driver);
//        actions.moveToElement(searchButton).perform();
//
//        String cursor = searchButton.getCssValue("cursor");
//        Assert.assertTrue(cursor.equals("pointer"),
//                "Hovering on search button does not change cursor to hand pointer!");
//    }
//    
//
//
//}
//package searchBoxfunctionality;
//
//import baseClass.AppBaseClass;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public class AppTest extends AppBaseClass {
//
//    // 1. String + Character + Number input
//    @Test(priority = 1)
//    public void testStringCharacterNumber() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("Samsung@A54");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))).click();
//
//        List<WebElement> results = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//                By.cssSelector("div.s-main-slot div[data-component-type='s-search-result']")));
//        Assert.assertTrue(results.size() > 0, "❌ No results found for Samsung@A54!");
//    }
//
//    // 2. Valid product search
//    @Test(priority = 2)
//    public void testValidProductSearch() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("Bluetooth");
//        searchBox.submit();
//
//        Assert.assertTrue(driver.getTitle().toLowerCase().contains("bluetooth")
//                || driver.getPageSource().toLowerCase().contains("bluetooth"),
//                "❌ bluetooth search not validated!");
//    }
//
//    // 3. Empty search
//    @Test(priority = 3)
//    public void testEmptySearch() {
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))).click();
//        Assert.assertTrue(driver.getTitle().contains("Amazon"),
//                "❌ Empty search did not stay on home page!");
//    }
//
//    // 4. Single character suggestion
//    @Test(priority = 4)
//    public void testSingleCharSuggestion() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("M");
//
//        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//                By.cssSelector("div.autocomplete-results-container div.s-suggestion")));
//        Assert.assertTrue(suggestions.size() > 0, "❌ No suggestions for single character!");
//    }
//
//    // 5. Two-character suggestion
//    @Test(priority = 5)
//    public void testTwoCharSearch() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("Mo");
//
//        List<WebElement> suggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//                By.cssSelector("div.autocomplete-results-container div.s-suggestion")));
//        Assert.assertTrue(suggestions.size() > 0, "❌ No suggestions for two characters!");
//    }
//
//    // 6. Invalid input
//    @Test(priority = 6)
//    public void testInvalidInput() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("spjhughvgfhvhjf");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))).click();
//
//        WebElement noResultMessage = wait.until(ExpectedConditions.presenceOfElementLocated(
//                By.xpath("//*[contains(text(),'No results') or contains(text(),'did not match any products')]")));
//        Assert.assertTrue(noResultMessage.isDisplayed(), "❌ Invalid input did not show 'No results' message!");
//    }
//
//    // 7. Long string input
//    @Test(priority = 7)
//    public void testLongStringInput() {
//        String longStr = "a".repeat(500);
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys(longStr);
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))).click();
//
//        Assert.assertTrue(driver.getTitle().contains("a"),
//                "❌ Long string input did not load results!");
//    }
//
//    // 8. Alphanumeric input
//    @Test(priority = 8)
//    public void testAlphanumericInput() {
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        searchBox.clear();
//        searchBox.sendKeys("iPhone 14");
//        wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button"))).click();
//
//        Assert.assertTrue(driver.getTitle().toLowerCase().contains("iphone"),
//                "❌ Alphanumeric search failed!");
//    }
//
//    // 9. Keyboard vs Button
//    @Test(priority = 9)
//    
//    public void testSubmitByClickingSearchButton() {
//        // Wait for search box visible
//        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
//        
//        // Clear and enter product name
//        searchBox.clear();
//        searchBox.sendKeys("Camera");
//
//        // Click on search button
//        WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("nav-search-submit-button")));
//        searchButton.click();
//
//        // Verify page title contains searched text
//        String pageTitle = driver.getTitle();
//        Assert.assertTrue(pageTitle.contains("Camera"), "❌ Search result page title does not contain the searched product!");
//    }
//
//
//    // 10. Hover on search button
//    @Test(priority = 10)
//    public void testHoverOnSearchButton() {
//        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-search-submit-button")));
//        new Actions(driver).moveToElement(searchButton).perform();
//
//        String cursor = searchButton.getCssValue("cursor");
//        Assert.assertEquals(cursor, "pointer", "❌ Hover did not change cursor to pointer!");
//    }
//}


package searchBoxfunctionality;

import baseClass.AppBaseClass;
import appPages.AmazonHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AppTest extends AppBaseClass {

    private AmazonHomePage homePage;

    @Test(priority = 1)
    public void testStringCharacterNumber() {
        homePage = new AmazonHomePage(driver);
        homePage.enterSearchText("Samsung@A54");
        homePage.clickSearchButton();

        List<WebElement> results = homePage.getSearchResults();
        Assert.assertTrue(results.size() > 0, "❌ No results found for Samsung@A54!");
    }

    @Test(priority = 2)
    public void testValidProductSearch() {
        homePage = new AmazonHomePage(driver);
        homePage.enterSearchText("Bluetooth");
        homePage.clickSearchButton();

        Assert.assertTrue(homePage.getPageTitle().toLowerCase().contains("bluetooth"),
                "❌ Bluetooth search not validated!");
    }

    @Test(priority = 3)
    public void testEmptySearch() {
        homePage = new AmazonHomePage(driver);
        homePage.clickSearchButton();
        Assert.assertTrue(driver.getTitle().contains("Amazon"),
                "❌ Empty search did not stay on home page!");
    }

    @Test(priority = 4)
    public void testSingleCharSuggestion() {
        homePage = new AmazonHomePage(driver);
        homePage.enterSearchText("M");

        List<WebElement> suggestions = homePage.getSuggestions();
        Assert.assertTrue(suggestions.size() > 0, "❌ No suggestions for single character!");
    }

    @Test(priority = 5)
    public void testTwoCharSearch() {
        homePage = new AmazonHomePage(driver);
        homePage.enterSearchText("Mo");

        List<WebElement> suggestions = homePage.getSuggestions();
        Assert.assertTrue(suggestions.size() > 0, "❌ No suggestions for two characters!");
    }

    @Test(priority = 6)
    public void testInvalidInput() {
        homePage = new AmazonHomePage(driver);
        homePage.enterSearchText("spjhughvgfhvhjf");
        homePage.clickSearchButton();

        WebElement noResultMessage = driver.findElement(
                By.xpath("//*[contains(text(),'No results') or contains(text(),'did not match any products')]"));
        Assert.assertTrue(noResultMessage.isDisplayed(), "❌ Invalid input did not show 'No results' message!");
    }

    @Test(priority = 7)
    public void testLongStringInput() {
        homePage = new AmazonHomePage(driver);
        homePage.enterSearchText("a".repeat(500));
        homePage.clickSearchButton();

        Assert.assertTrue(driver.getTitle().contains("a"),
                "❌ Long string input did not load results!");
    }

    @Test(priority = 8)
    public void testAlphanumericInput() {
        homePage = new AmazonHomePage(driver);
        homePage.enterSearchText("iPhone 14");
        homePage.clickSearchButton();

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("iphone"),
                "❌ Alphanumeric search failed!");
    }

    @Test(priority = 9)
    public void testSubmitByClickingSearchButton() {
        homePage = new AmazonHomePage(driver);
        homePage.enterSearchText("Camera");
        homePage.clickSearchButton();

        Assert.assertTrue(driver.getTitle().contains("Camera"),
                "❌ Search result page title does not contain the searched product!");
    }

    @Test(priority = 10)
    public void testHoverOnSearchButton() {
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        new Actions(driver).moveToElement(searchButton).perform();

        String cursor = searchButton.getCssValue("cursor");
        Assert.assertEquals(cursor, "pointer", "❌ Hover did not change cursor to pointer!");
    }
}

