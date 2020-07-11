package com.udemy.seleniumdesign.srp.test.stratagy;

import com.udemy.seleniumdesign.srp.test.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;
import strategy.PaymentOptionFactory;
import strategy.PaymentScreen;

import java.util.Map;

public class PaymentScreenTest extends BaseTest {


    private PaymentScreen paymentScreen;

    @BeforeTest
    public void setPaymentScreen(){

        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String paymentOption, Map<String, String> pamentDetails){
     this.paymentScreen.goTo();
     this.paymentScreen.getUserInformaton().enterDetails("vinoth", "tst lam", "test@email");
     this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(paymentOption));
     this.paymentScreen.pay(pamentDetails);
     String orderNumber = this.paymentScreen.getOrder().placeOrder();
        System.out.println("Order Number: " + orderNumber);
    }

@DataProvider
public  Object[][]getData(){
        Map<String, String> cc= Maps.newHashMap();
        cc.put("cc", "12345");
        cc.put("year", "2013");
        cc.put("cvv","123");

    Map<String, String> nb= Maps.newHashMap();
    nb.put("bank", "BOFA");
    nb.put("account", "myaccouynt123");
    nb.put("pin","999");

        return new Object[][]{
                {"CC",cc},
                {"NB",nb}
        };
}

}
