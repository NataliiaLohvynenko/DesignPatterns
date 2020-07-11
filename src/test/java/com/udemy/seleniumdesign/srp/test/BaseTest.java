package com.udemy.seleniumdesign.srp.test;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.srp.Factory.Browser;
import com.udemy.seleniumdesign.srp.Factory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

import static com.udemy.seleniumdesign.srp.Factory.Browser.CROME;

public class BaseTest {

    protected WebDriver driver;
    private Browser browser;
    //private GoogleMainPage googleMainPage;


    @BeforeTest
    protected void setupDriver(){

        driver=DriverFactory.getDriver(CROME);

    }



    @AfterTest

    public void quitDriver(){
        Uninterruptibles.sleepUninterruptibly(3, TimeUnit.SECONDS);
        this.driver.quit();
    }
}
