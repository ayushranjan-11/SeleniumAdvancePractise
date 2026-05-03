package pages.QAPlaygroundBank;

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
    public By currentUsernameFromPage = By.xpath("//*[@data-testid='demo-username']");
    public By currentPasswordFromPage = By.xpath("//*[@data-testid='demo-password']");
    public By loginErrorMessage = By.id("login-alert");

    public QAPlaygroundLoginPage(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.webDriver = webDriver;
        this.webDriverWait = webDriverWait;
    }

    public String getUsernameFromPage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(currentUsernameFromPage));
        return webDriver.findElement(currentUsernameFromPage).getText();
    }

    public String getPasswordFromPage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(currentPasswordFromPage));
        return webDriver.findElement(currentPasswordFromPage).getText();
    }

    public void enterUsername(String usernameProvided){
        webDriver.findElement(usernameField).sendKeys(usernameProvided);
    }

    public void enterPassowrd(String passwordProvided){
        webDriver.findElement(passwordField).sendKeys(passwordProvided);
    }

    public void loginButtonClick(){
        webDriver.findElement(loginButton).click();
    }

    public String getLoginErrorMessage(){
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(loginErrorMessage));
        return webDriver.findElement(loginErrorMessage).getDomProperty("textContent");
    }
}
