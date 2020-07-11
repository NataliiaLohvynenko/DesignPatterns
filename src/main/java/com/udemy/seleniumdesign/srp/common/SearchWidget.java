package com.udemy.seleniumdesign.srp.common;

import com.google.common.util.concurrent.Uninterruptibles;
import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {

    @FindBy(name = "q")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver){
        super(driver);
    }

 public void enter(String keyWord){
        this.searchBox.clear();
        for (char ch: keyWord.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MICROSECONDS);
            this.searchBox.sendKeys(ch+"");
        }

 }

    @Override
    public boolean isDesplayd() {

        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}
