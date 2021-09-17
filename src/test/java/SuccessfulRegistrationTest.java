import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utilities;

public class SuccessfulRegistrationTest extends SeleniumBaseTest {
    @Test
    public void UserRegistration_Test() {
        String email = new Utilities().generateRandomEmail();

        new LoginPage(driver)
                .goToCreateAccountPage()
                .typeEmail(email)
                .typePassword(password)
                .typeConfirmPassword(password)
                .submitRegister();
    }
}
