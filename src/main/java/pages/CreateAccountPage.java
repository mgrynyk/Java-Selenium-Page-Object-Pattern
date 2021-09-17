package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CreateAccountPage extends MenuPage {

    public CreateAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "Email")
    private WebElement emailTxt;

    @FindBy(id = "Password")
    private WebElement passwordTxt;

    @FindBy(id = "ConfirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(css = "button[type=submit]")
    private WebElement registerBtn;

    @FindBy(id = "Email-error")
    private WebElement emailError;

    @FindBy(id = "ConfirmPassword-error")
    private WebElement confirmPasswordError;

    @FindBy(xpath = "//*[@id=\"register\"]/section/form/div[1]")
    private WebElement passwordError;

    public CreateAccountPage typeEmail(String email) {
        emailTxt.clear();
        emailTxt.sendKeys(email);

        return this;
    }

    public CreateAccountPage typePassword(String password) {
        passwordTxt.clear();
        passwordTxt.sendKeys(password);

        return this;
    }

    public CreateAccountPage typeConfirmPassword(String password) {
        confirmPasswordTxt.clear();
        confirmPasswordTxt.sendKeys(password);

        return this;
    }

    public DashboardPage submitRegister() {
        registerBtn.click();

        return new DashboardPage(driver);
    }

    public CreateAccountPage submitRegisterWithFailure() {
        registerBtn.click();

        return this;
    }


    public CreateAccountPage assertConfirmPasswordErrorIsShown() {
        String expError = "The password and confirmation password do not match.";
        Assert.assertEquals(confirmPasswordError.getText(), expError);

        return this;
    }

    public CreateAccountPage assertPasswordErrorIsShown(String expErrorMessage) {
        Assert.assertEquals(passwordError.getText(), expErrorMessage);

        return this;
    }
}