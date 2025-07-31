package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Contact_Us_PO extends Base_PO{
    private @FindBy(xpath = "//input[@name='first_name']")
    WebElement firstName_TextField;

    private @FindBy(xpath = "//input[@name='last_name']")
    WebElement lastName_TextField;

    private @FindBy(xpath = "//input[@name='email']")
    WebElement email_TextField;

    private @FindBy(xpath = "//textarea[@name='message']")
    WebElement comment_TextField;

    private @FindBy(xpath = "//input[@type='submit']")
    WebElement submit_button;

    private @FindBy(xpath = "//div[@id='contact_reply']/h1")
    WebElement submission_Message;

    public Contact_Us_PO(){
        super();
    }

    public void navigateTo_WebDriverUniversity_ContactUs_Page(){
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }

    public void setFirstName(String firstName){
        sendKeys(firstName_TextField, firstName);
    }

    public void setLastName(String lastName){
        sendKeys(lastName_TextField, lastName);
    }

    public void setEmail(String email){
        sendKeys(email_TextField, email);
    }

    public void setComment(String comment){
        sendKeys(comment_TextField, comment);
    }

    public void clickOnSubmitButton(){
        clickElement(submit_button);
    }

    public void validateSubmissionMessage(){
        waitFor(submission_Message);
        validateText(submission_Message.getText(),"Thank You for your Message!");
    }

    public void setUniqueFirstName(){
        setFirstName("AutoFN" + generateRandomNumber(5));
    }

    public void setUniqueLastName(){
        setLastName("AutoLN" + generateRandomNumber(5));
    }

    public void setUniqueEmail(){
        setEmail("AutoEmail" + generateRandomNumber(5) + "@email.com");
    }

    public void setUniqueComment(){
        setComment("Hello world " + generateRandomString(20));
    }
}
