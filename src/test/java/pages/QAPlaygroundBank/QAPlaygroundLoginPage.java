package pages.QAPlaygroundBank;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAPlaygroundLoginPage {
    WebDriver webDriver;
    WebDriverWait webDriverWait;
    //This class will represent the login page with element and actions

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-btn");
    private By currentUsernameFromPage = By.xpath("//*[@data-testid='demo-username']");
    private By currentPasswordFromPage = By.xpath("//*[@data-testid='demo-password']");

    public QAPlaygroundLoginPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    private String getUsernameFromPage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(currentUsernameFromPage));
        return webDriver.findElement(currentUsernameFromPage).getText();
    }

    private String getPasswordFromPage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(currentPasswordFromPage));
        return webDriver.findElement(currentPasswordFromPage).getText();
    }

    public void enterUsername(){
        webDriver.findElement(usernameField).sendKeys(getUsernameFromPage());
    }

    public void enterPassowrd(){
        webDriver.findElement(passwordField).sendKeys(getPasswordFromPage());
    }

    public void loginButtonClick(){
        webDriver.findElement(loginButton).click();
    }
}
