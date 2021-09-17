package pages;


import org.openqa.selenium.WebDriver;

public class DashboardPage extends MenuPage {
    private String pageUrl = config.getApplicationUrl();

    public DashboardPage(WebDriver driver) {
        super(driver);
    }




}
