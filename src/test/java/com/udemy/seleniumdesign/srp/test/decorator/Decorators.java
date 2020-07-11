package com.udemy.seleniumdesign.srp.test.decorator;

import decorator.DashboardPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;
import java.util.function.Consumer;

public class Decorators {

    private static void shouldDisplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertTrue(element.isDisplayed()));
    }

    private static void shouldNotDesplay(List<WebElement> elements) {
        elements.forEach(element -> Assert.assertFalse(element.isDisplayed()));
    }

    //ingridients

    private static final Consumer<DashboardPage> adminComponentPresent = (dp) -> shouldDisplay((dp).getAdminComponents());
    private static final Consumer<DashboardPage> adminComponentNotPresent = (dp) -> shouldNotDesplay((dp).getAdminComponents());

    private static final Consumer<DashboardPage> suComponentPresent = (dp) -> shouldDisplay((dp).getSuoerUserComponents());
    private static final Consumer<DashboardPage> suComponentNotPresent = (dp) -> shouldNotDesplay((dp).getSuoerUserComponents());

    private static final Consumer<DashboardPage> guestComponentPresent = (dp) -> shouldDisplay((dp).getGuestComponents());
    private static final Consumer<DashboardPage> guestComponentNotPresent = (dp) -> shouldNotDesplay((dp).getGuestComponents());


    //roleSelection

    private static final Consumer<DashboardPage> adminSelection = (dp) -> dp.selectRole("admin");
    private static final Consumer<DashboardPage> suSelector = (dp) -> dp.selectRole("superuser");
    private static final Consumer<DashboardPage> guestSelector = (dp) -> dp.selectRole("guest");

    //user role pages

    public static final Consumer<DashboardPage> guestPage = guestSelector
            .andThen(guestComponentPresent)
            .andThen(suComponentNotPresent)
            .andThen(adminComponentNotPresent);

    public static final Consumer<DashboardPage> suPage = suSelector
            .andThen(guestComponentPresent)
            .andThen(suComponentPresent)
            .andThen(adminComponentNotPresent);

    public static final Consumer<DashboardPage> adminPage = adminSelection
            .andThen(guestComponentPresent)
            .andThen(suComponentPresent)
            .andThen(adminComponentPresent);
}
