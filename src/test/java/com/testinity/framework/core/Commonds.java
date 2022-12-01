package com.testinity.framework.core;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Commonds {

    public static void Click(WebElement element){
        WaitUntilVisible(element);
        WaitUntilClickable(element);
        ScrollToElement(element);
        MoveMouseToElement(element);
        try {
            element.click();
        }catch (Exception e){
            JavascriptExecutor jse = (JavascriptExecutor)CommonTest.getDriver();
            jse.executeScript("arguments[0].click();",element);
        }

    }
    public static void SendKeys(WebElement element,String str){
        WaitUntilVisible(element);
        ScrollToElement(element);
        ClearArea(element);
        try {
            element.sendKeys();
        }catch (Exception e){
            JavascriptExecutor jse = (JavascriptExecutor)CommonTest.getDriver();
            jse.executeScript("arguments[0].value='"+str+"'",element);
        }
    }

    public static void SendKeysWithAction(WebElement element,String str){
        WaitUntilVisible(element);
        ScrollToElement(element);
        ClearArea(element);
        Actions actions = new Actions(CommonTest.getDriver());
        Action action = actions.moveToElement(element)
                .click()
                .sendKeys(str)
                .build();
        action.perform();

    }

    public static void Delay(int second){
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void ClearArea(WebElement element){
        element.clear();
        element.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));

    }
    public static void WaitUntilVisible(WebElement element){
        new WebDriverWait(CommonTest.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOf(element));
    }
    public static void WaitUntilClickable(WebElement element){
        new WebDriverWait(CommonTest.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(element));

    }
    public static void ScrollToElement(WebElement element){
        Actions actions = new Actions(CommonTest.getDriver());
        Action action = actions.scrollToElement(element).build();
        action.perform();
    }
    public static void MoveMouseToElement(WebElement element){
        Actions actions = new Actions(CommonTest.getDriver());
        Action action = actions.moveToElement(element).build();
        action.perform();
    }


}
