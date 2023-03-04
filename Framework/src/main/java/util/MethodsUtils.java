package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class MethodsUtils {
    private WebDriver driver;

    public MethodsUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void getOpenTabs(String url) {
        driver.switchTo().newWindow(WindowType.TAB).get(url);
    }
}
