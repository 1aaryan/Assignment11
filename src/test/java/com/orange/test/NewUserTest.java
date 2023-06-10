package com.orange.test;

import com.orange.base.BaseTest;
import com.orange.objects.NewUserDetails;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;
import com.orange.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class NewUserTest extends BaseTest {


    @Test
    public void verifyNewCreatedUser() throws IOException {
        NewUserDetails newUserDetails= JacksonUtils.deserializeJson("userDetails.json", NewUserDetails.class);
        DashboardPage dashboardPageObj=new LoginPage(driver).
                    load().
                    enterUserName(newUserDetails.getUserName()).
                    enterPassword(newUserDetails.getPassword()).
                    clickSubmit();

        String timeAtWork=dashboardPageObj.timeAtWorkText();
        Assert.assertEquals(timeAtWork, "Time at Work");

        String myActions= dashboardPageObj.myActionsText();
        Assert.assertEquals(myActions, "My Actions");

        String quickLaunch= dashboardPageObj.quickLaunchText();
        Assert.assertEquals(quickLaunch, "Quick Launch");

        String buzzLatestPosts= dashboardPageObj.buzzLatestPostsText();
        Assert.assertEquals(buzzLatestPosts, "Buzz Latest Posts");

        String employeesOnLeave= dashboardPageObj.employeesOnLeaveText();
        Assert.assertEquals(employeesOnLeave, "Employees on Leave Today");

        String employeeDistribution= dashboardPageObj.employeeDistributionText();
        Assert.assertEquals(employeeDistribution, "Employee Distribution by Sub Unit");
    }
}
