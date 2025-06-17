package stepDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Hooks {
    public WebDriver driver;

    @Before
    public void setup(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        this.driver = new ChromeDriver(chromeOptions);
        this.driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        this.driver.quit();
    }
}
