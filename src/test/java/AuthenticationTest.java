import org.testng.annotations.Test;
import pages.LoginPage;

public class AuthenticationTest extends SeleniumBaseTest {

    @Test
    public void Correct_Auth_Test() {
        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .assertWelcomeMessageIsShown();
    }
}
