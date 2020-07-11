package command;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class NotificationValidator extends ElementValidator {
    private WebElement button;
    private WebElement notification;

    public NotificationValidator(final WebElement button, final WebElement notification){
        this.button=button;
        this.notification = notification;
    }


    @Override
    public boolean validate() {

        this.button.click();
        boolean appearenceState = this.notification.isDisplayed();
        Uninterruptibles.sleepUninterruptibly(10, TimeUnit.SECONDS);
       boolean dissapearenceState = this.notification.isDisplayed();
       return appearenceState && (!dissapearenceState);
    }
}
