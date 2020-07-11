package com.udemy.seleniumdesign.srp.test.executearound;

import com.udemy.seleniumdesign.srp.test.BaseTest;
import executeAround.MainPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FrameTes extends BaseTest {

    private MainPage mainPage;

    @BeforeTest
    public void setMainPage(){
        this.mainPage = new MainPage(driver);

    }

    @Test
    public void frameTest(){
        this.mainPage.goTo();

        this.mainPage.onFrameA(a -> {
            a.setFirstName("fn1");
            a.setAddress("dsa2@SDF");
        });

    }
}
