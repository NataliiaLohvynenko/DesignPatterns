package com.udemy.seleniumdesign.srp.test.stepsOfInvocations.steps;

import com.udemy.seleniumdesign.srp.test.stepsOfInvocations.pages.SearchResultPage;

public class SearchResultSteps {
   private SearchResultPage searchResultPage = new SearchResultPage();

   public SearchResultSteps searchTextResult(String text){
        searchResultPage.assertThatTopResultContainsCorrectText(text);

       return this;
   }

    public SearchResultSteps searchAttributeResult(String text){


        searchResultPage.assertThatTopResultContainsProperAttributeText("LC20lb");
        return this;
    }
}
