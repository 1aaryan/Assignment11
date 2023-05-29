package com.orange.pages;

import com.orange.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DashboardPage extends BasePage {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private final By timeAtWork= By.xpath("//p[normalize-space()='Time at Work']");

    private final By myActions= By.xpath("//p[normalize-space()='My Actions']");

    private final By quickLaunch= By.xpath("//p[normalize-space()='Quick Launch']");

    private final By buzzLatestPosts= By.xpath("//p[normalize-space()='Buzz Latest Posts']");

    private final By employeesOnLeave= By.xpath("//p[normalize-space()='Employees on Leave Today']");

    private final By employeeDistribution= By.xpath("//p[normalize-space()='Employee Distribution by Sub Unit']");

    private final By adminLink= By.xpath("//li[1]//a[1]//span[1]");

    public String timeAtWorkText(){
        return shortWait().until(ExpectedConditions.visibilityOfElementLocated(timeAtWork)).getText();
    }

    public String myActionsText(){
        return shortWait().until(ExpectedConditions.visibilityOfElementLocated(myActions)).getText();
    }

    public String quickLaunchText(){
        return shortWait().until(ExpectedConditions.visibilityOfElementLocated(quickLaunch)).getText();
    }

    public String buzzLatestPostsText(){
        return shortWait().until(ExpectedConditions.visibilityOfElementLocated(buzzLatestPosts)).getText();
    }

    public String employeesOnLeaveText(){
        return shortWait().until(ExpectedConditions.visibilityOfElementLocated(employeesOnLeave)).getText();
    }

    public String employeeDistributionText(){
        return shortWait().until(ExpectedConditions.visibilityOfElementLocated(employeeDistribution)).getText();
    }

    public AdminPage clickAdmin(){
        shortWait().until(ExpectedConditions.visibilityOfElementLocated(adminLink)).click();
        return new AdminPage(driver);
    }

}
