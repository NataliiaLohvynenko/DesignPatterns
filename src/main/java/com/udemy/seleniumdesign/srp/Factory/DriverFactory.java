package com.udemy.seleniumdesign.srp.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

import static com.udemy.seleniumdesign.srp.Factory.Browser.*;

public class DriverFactory {


    private static WebDriver driver;
    final static String DRIVER_PATH = "src/test/resources/";

    public static WebDriver getDriver(Browser browser){

        File file;

        switch (browser){
            case EDGE:
                file = new File(DRIVER_PATH + "IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver",file.getAbsolutePath());
                driver = new InternetExplorerDriver();
                break;
            case CROME:
                file = new File("D:\\education\\drivers\\chromedriver.exe");
                System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                file = new File(DRIVER_PATH+"geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
                driver = new FirefoxDriver();
                break;

        }

        return driver;
    }

}
