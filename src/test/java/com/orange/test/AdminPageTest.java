package com.orange.test;

import com.orange.base.BaseTest;
import com.orange.objects.NewUserDetails;
import com.orange.pages.AdminPage;
import com.orange.pages.LoginPage;
import com.orange.utils.ConfigLoader;
import com.orange.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AdminPageTest extends BaseTest {


    @Test
    public void clickOnAdmin() throws IOException, InterruptedException {
        AdminPage adminPageObj= new LoginPage(driver).
                load().
                enterUserName(ConfigLoader.getInstance().getUserName()).
                enterPassword(ConfigLoader.getInstance().getPassword()).
                clickSubmit().
                clickAdmin();
        NewUserDetails newUserDetailsObj=JacksonUtils.deserializeJson("userDetails.json", NewUserDetails.class);
        adminPageObj.
                clickAddBtn().
                selectUserRole(newUserDetailsObj).
                selectStatus(newUserDetailsObj).
                enterEmpName(newUserDetailsObj).
                enterUsrName(newUserDetailsObj).
                enterPassword(newUserDetailsObj).
                enterCnfPassword(newUserDetailsObj).
                clickSaveBtn();

        Assert.assertEquals(adminPageObj.getSuccessMessage(), "Success");


    }
}
