package utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtil {
    private WebDriver driver;
    int totalWaitTime = 10;

    public BrowserUtil(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertText() {
        waitForAlert();
        return driver.switchTo().alert().getText();

    }

    public void acceptAlert() {
        waitForAlert();
        driver.switchTo().alert().accept();
    }

    public void waitForAlert() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(totalWaitTime));
        wait.until(ExpectedConditions.alertIsPresent());
    }
}
