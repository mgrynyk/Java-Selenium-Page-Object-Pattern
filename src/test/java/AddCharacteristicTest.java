
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Utilities;

public class AddCharacteristicTest extends SeleniumBaseTest {
    @DataProvider
    public static Object[][] getCharacteristicsParameters() {
        return new Object[][]{
                {new Utilities().generateRandomName(), "1", "3", "4"},
                {new Utilities().generateRandomName(), "2", "5",  "7"}
        };
    }
    @Test(dataProvider = "getCharacteristicsParameters")
    public void addCharacteristic_Test(String characteristicName, String low_limit, String up_limit, String bin_count) {

        new LoginPage(driver)
                .typeEmail(user)
                .typePassword(password)
                .submitLogin()
                .goToCharacteristics()
                .clickAddCharacteristic()
                .selectProcess(demoProcessName)
                .typeName(characteristicName)
                .typeUpSpecLimit(up_limit)
                .typeLowSpecLimit(low_limit)
                .typeBinCount(bin_count)
                .submitCreate()
                .assertCharacteristicOnTheList(characteristicName, up_limit, low_limit, bin_count);
    }
}
