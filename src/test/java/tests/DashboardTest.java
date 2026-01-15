package tests;


import org.testng.annotations.Test;


import Base.BaseTestWithLogin;

import PageObjects.DashboardPage;


public class DashboardTest extends BaseTestWithLogin {

	  

	@Test
    public void verifyDashboard() throws InterruptedException  {
    	
		 DashboardPage DashboardPage = new DashboardPage(getDriver());
       
		 
       // System.out.println(DashboardPage.isDashboardVisible());
        if(DashboardPage.isDashboardVisible() == true ){
        	System.out.println("Dashboard is visible");
        }
        else{
        	System.out.println("Dashboard is not visible");
        }
        Thread.sleep(10000);
        ;
           }
}

