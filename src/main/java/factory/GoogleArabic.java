package factory;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

class GoogleArabic  extends GoogleEnglish{


     @FindBy(css = "span.hOoLGe")
     private WebElement keyboardBtn;

     @FindBy(id = "kbd")
    private WebElement keyboard;

     @FindBy(css = "input.gNO89b")
     private WebElement searchBtn;

    @FindBy(name = "q")
    private WebElement searchBox;

    @FindBy(css = "div.vk-t-btns")
    private WebElement closeKeyboard;


    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSide() {
        this.driver.get("https://www.google.com.sa");
    }

    @Override
    public void searh(String keyword) {
        this.wait.until((d)->this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((d)->this.keyboard.isDisplayed());
       // super.searh(keyword);
        for (char ch: keyword.toCharArray()){
            Uninterruptibles.sleepUninterruptibly(20, TimeUnit.MICROSECONDS);
            this.searchBox.sendKeys(ch+"");
        }

        closeKeyboard.click();
        //this.searchBox.sendKeys(keyword);
        this.searchBtn.click();
    }
}
