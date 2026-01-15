package tests;

import org.testng.annotations.Test;

import Base.BaseTest;
import Config.PropertyReader;
import PageObjects.LoginPage;

public class LoginTest extends BaseTest {

   
    @Test
    
    public void verifyInvalidLogin() {

        
   	 LoginPage loginPage = new LoginPage(getDriver());

           String username =
               PropertyReader.get("config/login.properties", "Incorrect");
           String password =
               PropertyReader.get("config/login.properties", "Password");

           loginPage.login(username, password);
          
          System.out.println(loginPage.getErrorMessage());
        
          assert loginPage.getErrorMessage().equals("Invalid credentials");
          }
    @Test
    public void verifyValidLogin() throws InterruptedException {

       
    	 LoginPage loginPage = new LoginPage(getDriver());

            String username =
                PropertyReader.get("config/login.properties", "Username");
            String password =
                PropertyReader.get("config/login.properties", "Password");

            loginPage.login(username, password);
            Thread.sleep(10000);
           }
}

