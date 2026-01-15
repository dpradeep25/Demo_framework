package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    WebDriver driver;

    // Constructor
    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================== Locators ==================

    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']")
    private WebElement headerTitle;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

   @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement errorMessage;

   @FindBy(xpath = "//h5[text()='Login']")
   private WebElement loginPageHeader;

    // ================== Actions ==================

    public boolean isDashboardVisible() {
        return headerTitle.isDisplayed();
   }

 
}
