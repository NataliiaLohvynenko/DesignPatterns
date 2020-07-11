package factory;

import org.openqa.selenium.WebDriver;

 class GoggleFrench extends GoogleEnglish {


    public GoggleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSide() {
        this.driver.get("https://www.google.fr/");
    }

 }
