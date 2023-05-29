package com.orange.factory;

import com.orange.constants.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    WebDriver driver;
    public WebDriver initializeDriver(String browser){
         switch (BrowserType.valueOf(browser)) {
            case CHROME -> driver=new ChromeDriver();
            case FIREFOX -> driver=new FirefoxDriver();
            default -> throw new IllegalStateException("Please enter a valid browser name" + browser);
        }

        driver.manage().window().maximize();
        return driver;
    }
}
