package factory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public abstract class GooglPage {

    public abstract void  launchSide();
    public abstract void searh(String keyword);
    public abstract int gtResultsCount();
}
