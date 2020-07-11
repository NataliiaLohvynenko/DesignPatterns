package factory;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class GoogleFactory {

    private static final Function<WebDriver, GooglPage> ENG = (d) -> new GoogleEnglish(d);
    private static final Function<WebDriver, GooglPage> FR = (d) -> new GoggleFrench(d);
    private static final Function<WebDriver, GooglPage> SA = (d) -> new GoogleArabic(d);
    private static final Function<WebDriver,GooglPage> ES = (d)-> new GoogleEs(d);



    private static final Map<String, Function<WebDriver,GooglPage>>MAP = new HashMap<>();

    static {
        MAP.put("ENG",ENG);
        MAP.put("FR", FR);
        MAP.put("SA",SA);
        MAP.put("ES",ES);
    }


    public  static GooglPage get(String language, WebDriver driver){
        return MAP.get(language).apply(driver);
    }

}
