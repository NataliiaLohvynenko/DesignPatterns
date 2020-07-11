package command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class DismissalAlertValisator extends ElementValidator {

 private final WebElement dismissalAlert;

 public DismissalAlertValisator(final WebElement element){
     this.dismissalAlert=element;
 }

    @Override
    public boolean validate() {

     boolean result1 = this.dismissalAlert.isDisplayed();
     this.dismissalAlert.findElement(By.cssSelector("button.close")).click();
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
       // int result2 = Assert.assertEquals(0,dismissalAlert.getSize());
        boolean result2;
        try {
      result2 = this.dismissalAlert.isDisplayed();

        } catch (org.openqa.selenium.NoSuchElementException e) {
            result2 = false;
        }return result1  && (!result2);
    }
}
