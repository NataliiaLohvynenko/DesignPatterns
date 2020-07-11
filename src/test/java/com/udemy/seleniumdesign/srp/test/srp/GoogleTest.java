package com.udemy.seleniumdesign.srp.test.srp;

import com.udemy.seleniumdesign.srp.Factory.GooglePage;
import com.udemy.seleniumdesign.srp.main.GoogleMainPage;
import com.udemy.seleniumdesign.srp.result.GoogleResultPage;
import com.udemy.seleniumdesign.srp.test.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.udemy.seleniumdesign.srp.Factory.GooglePage.*;

public class GoogleTest extends BaseTest {

    private GoogleMainPage googleMainPage;
    private GoogleResultPage googleResultPage;


    @BeforeTest

    public void setupPage(){
        this.googleMainPage = new GoogleMainPage(driver);
        this.googleResultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getData")
    public void googleWorkflow(String keyword, int index){

        /*String keyword = "selenium webdriver";
        int index = 2;*/

        googleMainPage.getGooglePage(POLISH,driver);
        Assert.assertTrue(googleMainPage.getSearchWidget().isDesplayd());

        googleMainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleMainPage.getSearchSuggestion().isDesplayd());

        googleMainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDesplayd());

        googleResultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(googleResultPage.getSearchWidget().isDesplayd());

        googleResultPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(googleResultPage.getNavigationBar().isDesplayd());

        System.out.println(googleResultPage.getResultStat().getStat());
        googleResultPage.getNavigationBar().goToImages();


    }

    @DataProvider
    public Object[][] getData(){

        return new Object[][]{
                {"selenium",3},
                {"docker",2}};
    }
}
