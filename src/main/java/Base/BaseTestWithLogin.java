package Base;

import org.testng.annotations.BeforeClass;

import Config.PropertyReader;
import PageObjects.LoginPage;



public class BaseTestWithLogin extends BaseTest {

    @BeforeClass(alwaysRun = true)
    public void loginOnce() {

    	 LoginPage loginPage = new LoginPage(getDriver());

    	 String username =
                 PropertyReader.get("config/login.properties", "Username");
             String password =
                 PropertyReader.get("config/login.properties", "Password");

        loginPage.login(username, password);
    }
}