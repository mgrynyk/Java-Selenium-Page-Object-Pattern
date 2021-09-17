import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AuthenticationWithFailureTest extends SeleniumBaseTest {

    @DataProvider
    public Object[][] getWrongEmails() {
        return new Object[][]{
                {"email1"},
                {"123email"}
        };
    }

    @Test(dataProvider = "getWrongEmails")
    public void AuthWithFailure_IncorrectEmail_Test(String wrongEmail) {
        new LoginPage(driver)
                .typeEmail(wrongEmail)
                .submitAuthWithFailure()
                .assertEmailErrorIsShown();
    }

    @Test
    public void AuthWithFailure_IncorrectPassword_Test() {
        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password + "password123")
                .submitAuthWithFailure()
                .assertLoginErrorIsShown();
    }
}