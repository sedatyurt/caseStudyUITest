package stepdefinitions;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.opera.OperaDriver;

import java.io.ByteArrayInputStream;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class Hooks {

    WebDriver webDriver;

    @Before("@HepsiburadaCase")
    public void setUp() {

        String browserName = System.getProperty("browserName");

        switch (browserName) {
            case "chrome" -> {
                System.out.println("Starting with Chrome Driver.");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver(options);
            }
            case "firefox" -> {
                System.out.println("Starting with Firefox Driver.");
                FirefoxProfile firefoxProfile = new FirefoxProfile();
                firefoxProfile.setPreference("permissions.default.desktop-notification", 1);
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
            }
            case "opera" -> {
                System.out.println("Starting with Opera Driver.");
                WebDriverManager.operadriver().setup();
                webDriver = new OperaDriver();
            }
            default -> {
                System.out.println("Driver not undefined! Starting with Chrome Driver.");
                System.out.println("Starting with Chrome Driver.");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-notifications");
                WebDriverManager.chromedriver().setup();
                webDriver = new ChromeDriver();
            }
        }

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        DriverManager.setWebDriver(webDriver);

    }

    @After("@HepsiburadaCase")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment(UUID.randomUUID().toString(), new ByteArrayInputStream((screenshot)));
        }
        webDriver.close();
        webDriver.quit();

    }
}
