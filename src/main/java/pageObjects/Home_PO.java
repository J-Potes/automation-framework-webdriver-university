package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_PO extends Base_PO{
    private @FindBy(xpath = "//a[@id='login-portal']")
    WebElement loginPortal_Button;

    public Home_PO(){
        super();
    }

    public Home_PO(WebDriver driver){
        super(driver);
    }

    public void navigateTo_WebDriverUniversity_Home_Page(){
        navigateTo_URL("https://www.webdriveruniversity.com");
    }

    public Login_PO clickOnLoginPortalandEnterLoginPage(){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true); window.scrollBy(0,-100);", loginPortal_Button);
        clickElement(loginPortal_Button);
        switchToTab(1);
        return new Login_PO(getDriver());
    }
}
