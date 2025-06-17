package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.Iterator;

public class Login_Steps {
    @Given("I access the webdriver university home page")
    public void i_access_the_webdriver_university_home_page() {
        this.driver.get("https://www.webdriveruniversity.com");
    }

    @And("I click on the Login Portal option")
    public void i_click_on_the_login_portal_option() {
        this.driver.findElement(By.id("login-portal")).click();
        String originalTab = this.driver.getWindowHandle();
        Iterator var2 = this.driver.getWindowHandles().iterator();

        while(var2.hasNext()) {
            String tab = (String)var2.next();
            if (!tab.equals(originalTab)) {
                this.driver.switchTo().window(tab);
                break;
            }
        }

    }

    @When("I enter a username {}")
    public void i_enter_a_username(String username) {
        this.driver.findElement(By.id("text")).sendKeys(new CharSequence[]{username});
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
