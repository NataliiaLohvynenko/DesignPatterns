package com.udemy.seleniumdesign.srp.Factory;

import org.openqa.selenium.WebDriver;

public class GoogleMainPageFactory {

    private static WebDriver driver;


    public GoogleMainPageFactory(final WebDriver driver){
        this.driver = driver;
    }

     public void goTo(GooglePage googlePage){

         switch (googlePage)
         {
             case ARABIC:
                 driver.get("https://www.google.com.sa/");
                 break;
             case POLISH:
                 driver.get("https://www.google.com.pl/");
                 break;
             case ENGLISH:
                 driver.get("https://www.google.com/");
                 break;
         }

    }

}
