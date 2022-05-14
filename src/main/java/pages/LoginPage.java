package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    private final By usernameField = By.id("txtUserName");
    private final By usernameLoginButton = By.id("btnLogin");
    private final By passwordField = By.id("txtPassword");
    private final By passwordLoginButton = By.id("btnEmailSelect");

    public HomePage beLogin(String username, String password) {

        System.out.println("beLogin Method is called.");
        sendKey(usernameField, username);
        click(usernameLoginButton);
        sendKey(passwordField, password);
        click(passwordLoginButton);
        pass("Kullanıcı giriş işlemi yapar.");
        return new HomePage(webDriver);
    }
}