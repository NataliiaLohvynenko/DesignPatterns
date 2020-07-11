package proxi;

import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class OrderComponentProxi implements OrderComponent {

    private static final List<String> EXCLUDED = Arrays.asList("PROD", "STAGING");
    private OrderComponent orderComponent;

    public OrderComponentProxi(WebDriver driver) {
        String currentEnv = System.getProperty("env");
        if (EXCLUDED.contains(currentEnv)) {
            this.orderComponent = new OrderComponentReal(driver);
        }
    }

    @Override
    public String placeOrder() {
        if (Objects.nonNull(this.orderComponent)) {
            return this.orderComponent.placeOrder();
        } else {
            return "SKIPPED";
        }


    }
}
