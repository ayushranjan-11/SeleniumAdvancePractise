package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver webDriver;

    private By usernameField = By.xpath("input[placeholder='Username']");
    private By passwordField = By.cssSelector("input[placeholder='Password']");
    private By loginCTA = By.cssSelector("button[type='submit']");

    public LoginPage(WebDriver driver){
        this.webDriver = driver;
    }

    public void setUsernameField(String username){
        WebElement element = webDriver.findElement(usernameField);
        element.clear();
        element.sendKeys(username);
    }

    public void setPasswordField(String password){
        WebElement element = webDriver.findElement(passwordField);
        element.clear();
        element.sendKeys(password);
    }

    public void clickLogin(){
        webDriver.findElement(loginCTA).click();
    }
}
