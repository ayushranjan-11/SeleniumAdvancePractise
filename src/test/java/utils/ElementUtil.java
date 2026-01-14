package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtil {
    private WebDriver webDriver;
    int timeout = 10;

    public ElementUtil(WebDriver driver){
        this.webDriver = driver;
    }

    public  WebElement getElement(By locator){
        return waitForElementVisible(locator);
    }

    public void performClick(By locator){
        WebElement element = waitForElementVisible(locator);
        element.click();
    }

    public void sendKeys(By locator, String textToSend){
        //Adding WebElement for input field to perform click before sending keys
        WebElement webElement = waitForElementVisible(locator);
        webElement.clear();
        webElement.sendKeys(textToSend);
    }

    public WebElement waitForElementVisible(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementClickable(By locator){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public String getElementText(By locator){
        WebElement element = waitForElementVisible(locator);
        return element.getText();
    }

    public void clickCTA(By locator){
        WebElement element = waitForElementClickable(locator);
        element.click();
    }
}
