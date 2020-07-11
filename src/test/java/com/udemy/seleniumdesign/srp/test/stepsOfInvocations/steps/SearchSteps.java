package com.udemy.seleniumdesign.srp.test.stepsOfInvocations.steps;

import com.udemy.seleniumdesign.srp.test.stepsOfInvocations.pages.SearchPage;

public class SearchSteps {
    private SearchPage searchPage = new SearchPage();

    public SearchResultSteps executeBykeyword(String text) {
        searchPage.fillSearchField(text);
        searchPage.pressEnter();
        return new SearchResultSteps();
    }
}
