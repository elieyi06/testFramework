package com.testinity.framework.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonTest {
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driver.get();
    }


    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver());
    }

    @AfterMethod
    public void tearDown(){
        getDriver().quit();
    }
}
