package com.orange.base;

import com.orange.factory.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

//    public BaseTest(WebDriver driver){
//        this.driver=driver;
//    }

    @BeforeMethod
    public void startDriver(){
        String browser=System.getProperty("browser");
        if(browser==null)browser="CHROME";
        driver=new DriverManager().initializeDriver(browser);
    }

    @AfterMethod
    public void quitDriver(){
        driver.quit();
    }
}
