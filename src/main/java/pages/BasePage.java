package pages;

import helper.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends Utilities {

    protected WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 20);
    }

    public void click(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void click(By by) {
        try {
            webDriverWait.until(ExpectedConditions.elementToBeClickable(by));
            webDriver.findElement(by).click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isDisplayed(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean isDisplayed(By by) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
            return webDriver.findElement(by).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void sendKey(WebElement webElement, String key) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.sendKeys(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendKey(By by, String key) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
            webDriver.findElement(by).sendKeys(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getText(WebElement webElement) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getText(By by) {
        try {
            webDriverWait.until(ExpectedConditions.visibilityOf(webDriver.findElement(by)));
            return webDriver.findElement(by).getText();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void pass(String details) {
        waitSeconds(1);
        //TestListener.pass(details);
    }

    public void fail(String details) {
        //TestListener.fail(details);
    }
}
