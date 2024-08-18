package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LoginPage;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Steps {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public LoginPage lp;
    @Given("User Launch Chrome browser")
    public void user_launch_chrome_browser() {

        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        lp = new LoginPage(driver);
    }

    @When("User Opens URL {string}")
    public void user_opens_url(String url) {
        driver.get(url);
    }

    @When("User Enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {
        lp.setUserName(email);
        lp.setPassWord(password);
    }


    @When("Click on Log in")
    public void click_on_log_in() {
        lp.clickLogin();
    }

    @Then("Page title should be {string}")
    public void page_title_should_be(String title) {
        if(driver.getPageSource().contains("Login was unsuccessful")){
            driver.close();
            Assert.assertTrue(false);
        }
        else {
            Assert.assertEquals(title,driver.getTitle());
        }
    }

    @When("User click on logout link")
    public void user_click_on_logout_link() throws InterruptedException {
        lp.clickLogout();
        Thread.sleep(3000);
    }

    @Then("Close the Browser")
    public void close_the_browser() {
        driver.quit();
    }


    @Then("Text Should Be Available On The Page {string}")
    public void text_should_be_available_on_the_page(String subTitle) {
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + subTitle + "')]"));

        // Assert that the element is displayed
        Assert.assertTrue("Expected text is displayed on the page", element.isDisplayed());

    }

    @When("User Click on Link {string}")
    public void user_click_on_link(String linkText) {
        // Find the link and click it
        WebElement link = driver.findElement(By.xpath("//*[contains(text(),'" + linkText + "')]"));
        link.click();
    }

    @Then("User should be in New Tab {string}")
    public void user_should_be_in_new_tab(String titleInNewTab) {
        // Get the handle of the original window
        String originalWindow = driver.getWindowHandle();

        // Switch to the new tab
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Get the actual title of the new tab
        String actualTitle = driver.getTitle();

        // Verify the title
        Assert.assertEquals("The title of the page in the new tab is not as expected.", titleInNewTab, actualTitle);
    }

    @When("Click on Button {string}")
    public void click_on_button(String buttonText) {
        WebElement button = driver.findElement(By.xpath("(//a[text()='"+buttonText+"'])[1]"));
        button.click();
    }
}
