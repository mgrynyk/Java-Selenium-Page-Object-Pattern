package pages;

import config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SeleniumPage {
    protected WebDriver driver;
    protected Config config = new Config();

    public SeleniumPage (WebDriver driver){
        this.driver =driver;
        PageFactory.initElements(driver, this);
    }

}