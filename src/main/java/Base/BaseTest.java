package Base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import Config.PropertyReader;
import Driver.DriverFactory;

public class BaseTest {

    @Parameters("browser")
    @BeforeClass(alwaysRun = true)
    public void setUp(String browser) {

        DriverFactory.initDriver(browser);

        String url = PropertyReader.get("config/config.properties", "url");
        DriverFactory.getDriver().get(url);
    }

    // ✅ ONLY THIS METHOD — NO driver variable
    protected WebDriver getDriver() {
        return DriverFactory.getDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}
