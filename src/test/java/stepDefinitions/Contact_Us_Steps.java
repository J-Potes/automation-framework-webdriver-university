package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pageObjects.Base_PO;
import pageObjects.Contact_Us_PO;

public class Contact_Us_Steps extends Base_PO {
    private WebDriver driver = getDriver();

    private Contact_Us_PO contact_us_po;

    public Contact_Us_Steps(Contact_Us_PO contact_us_po){
        this.contact_us_po = contact_us_po;
    }

    @Given("I access the webdriver university contact us page")
    public void i_access_the_webdriver_university_contact_us_page(){
        contact_us_po.navigateTo_WebDriverUniversity_ContactUs_Page();
    }
    @When("I enter a unique first name")
    public void i_enter_a_unique_first_name() {
//        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("AutoFN" + generateRandomNumber(5));
//        sendKeys(By.xpath("//input[@name='first_name']"), "AutoFN" + generateRandomNumber(5));
        contact_us_po.setFirstName("AutoFN" + generateRandomNumber(5));
    }
    @And("I enter a unique last name")
    public void i_enter_a_unique_last_name() {
//        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("AutoLN" + generateRandomNumber(5));
//        sendKeys(By.xpath("//input[@name='last_name']"), "AutoLN" + generateRandomNumber(5));
        contact_us_po.setLastName("AutoLN" + generateRandomNumber(5));
    }
    @And("I enter a unique email address")
    public void i_enter_a_unique_email_address() {
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("AutoEmail" + generateRandomNumber(5) + "@email.com");
//        sendKeys(By.xpath("//input[@name='email']"), "AutoEmail" + generateRandomNumber(5) + "@email.com");
        contact_us_po.setEmail("AutoEmail" + generateRandomNumber(5) + "@email.com");
    }
    @And("I enter a unique comment")
    public void i_enter_a_unique_comment() {
//        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Hello world " + generateRandomString(20));
//        sendKeys(By.xpath("//textarea[@name='message']"), "Hello world " + generateRandomString(20));
        contact_us_po.setComment("Hello world " + generateRandomString(20));
    }

    @When("I enter a specific first name {word}")
    public void i_enter_a_specific_first_name(String firstName) {
//        driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys(firstName);
//        sendKeys(By.xpath("//input[@name='first_name']"), firstName);
        contact_us_po.setFirstName(firstName);
    }
    @And("I enter a specific last name {word}")
    public void i_enter_a_specific_last_name(String lastName) {
//        driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys(lastName);
//        sendKeys(By.xpath("//input[@name='last_name']"), lastName);
        contact_us_po.setLastName(lastName);
    }
    @And("I enter a specific email address {word}")
    public void i_enter_a_specific_email_address(String email) {
//        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);
//        sendKeys(By.xpath("//input[@name='email']"), email);
        contact_us_po.setEmail(email);
    }
    @And("I enter a specific comment {string}")
    public void i_enter_a_specific_comment(String comment) {
//        driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys(comment);
//        sendKeys(By.xpath("//textarea[@name='message']"), comment);
        contact_us_po.setComment(comment);
    }

    @And("I click on the submit button")
    public void i_click_on_the_submit_button() {
//        driver.findElement(By.xpath("//input[@type='submit']")).click();
//        clickElement(By.xpath("//input[@type='submit']"));
        contact_us_po.clickOnSubmitButton();
    }

    @Then("I should be presented with a successful contact us submission message")
    public void i_should_be_presented_with_a_successful_contact_us_submission_message() {
        Assert.assertEquals(contact_us_po.getSubmissionMessage(), "Thank You for your Message!");
    }
}