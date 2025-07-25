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
import pageObjects.Contact_Us_PO;
import pageObjects.Home_PO;
import pageObjects.Login_PO;

import java.time.Duration;
import java.util.ArrayList;

import static driver.DriverFactory.getDriver;

public class Login_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    private Home_PO home_po;
    private Login_PO login_po;

    public Login_Steps(Home_PO home_po){
        this.home_po = home_po;
    }

    @Given("I access the webdriver university home page")
    public void i_access_the_webdriver_university_home_page() {
        home_po.navigateTo_WebDriverUniversity_Home_Page();
    }

    @And("I click on the Login Portal option")
    public void i_click_on_the_login_portal_option() {
        login_po = home_po.clickOnLoginPortalandEnterLoginPage();
    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        login_po.setUsername(username);
    }

    @And("I enter a password {}")
    public void i_enter_a_password(String password) {
        login_po.setPassword(password);
    }

    @And("I click on the Login button")
    public void i_click_on_the_login_button() {
        login_po.clickOnLoginButton();
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
