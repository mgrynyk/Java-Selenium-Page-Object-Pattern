package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CharacteristicsPage extends MenuPage {

    public CharacteristicsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Add new characteristic")
    private WebElement addCharacteristicBtn;


    public CreateCharacteristicPage clickAddCharacteristic() {
        addCharacteristicBtn.click();

        return new CreateCharacteristicPage(driver);
    }


    public CharacteristicsPage assertCharacteristicOnTheList(String characteristicName, String upLimit, String lowLimit, String binCount) {
        String characteristicXpath = "//td[text()='"+characteristicName+"']/..";
        WebElement characteristicRow = driver.findElement(By.xpath(characteristicXpath));

        String actualLowLimit = characteristicRow.findElement(By.xpath("./td[3]")).getText();
        String actualUpLimit = characteristicRow.findElement(By.xpath("./td[4]")).getText();
        String actualBinCount = characteristicRow.findElement(By.xpath("./td[5]")).getText();

        Assert.assertEquals(actualLowLimit, lowLimit);
        Assert.assertEquals(actualUpLimit, upLimit);
        Assert.assertEquals(actualBinCount, binCount);

        return this;
    }

    public CharacteristicsPage assertCharacteristicIsNotOnTheList(String characteristicName) {
        String characteristicXpath = "//td[text()='"+characteristicName+"']/..";
        List<WebElement> characteristic = driver.findElements(By.xpath(characteristicXpath));
        Assert.assertEquals(characteristic.size(), 0);

        return this;
    }
}
