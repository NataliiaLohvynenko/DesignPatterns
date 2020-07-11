package com.udemy.seleniumdesign.srp.test.command;

import com.udemy.seleniumdesign.srp.test.BaseTest;
import command.HomePage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeTest
    public void setHomePage(){
        this.homePage = new
                HomePage(driver);
    }

    @Test
    public void HomePageTest(){
        this.homePage.gotTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));


    }
}
