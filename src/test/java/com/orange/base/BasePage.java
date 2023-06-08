package com.orange.base;

import com.orange.utils.ConfigLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public WebDriverWait shortWait(){
        wait=new WebDriverWait(driver, Duration.ofSeconds(60));
        return wait;
    }

    public void load(String endpoint)  {
        driver.get( ConfigLoader.getInstance().getUrl() + endpoint);
    }
}
