import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utilities;

public class AddCharacteristicWithFailureTest extends SeleniumBaseTest{
    @Test
    public void addCharacteristic_WithFailure_ProcessError_Test() {
        String characteristicName = new Utilities().generateRandomName();

        String up_limit = "2";
        String low_limit = "1";


        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                .typeName(characteristicName)
                .typeLowSpecLimit(low_limit)
                .typeUpSpecLimit(up_limit)
                .submitCreateWithFailure()
                .assertProcessError()
                .backToCharacteristicsList()
                .assertCharacteristicIsNotOnTheList(characteristicName);
    }

    @Test
    public void addCharacteristic_WithFailure_NoUpLimit_Test() {
        String characteristicName = new Utilities().generateRandomName();

        String low_limit = "1";

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                .selectProcess(demoProcessName)
                .typeName(characteristicName)
                .typeLowSpecLimit(low_limit)
                .submitCreateWithFailure()
                .assertEmptyUslFieldError()
                .backToCharacteristicsList()
                .assertCharacteristicIsNotOnTheList(characteristicName);
    }

}
