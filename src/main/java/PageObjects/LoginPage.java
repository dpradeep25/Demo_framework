package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // ================== Locators ==================

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;

   @FindBy(xpath = "//p[contains(@class,'oxd-alert-content-text')]")
    private WebElement errorMessage;

   @FindBy(xpath = "//h5[text()='Login']")
   private WebElement loginPageHeader;

    // ================== Actions ==================

    public boolean isLoginPageDisplayed() {
        return loginPageHeader.isDisplayed();
   }

    public void enterUsername(String username) {
     //   usernameInput.clear();
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password) {
    //    passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void clickLogin() {
        loginButton.click();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    public String getErrorMessage() {
       return errorMessage.getText();
    }
}
