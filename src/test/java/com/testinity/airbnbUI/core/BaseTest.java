package com.testinity.airbnbUI.core;

import com.testinity.framework.core.CommonTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest extends CommonTest {
    @BeforeMethod
    public static void start(){
        WebDriver driver = getDriver();
        driver.get("https://www.airbnb.com.tr/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void end(){

    }


}
