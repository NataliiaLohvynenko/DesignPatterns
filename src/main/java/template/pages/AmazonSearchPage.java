package template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonSearchPage {

    private WebDriver driver;
    String product;


    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchbox;

    @FindBy(xpath = "//div/input[@type='submit']")
    private WebElement searchBtn;

    public AmazonSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);

    }

    public void goTo() {
        this.driver.get("https://www.amazon.com/");

    }

    public void search(String product) {
        this.searchbox.sendKeys(product);
        this.searchBtn.click();
    }

}
