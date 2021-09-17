package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CreateCharacteristicPage extends MenuPage {

    public CreateCharacteristicPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "ProjectId")
    private WebElement projectSlc;

    @FindBy(id = "Name")
    private WebElement nameTxt;

    @FindBy(id = "LowerSpecificationLimit")
    private WebElement lslTxt;

    @FindBy(id = "UpperSpecificationLimit")
    private WebElement uslTxt;

    @FindBy(id = "HistogramBinCount")
    private WebElement binCountTxt;

    @FindBy(css = "input[type=submit]")
    private WebElement createBtn;

    @FindBy(css = ".field-validation-error[data-valmsg-for=ProjectId]")
    private WebElement processError;

    @FindBy(css = ".field-validation-error[data-valmsg-for=\"UpperSpecificationLimit\"")
    private WebElement uslError;

    @FindBy(linkText = "Back to List")
    private WebElement backBtn;


    public CreateCharacteristicPage selectProcess(String processName) {
        new Select(projectSlc).selectByVisibleText(processName);

        return this;
    }

    public CreateCharacteristicPage typeName(String name) {
        nameTxt.clear();
        nameTxt.sendKeys(name);

        return this;
    }

    public CreateCharacteristicPage typeLowSpecLimit(String lsl) {
        lslTxt.clear();
        lslTxt.sendKeys(lsl);

        return this;
    }

    public CreateCharacteristicPage typeUpSpecLimit(String usl) {
        uslTxt.clear();
        uslTxt.sendKeys(usl);

        return this;
    }
    public CreateCharacteristicPage typeBinCount(String lsl) {
        binCountTxt.clear();
        binCountTxt.sendKeys(lsl);

        return this;
    }

    public CharacteristicsPage submitCreate() {
        createBtn.click();

        return new CharacteristicsPage(driver);
    }

    public CreateCharacteristicPage submitCreateWithFailure() {
        createBtn.click();

        return this;
    }

    public CreateCharacteristicPage assertProcessError() {
        String expError = "The value 'Select process' is not valid for ProjectId.";
        Assert.assertEquals(processError.getText(), expError);

        return this;
    }

    public CreateCharacteristicPage assertEmptyUslFieldError(){
        String expError = "The value '' is invalid.";
        Assert.assertEquals(uslError.getText(), expError);

        return this;
    }

    public CharacteristicsPage backToCharacteristicsList() {
        backBtn.click();

        return new CharacteristicsPage(driver);
    }
}