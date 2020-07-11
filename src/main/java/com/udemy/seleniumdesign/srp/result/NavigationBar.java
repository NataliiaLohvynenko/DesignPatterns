package com.udemy.seleniumdesign.srp.result;

import com.udemy.seleniumdesign.srp.common.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NavigationBar extends AbstractComponent {


    @FindBy(id = "hdtb")
    private WebElement bar;

    @FindBy(linkText = "Картинки")
    private WebElement images;

    @FindBy(linkText = "Новости")
    private WebElement news;

    @FindBy(xpath = "//*[@id=\"ow16\"]/a/span")
    private WebElement moreButton;


    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void clickMoreButton() {
        this.moreButton.click();
    }

    public void goToNews(){
        this.news.click();
    }

    public void goToImages(){
        this.images.click();
    }

    public WebElement getNews(){
        return news;
    }
    @Override
    public boolean isDesplayd() {
        return this.wait.until((d)->this.bar.isDisplayed());
    }
}
