package com.udemy.seleniumdesign.srp.test.stepsOfInvocations.tests;

import com.udemy.seleniumdesign.srp.Factory.Browser;
import com.udemy.seleniumdesign.srp.Factory.DriverFactory;
import com.udemy.seleniumdesign.srp.test.stepsOfInvocations.steps.SearchSteps;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utils.PropertyReader;

import static com.udemy.seleniumdesign.srp.Factory.Browser.CROME;

public class BaseTest1 {


    protected static WebDriver driver;

    SearchSteps steps;

    public static WebDriver getDriver() {

        return driver;

    }


    //private GoogleMainPage googleMainPage;


    @BeforeTest
    protected void setupDriver(){

/*        driver= DriverFactory.getDriver(CROME);
        driver.get("https://www.google.com/");
        steps = new SearchSteps();*/

            driver = DriverFactory.getDriver(PropertyReader.getBrowser());
            driver.get(PropertyReader.getBaseUrl());
            steps = new SearchSteps();


    }

    @AfterClass
    public void TearDown(){
        driver.quit();
    }


    @AfterMethod
    public void Teardown(){
        driver.navigate().back();
    }
}
