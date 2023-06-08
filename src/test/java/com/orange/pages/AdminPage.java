package com.orange.pages;

import com.orange.base.BasePage;
import com.orange.base.BaseTest;
import com.orange.objects.NewUserDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPage extends BasePage {
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    private final By addBtn= By.xpath("//button[normalize-space()='Add']");

    private final By empName= By.xpath("//input[@placeholder='Type for hints...']");

    private final By empNameSuggestion= By.xpath("//div[@role='listbox']//span");

    private final By usrName= By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");

    private final By password= By.xpath("(//input[@type='password'])[1]");

    private final By cnfPassword= By.xpath("(//input[@type='password'])[2]");

    private final By userRole= By.xpath("(//div[@class= 'oxd-select-text-input'])[1]");

    private final By status= By.xpath("(//div[@class= 'oxd-select-text-input'])[2]");

    private final By saveBtn= By.xpath("//button[@type='submit']");

    public AdminPage clickAddBtn(){
        shortWait().until(ExpectedConditions.elementToBeClickable(addBtn)).click();
        return this;
    }

    private void jSExecutor(WebDriver driver, By elem, String str){
        ((JavascriptExecutor)driver).executeScript("arguments[0].innerText='"+str+"'", driver.findElement(elem));
    }

    public AdminPage selectUserRole(NewUserDetails newUserDetails){
        shortWait().until(ExpectedConditions.visibilityOfElementLocated(userRole));
        jSExecutor(driver, userRole, newUserDetails.getUserRole());
        return this;
    }

    public AdminPage selectStatus(NewUserDetails newUserDetails){
        shortWait().until(ExpectedConditions.visibilityOfElementLocated(status));
        jSExecutor(driver, status, newUserDetails.getStatus());
        return this;
    }

    public AdminPage enterEmpName(NewUserDetails newUserDetails) {
        shortWait().until(ExpectedConditions.visibilityOfElementLocated(empName)).clear();
        driver.findElement(empName).sendKeys(newUserDetails.getEmployeeName());
        shortWait().until(ExpectedConditions.textToBe(empNameSuggestion, newUserDetails.getEmployeeName()));
        driver.findElement(empNameSuggestion).click();
        return this;
    }

    public AdminPage enterUsrName(NewUserDetails newUserDetails){
        shortWait().until(ExpectedConditions.visibilityOfElementLocated(usrName)).clear();
        driver.findElement(usrName).sendKeys(newUserDetails.getUserName());
        return this;
    }

    public AdminPage enterPassword(NewUserDetails newUserDetails) {
//        shortWait().until(ExpectedConditions.elementSelectionStateToBe(password, true));
        driver.findElement(password).sendKeys(newUserDetails.getPassword());
        System.out.println(newUserDetails.getPassword());
        return this;
    }

    public AdminPage enterCnfPassword(NewUserDetails newUserDetails){

//        shortWait().until(ExpectedConditions.elementSelectionStateToBe(cnfPassword, true));
        driver.findElement(cnfPassword).sendKeys(newUserDetails.getCnfPassword());
        return this;
    }

    public AdminPage clickSaveBtn(){
        shortWait().until(ExpectedConditions.elementToBeClickable(saveBtn)).click();
        return this;
    }
}
