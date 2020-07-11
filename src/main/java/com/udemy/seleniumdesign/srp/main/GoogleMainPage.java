package com.udemy.seleniumdesign.srp.main;

import com.udemy.seleniumdesign.srp.Factory.GoogleMainPageFactory;
import com.udemy.seleniumdesign.srp.Factory.GooglePage;
import com.udemy.seleniumdesign.srp.common.SearchSuggestion;
import com.udemy.seleniumdesign.srp.common.SearchWidget;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class GoogleMainPage {

    private WebDriver driver;

    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private GoogleMainPageFactory factory;

    public  GoogleMainPage(final WebDriver driver){
        this.driver = driver;
        this.searchSuggestion = PageFactory.initElements(driver,SearchSuggestion.class);
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
    }


    public void getGooglePage(GooglePage googlePage, WebDriver driver) {
        factory = new GoogleMainPageFactory(driver);
        factory.goTo(googlePage);

    }


    /* public void goTo(){
        this.driver.get("https://www.google.com/");
    }*/

    public SearchWidget getSearchWidget(){
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }


}
