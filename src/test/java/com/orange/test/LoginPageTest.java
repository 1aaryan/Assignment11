package com.orange.test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;
import com.orange.utils.ConfigLoader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {



    @Test
    public void unsuccessfulLogin(){
        LoginPage loginPageObj= new LoginPage(driver);
        String invalidCredentialAlert=loginPageObj.
                load().
                enterUserName("Admin").
                enterPassword("admin1234").
                clickSubmitUnsuccessful();
        Assert.assertEquals(invalidCredentialAlert, "Invalid credentials");
    }

}
