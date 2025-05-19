package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class LoginPage {
    Path filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "pagecontent.properties");
    String filePathOfProperties = filePath.toString();
    Properties properties = new Properties();

    FileInputStream fileInputStream;
    private WebDriver webDriver;

    private By usernameField;
    private By passwordField;
    private By loginCTA;

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
        try {
            fileInputStream = new FileInputStream(filePathOfProperties);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void setUsernameField(String username){
        usernameField = By.cssSelector(properties.getProperty("usernameFieldXpath"));
        WebElement element = webDriver.findElement(usernameField);
        element.clear();
        element.sendKeys(username);
    }

    public void setPasswordField(String password){
        passwordField = By.cssSelector(properties.getProperty("passwordFieldCssSelector"));
        WebElement element = webDriver.findElement(passwordField);
        element.clear();
        element.sendKeys(password);
    }

    public void clickLogin(){
        loginCTA = By.cssSelector(properties.getProperty("loginCTACssSelector"));
        webDriver.findElement(loginCTA).click();
    }
}
