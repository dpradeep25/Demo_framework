package Driver;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public final class DriverFactory {

    // Thread-safe WebDriver
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private DriverFactory() {
        // Prevent object creation
    }

    public static void initDriver(String browser) {

        if (driver.get() == null) {

            switch (browser.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;

                default:
                    throw new RuntimeException("Invalid browser: " + browser);
            }

            // Common browser setup
            driver.get().manage().window().maximize();
            driver.get().manage().timeouts()
                    .implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
