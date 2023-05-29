package com.orange.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public WebDriverWait shortWait(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(40));
        return wait;
    }

    public void load(String endpoint){
        driver.get("https://opensource-demo.orangehrmlive.com"+ endpoint);
    }
}
