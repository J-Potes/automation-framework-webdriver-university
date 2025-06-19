package pageObjects;

public class Contact_Us_PO extends Base_PO{
    public Contact_Us_PO(){
        super();
    }

    public void navigateTo_WebDriverUniversity_ContactUs_Page(){
        navigateTo_URL("https://www.webdriveruniversity.com/Contact-Us/contactus.html");
    }
}
