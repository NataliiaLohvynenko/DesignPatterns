package proxi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Map;

public class PaymentScreen {

    private WebDriver driver;
    private UserInformaton userInformaton;
    private OrderComponent orderComponent;
    private PaymentOption paymentOption;

    public PaymentScreen(final WebDriver driver){
        this.driver = driver;
        this.userInformaton = PageFactory.initElements(driver, UserInformaton.class);
        this.orderComponent=new OrderComponentProxi(driver);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }


    public UserInformaton getUserInformaton(){
        return userInformaton;
    }

    public OrderComponent getOrder(){
        return orderComponent;
    }

    public void setPaymentOption(PaymentOption paymentOption){
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public void pay(Map<String, String> paymentDetails){

        this.paymentOption.enterPaymentInformation(paymentDetails);
    }


}
