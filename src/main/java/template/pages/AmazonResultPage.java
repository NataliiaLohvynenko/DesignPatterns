package template.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonResultPage {

    private WebDriverWait wait;
    private WebDriver driver;


    @FindBy(css = "span.a-size-medium")
    private WebElement item;

    public AmazonResultPage(WebDriver driver){
        this.driver=driver;
        this.wait = new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selecProduct() {
        this.wait.until((d) -> this.item.isDisplayed());
        item.click();

    }

}
