package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProcessesPage extends MenuPage {

    public ProcessesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Add new process")
    private WebElement addProcessBtn;


    public CreateProcessPage clickAddProcess() {
        addProcessBtn.click();

        return new CreateProcessPage(driver);
    }


        public ProcessesPage assertProcessSuccessfullyCreated(){

            WebElement flashMessageElement = driver.findElement(By.cssSelector(".flash-message"));
            String flashMessageText = flashMessageElement.getText();
            Assert.assertEquals(flashMessageText, "Process has been created");

        return this;
        }


    public ProcessesPage assertProcessIsNotOnTheList(String wrongProcessName) {

        String processXpath = "//td[text()='" + wrongProcessName + "']/..";
        List<WebElement> process = driver.findElements(By.xpath(processXpath));
        Assert.assertEquals(process.size(), 0);

        return this;
    }


}