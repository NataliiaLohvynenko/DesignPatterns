package com.udemy.seleniumdesign.srp.test.stepsOfInvocations.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SearchPageTest extends BaseTest1 {

    @Test(dataProvider = "dataProvider")
    public void openGoogleComInChromeTest1(String text) {
/*
        SearchPage searchPage = new SearchPage();
        searchPage.fillSearchField(text);
        searchPage.pressEnter();
        SearchResultPage  searchResultPage = new SearchResultPage();
        searchResultPage.assertThatTopResultContainsCorrectText(text);
        searchResultPage.assertThatTopResultContainsProperAttributeText("LC20lb");*/
        steps.executeBykeyword(text)
                .searchAttributeResult(text)
                .searchTextResult(text);


    }


    @Test
    public void test() throws InterruptedException {

        driver.get("https://mvnrepository.com/search?q=AShot");


        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement e = driver.findElement(By.xpath("//div[7]//div[1]//h2[1]//a[1]"));
       // js.executeScript("alert('Hello World!');");

       // js.executeScript("arguments[0].scrollIntoView(true);",e);
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });",e);
        Thread.sleep(3000);
    }


    @DataProvider(name = "dataProvider")
    public Object[][] dataProviderMethod() {

        return new Object[][]{{"Selenium"}, {"javascript"}};
    }

}
