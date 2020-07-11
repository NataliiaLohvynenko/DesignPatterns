package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

class GoogleEs extends GoogleEnglish {
    public GoogleEs(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSide(){
        driver.get("https://www.google.es");
    }


}
