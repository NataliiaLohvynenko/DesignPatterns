package com.udemy.seleniumdesign.srp.test.factory;

import com.udemy.seleniumdesign.srp.test.BaseTest;
import factory.GooglPage;
import factory.GoogleFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class GoogleSearchTest extends BaseTest {

    private GooglPage googlPage;


    @Test(dataProvider = "getData")
    public void searchTest(String language, String keyword) {

        this.googlPage= GoogleFactory.get(language,this.driver);
        this.googlPage.launchSide();
        this.googlPage.searh(keyword);
        int resultCount = this.googlPage.gtResultsCount();

        System.out.println("Result Count: " + resultCount);
    }
        @DataProvider
        public Object[][] getData(){
            return new Object[][]{
                    {"ENG", "slenium"},
                    {"FR", "webdriver"},
                    {"SA", "design patterns"}
                  //  {"ES","selenium"}
            };
        }
    }

