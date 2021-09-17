import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utilities;

public class RegistrationWithFailureTest extends SeleniumBaseTest {
    @Test
    public void Registration_WithFailure_IncorrectConfirmPassword_Test() {
        String email = new Utilities().generateRandomEmail();

        new LoginPage(driver)
                .goToCreateAccountPage()
                .typeEmail(email)
                .typePassword(password)
                .typeConfirmPassword(password + "test")
                .submitRegisterWithFailure()
                .assertConfirmPasswordErrorIsShown();
    }

    @DataProvider
    public static Object[][] getWrongPasswords() {
        return new Object[][]{
                {"test123!", "Passwords must have at least one uppercase ('A'-'Z')."},
                {"TestTest!", "Passwords must have at least one digit ('0'-'9')."},
                {"Test123", "Passwords must have at least one non alphanumeric character."}
        };
    }

    @Test(dataProvider = "getWrongPasswords")
    public void Registration_WithFailure_IncorrectPassword_Test(String wrongPassword, String expErrorMessage) {
        String email = new Utilities().generateRandomEmail();

        new LoginPage(driver)
                .goToCreateAccountPage()
                .typeEmail(email)
                .typePassword(wrongPassword)
                .typeConfirmPassword(wrongPassword)
                .submitRegisterWithFailure()
                .assertPasswordErrorIsShown(expErrorMessage);
    }
}
