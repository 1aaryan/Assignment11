package com.orange.test;

import com.orange.base.BaseTest;
import com.orange.pages.DashboardPage;
import com.orange.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DashboardPageTest extends BaseTest {

    @Test
    public void validateSuccessfulLogin(){
        LoginPage loginPageObj=new LoginPage(driver);
        DashboardPage dashboardPageObj=loginPageObj.
                load().
                enterUserName("Admin").
                enterPassword("admin123").
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
