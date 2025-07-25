package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_PO extends Base_PO{
    private @FindBy(id = "text")
    WebElement username_TextField;

    private @FindBy(id = "password")
    WebElement password_TextField;

    private @FindBy(id = "login-button")
    WebElement login_Button;

    public Login_PO(){
        super();
    }

    public Login_PO(WebDriver driver){
        super(driver);
    }

    public void setUsername(String username){
        sendKeys(username_TextField, username);
    }

    public void setPassword(String password){
        sendKeys(password_TextField, password);
    }

    public void clickOnLoginButton(){
        clickElement(login_Button);
    }
}
