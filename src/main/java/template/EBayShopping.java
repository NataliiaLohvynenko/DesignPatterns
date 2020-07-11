package template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EBayShopping extends ShoppingTemlate {
    private WebDriver driver;
    private WebDriverWait wait;
    private String product;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchBtn;

    @FindBy(css = "h3.lvtitle a")
    private WebElement item;

    @FindBy(id = "prcIsum_bidPrice")
    private WebElement price;

    public EBayShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }


    @Override
    public void launchSide() {
        this.driver.get("https://www.ebay.pl/");

    }

    @Override
    public void searchForProduct() {
        searchBox.sendKeys(product);
        searchBtn.click();


    }

    @Override
    public void selecProduct() {
        wait.until((d)->this.item.isDisplayed());
        this.item.click();

    }

    @Override
    public void buy() {
        wait.until((d)->price.isDisplayed());
        System.out.println(price.getText());

    }
}
