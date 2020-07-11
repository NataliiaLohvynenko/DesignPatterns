package com.udemy.seleniumdesign.srp.common;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchSuggestion extends AbstractComponent {

    @FindBy(css = "div.sbtc")
    private List<WebElement> suggestion;


    public SearchSuggestion(final WebDriver driver) {
        super(driver);

    }

    public void clickSuggestionByIndex(int Index) {
        this.suggestion.get(Index - 1).click();
    }

    @Override
    public boolean isDesplayd() {
        return this.wait.until((s) -> this.suggestion.size() > 5);
    }
}
