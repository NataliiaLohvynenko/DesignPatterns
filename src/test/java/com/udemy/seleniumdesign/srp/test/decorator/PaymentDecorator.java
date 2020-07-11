package com.udemy.seleniumdesign.srp.test.decorator;

import decorator.PaymentScreenPage;
import org.testng.Assert;
import proxi.PaymentScreen;

import java.util.function.Consumer;

public class PaymentDecorator {

    public static final Consumer<PaymentScreenPage> freeCoupon = (p)->p.aplpyPromocode("FREEUDEMY");
    public static final Consumer<PaymentScreenPage> discountCoupon = (p)-> p.aplpyPromocode("PARTIALUDEMY");
    public static final Consumer<PaymentScreenPage> validCc = (p)->p.enterCC("4111111111111111", "2023","123");
    public static final Consumer<PaymentScreenPage> invalidCc = (p)->p.enterCC("4111111111111111", "2021","123");
    public static final Consumer<PaymentScreenPage> buy = (p)->p.buy();


    public static final Consumer<PaymentScreenPage> successful = (p)-> Assert.assertEquals(p.getStatus(),"PASS");
    public static final Consumer<PaymentScreenPage>failed = (p)->Assert.assertEquals(p.getStatus(),"FAIL");
}
