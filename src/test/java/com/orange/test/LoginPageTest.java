package com.orange.test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {



    @Test
    public void unsuccessfulLogin(){
        LoginPage loginPageObj= new LoginPage(driver);
        String invalidCredentialAlert=loginPageObj.
                load().
                enterUserName("admin123").
                enterPassword("pass").
                clickSubmitUnsuccessful();
        Assert.assertEquals(invalidCredentialAlert, "Invalid credentials");
    }

//    @Test
//    public void successfulLogin(){
//        LoginPage loginPageObj=new LoginPage(driver);
//        DashboardPage dashboardPageObj=loginPageObj.
//                load().
//                enterUserName("Admin").
//                enterPassword("admin123").
//                clickSubmit();
//    }
}
