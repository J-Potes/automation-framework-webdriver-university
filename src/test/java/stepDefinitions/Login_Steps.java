package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.Base_PO;

import java.time.Duration;
import java.util.ArrayList;

import static driver.DriverFactory.getDriver;

public class Login_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    @Given("I access the webdriver university home page")
    public void i_access_the_webdriver_university_home_page() {
        navigateTo_URL("https://www.webdriveruniversity.com");
    }

    @And("I click on the Login Portal option")
    public void i_click_on_the_login_portal_option() {
        WebElement element = driver.findElement(By.xpath("//a[@id='login-portal']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-100);", element);

        element.click();

//        this.driver.findElement(By.id("login-portal")).click();

        ArrayList<String> tabs = new ArrayList<>(this.driver.getWindowHandles());
        this.driver.switchTo().window(tabs.get(1)); // id of the tab
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("text")));
//        this.driver.findElement(By.id("text")).sendKeys(new CharSequence[]{username});
        element.sendKeys(new CharSequence[]{username});
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        this.driver.findElement(By.id("password")).sendKeys(new CharSequence[]{password});
    }

    @And("I click on the Login button")
    public void i_click_on_the_login_button() {
        this.driver.findElement(By.id("login-button")).click();
    }

    @Then("a validation succeeded message is displayed")
    public void a_validation_succeeded_message_is_displayed() {
        String alertMessage = this.driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "validation succeeded");
    }

    @Then("a validation failed message is displayed")
    public void a_validation_failed_message_is_displayed() {
        Alert alert = this.driver.switchTo().alert();
        String alertMessage = this.driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, "validation failed");
    }

    @Then("I should be presented with the message {}")
    public void i_should_be_presented_with_the_message(String expectedMessage) {
        Alert alert = this.driver.switchTo().alert();
        String alertMessage = this.driver.switchTo().alert().getText();
        Assert.assertEquals(alertMessage, expectedMessage);
    }
}
