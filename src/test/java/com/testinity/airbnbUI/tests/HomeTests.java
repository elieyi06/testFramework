package com.testinity.airbnbUI.tests;

import com.testinity.airbnbUI.core.BaseTest;
import com.testinity.airbnbUI.pages.NavbarPage;
import com.testinity.framework.core.Commonds;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTests extends BaseTest {
    NavbarPage navbarPage;


    @Test(testName = "C0001 Search Test")
    void C0001(){
        newPage();
        navbarPage.search("Erzurum");
    }
    @Test(testName = "C0002 Search Istanbul" )
    void C0002(){
        newPage();
        navbarPage.search("İstanbul");
    }
    @Test(testName = "C0003 Search Istanbul" )
    void C0003(){
        String a = "Istanbul";
        String b = "istanbul";
        boolean sonuc = a.equals(b);
        boolean sonuc1 = a.equalsIgnoreCase(b);

        System.out.println("sonuc = " + sonuc);

        System.out.println("sonuc1 = " + sonuc1);
    }


    void newPage(){
        navbarPage = new NavbarPage(getDriver());
        Commonds.Click(navbarPage.getBtnPopupKapat());

    }
}
