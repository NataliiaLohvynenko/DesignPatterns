package com.udemy.seleniumdesign.srp.test.stepsOfInvocations.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.udemy.seleniumdesign.srp.test.stepsOfInvocations.tests.BaseTest1.getDriver;

public abstract class BasePage {
    WebDriver driver;

    public BasePage() {
        this.driver = getDriver();
        PageFactory.initElements(driver,this);
    }

}
