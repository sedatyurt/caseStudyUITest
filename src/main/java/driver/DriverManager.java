package driver;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static WebDriver webDriver;

    public static void setWebDriver(WebDriver webDriver) {
        System.out.println("setWebDriver method is called");
        DriverManager.webDriver = webDriver;
    }

    public static WebDriver getWebDriver() {
        System.out.println("getWebDriver method is called");
        return webDriver;
    }
}
