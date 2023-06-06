package com.orange.pages;

import com.orange.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    //just a change

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By userNameFld=By.xpath("//input[@placeholder='Username']");

    private final By passwordFld= By.xpath("//input[@placeholder='Password']");

    private final By loginBtn= By.xpath("//button[@type='submit']");

    private final By invalidCredential=By.xpath("//div[@role='alert']//p");

    public LoginPage enterUserName(String username){
        shortWait().until(ExpectedConditions.visibilityOfElementLocated(userNameFld)).clear();
        driver.findElement(userNameFld).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password){
        shortWait().until(ExpectedConditions.visibilityOfElementLocated(passwordFld)).clear();
        driver.findElement(passwordFld).sendKeys(password);
        return this;
    }

    public DashboardPage clickSubmit(){
        shortWait().until(ExpectedConditions.elementToBeClickable(loginBtn)).click();
        return new DashboardPage(driver);
    }

    public String clickSubmitUnsuccessful(){
        shortWait().until(ExpectedConditions.visibilityOfElementLocated(loginBtn)).click();
        return invalidCredentialsAlert();
    }

    public String invalidCredentialsAlert(){
        return shortWait().until(ExpectedConditions.visibilityOfElementLocated(invalidCredential)).getText();
//        return driver.findElement(invalidCredential).getText();
    }

    public LoginPage load(){
        load("/");
        return this;
    }

}
