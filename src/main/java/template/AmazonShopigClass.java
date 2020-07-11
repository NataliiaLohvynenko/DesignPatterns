package template;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import template.pages.AmazonProductDescriptionPage;
import template.pages.AmazonResultPage;
import template.pages.AmazonSearchPage;

public class AmazonShopigClass extends ShoppingTemlate {

    private WebDriver driver;
    private String product;

    private AmazonSearchPage amazonSearchPage;
    private AmazonResultPage amazonResultPage;
    private AmazonProductDescriptionPage amazonProductDescriptionPage;


    public AmazonShopigClass(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultPage = PageFactory.initElements(driver, AmazonResultPage.class);
        this.amazonProductDescriptionPage = PageFactory.initElements(driver, AmazonProductDescriptionPage.class);

    }


    @Override
    public void launchSide() {
        this.amazonSearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.search(this.product);
    }

    @Override
    public void selecProduct() {
        this.amazonResultPage.selecProduct();
    }

    @Override
    public void buy() {
        this.amazonProductDescriptionPage.buy();
    }
}
