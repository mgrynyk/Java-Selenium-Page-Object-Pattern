import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utilities;

public class AddProcessTest extends SeleniumBaseTest {

    @Test
    public void createNewProcess_Test() {
        String processName = new Utilities().generateRandomName();

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToProcesses()
                .clickAddProcess()
                .typeName(processName)
                .submitCreate()
                .assertProcessSuccessfullyCreated();
    }

}
