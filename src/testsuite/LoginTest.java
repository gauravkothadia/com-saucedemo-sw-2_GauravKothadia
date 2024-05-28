package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * 3. Write down the following test into ‘LoginTest’ class
 * 1. userSholdLoginSuccessfullyWithValid Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed on
 * page
 */
public class LoginTest extends BaseTest {
    @Before
    public void browserSetup() {
        openBrowser("https://www.saucedemo.com/");
    }

    @Test
    public void userSholdLoginSuccessfullyWithValidCredentials() {
        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Enter “secret_sauce” password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        // Verify the text “PRODUCTS”
        String expectedText = "PRODUCTS";
        String actualText = driver.findElement(By.cssSelector("div.header_secondary_container>span.title")).getText();
        Assert.assertTrue(expectedText.equalsIgnoreCase(actualText));
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        // Enter “standard_user” username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        // Enter “secret_sauce” password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        // Click on ‘LOGIN’ button
        driver.findElement(By.id("login-button")).click();
        // Verify that six products are displayed on page
        int totalExpectedProductsOnPage = 6;
        List <WebElement> actualTotalProductsDisplayed = driver.findElements(By.cssSelector("div.inventory_item"));
        Assert.assertEquals(totalExpectedProductsOnPage,actualTotalProductsDisplayed.size());
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
