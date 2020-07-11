package factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

class GoogleEnglish extends GooglPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(name = "btnK")
    private WebElement searchBtn;

    @FindBy(css = "div.rc")
    private List<WebElement> result;

    GoogleEnglish(final WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    @Override
    public void launchSide() {
        this.driver.get("https://www.google.com/");
    }

    @Override
    public void searh(String keyword) {
        for (char ch: keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MICROSECONDS);
            this.searchBox.sendKeys(ch+"");
        }
        //this.searchBox.sendKeys(keyword);
        this.searchBtn.click();
    }

    @Override
    public int gtResultsCount() {
        this.wait.until((d)->result.size()>1);
        return result.size();
    }
}
