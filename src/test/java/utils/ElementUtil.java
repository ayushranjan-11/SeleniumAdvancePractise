package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtil {
    private WebDriver webDriver;

    public ElementUtil(WebDriver driver){
        this.webDriver = driver;
    }

    private WebElement getElement(By locator){
        return webDriver.findElement(locator);
    }

    public void performClick(By locator, int timeoutDuration){
        WebElement element = waitForElementVisible(locator,timeoutDuration);
        element.click();
    }

    public void sendKeys(By locator, int timeoutDuration, String textToSend){
        //Adding WebElement for input field to perform click before sending keys
        WebElement webElement = waitForElementVisible(locator, timeoutDuration);
        webElement.clear();
        webElement.sendKeys(textToSend);
    }

    public WebElement waitForElementVisible(By locator, int timeout){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public String getElementText(By locator, int timeout){
        WebElement element = waitForElementVisible(locator, timeout);
        return element.getText();
    }
}
