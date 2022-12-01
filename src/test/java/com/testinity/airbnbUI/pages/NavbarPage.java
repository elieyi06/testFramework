package com.testinity.airbnbUI.pages;

import com.testinity.framework.core.CommonTest;
import com.testinity.framework.core.Commonds;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class NavbarPage {
    /**************** Page Elements ****************/
    @FindBy(xpath = "//input[@data-testid='structured-search-input-field-query']")
    private WebElement inputSearch;
    @FindBy(xpath = "//div[@data-testid='little-search-icon']")
    private WebElement iconSearch;
    @FindBy(xpath = "//button[@data-testid='structured-search-input-search-button']")
    private WebElement btnSearch;
    @FindBy(css = "button[aria-label='Kapat']")
    private WebElement btnPopupKapat;



    public NavbarPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }


    /**************** Constructor ****************/


    /**************** Page Methods ****************/

    public void search(String str){
        Commonds.Click(getIconSearch());
        Commonds.SendKeysWithAction(getInputSearch(),str);
        Commonds.Click(getBtnSearch());
        new WebDriverWait(CommonTest.getDriver(), Duration.ofSeconds(30)).until(ExpectedConditions.titleContains(str));
    }
}
