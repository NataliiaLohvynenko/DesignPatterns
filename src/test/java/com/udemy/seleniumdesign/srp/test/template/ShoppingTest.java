package com.udemy.seleniumdesign.srp.test.template;

import com.udemy.seleniumdesign.srp.test.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import template.AmazonShopigClass;
import template.EBayShopping;
import template.ShoppingTemlate;

public class ShoppingTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemlate shoppingTemlate){
        shoppingTemlate.shop();


    }

    @DataProvider
    public Object[]getData(){
        return new Object[]{
                new AmazonShopigClass(driver,"iphone"),
                new EBayShopping(driver,"iphone")
        };
    }
}
