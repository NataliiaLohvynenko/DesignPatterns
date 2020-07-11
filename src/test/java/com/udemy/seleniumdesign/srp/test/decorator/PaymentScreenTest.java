package com.udemy.seleniumdesign.srp.test.decorator;

import com.udemy.seleniumdesign.srp.test.BaseTest;
import decorator.PaymentScreenPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;
import java.util.function.Consumer;

import static com.udemy.seleniumdesign.srp.test.decorator.PaymentDecorator.*;

public class PaymentScreenTest  extends BaseTest {

    private PaymentScreenPage paymentScreenPage;

    @BeforeTest
    public void setPage(){
        paymentScreenPage = new PaymentScreenPage(driver);

    }

    @Test(dataProvider = "getData")
    public void paymentScreenPageTest(Consumer<PaymentScreenPage> consumer){
        paymentScreenPage.goTo();
        consumer.accept(paymentScreenPage);
    }

    @DataProvider
    public Object[]getData(){
        return new Object[]{
                validCc.andThen(buy).andThen(successful),
                freeCoupon.andThen(validCc).andThen(buy).andThen(successful),
                buy.andThen(failed)


        };

    }

}
