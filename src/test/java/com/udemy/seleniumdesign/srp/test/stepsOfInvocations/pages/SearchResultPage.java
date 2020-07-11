package com.udemy.seleniumdesign.srp.test.stepsOfInvocations.pages;

import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {
    public SearchResultPage(){
        super();
    }

    @FindBy(className = "LC20lb")
    private WebElement resultRowElement;

    public void assertThatTopResultContainsCorrectText(String expected){
        assertThat(resultRowElement.isDisplayed()).as("Element has not been displayed").isTrue();
        assertThat(resultRowElement.getText()).as("wrong text has been displayed").containsIgnoringCase(expected);

    }

    public void assertThatTopResultContainsProperAttributeText(String expected){
        assertThat(resultRowElement.getAttribute("class")).as("wrong attribute text").containsIgnoringCase(expected);

    }
}
