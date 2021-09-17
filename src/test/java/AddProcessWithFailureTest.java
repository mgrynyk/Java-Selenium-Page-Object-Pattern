import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class AddProcessWithFailureTest extends SeleniumBaseTest {
    @DataProvider
    public static Object[][] getWrongProcessName() {
        return new Object[][]{
                {"1", "The field Name must be a string with a minimum length of 3 and a maximum length of 30."},
                {"", "The Name field is required."}
        };
    }
    @Test(dataProvider = "getWrongProcessName")
    public void addProcess_WithFailure_WrongName_Test(String wrongProcessName, String expErrorMessage){

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(wrongProcessName)
                .submitCreateWithFailure()
                .assertProcessNameError(expErrorMessage)
                .backToProcessesList()
                .assertProcessIsNotOnTheList(wrongProcessName);
    }
}