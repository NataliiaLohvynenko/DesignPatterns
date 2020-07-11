package command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.List;

public class HomePage {

    private final WebDriver driver;


    //alert Buttons
    @FindBy(css = "div.button-box button.btn-info")
    private WebElement infoBtn;

    @FindBy(css = "div.button-box button.btn-warning")
    private WebElement warnBtn;

    @FindBy(css = "div.button-box button.btn-success")
    private WebElement successBtn;

    @FindBy(css = "div.button-box button.btn-danger")
    private WebElement dangerBtn;


    //notifications
    @FindBy(css = "div.jq-icon-info")
    private WebElement infoAlert;

    @FindBy(css = "div.jq-icon-warning")
    private WebElement warnAlert;

    @FindBy(css = "div.jq-icon-success")
    private WebElement successAlert;

    @FindBy(css = "div.jq-icon-error")
    private WebElement dangerAlert;

    //dismissal Alert
    @FindBy(css = "div div div:nth-child(3) div div div div div:nth-child(2) div.alert-info")
    private WebElement dismissInfoAlert;

    @FindBy(css = "div div div:nth-child(3) div div div div div:nth-child(2) div.alert-warning")
    private WebElement dismissWarnAlert;

    @FindBy(css = "div div div:nth-child(3) div div div div div:nth-child(2) div.alert-success")
    private WebElement dismissSuccessAlert;

    @FindBy(css = "div div div:nth-child(3) div div div div div:nth-child(2) div.alert-danger")
    private WebElement dismissDangerAlert;


    public HomePage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void gotTo(){
        this.driver.get("https://www.wrappixel.com/demos/admin-templates/admin-pro/main/ui-notification.html");
        driver.manage().window().maximize();
    }

    public List<ElementValidator> getElementValidators(){
        return Arrays.asList(
                //notofication
                new NotificationValidator(infoBtn, infoAlert),
                new NotificationValidator(warnBtn, warnAlert),
                new NotificationValidator(successBtn, successAlert),
                new NotificationValidator(dangerBtn, dangerAlert),
                //dismiss
                new DismissalAlertValisator(dismissInfoAlert),
                new DismissalAlertValisator(dismissSuccessAlert),
                new DismissalAlertValisator(dismissWarnAlert),
                new DismissalAlertValisator(dismissDangerAlert)
        );
    }
}
