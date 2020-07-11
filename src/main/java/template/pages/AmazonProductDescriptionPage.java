package template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonProductDescriptionPage {

    private WebDriverWait wait;
    private WebDriver driver;


    @FindBy(id = "acrCustomerReviewText")
    private WebElement price;

    public AmazonProductDescriptionPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void buy() {
        wait.until((d)->this.price.isDisplayed());
        System.out.println(price.getText());
    }

}
