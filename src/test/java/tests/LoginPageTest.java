package tests;

import base.BaseTestClass;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class LoginPageTest extends BaseTestClass {
LoginPage loginPage;


    @Test(priority = 1)
    void openBrowserAndNavigate() {
        loginPage = new LoginPage(webDriver);
        webDriver.get(properties.getProperty("url"));
        System.out.println("Visited URL is -> "+webDriver.getCurrentUrl());
    }

    @Test(priority = 2, dependsOnMethods = "openBrowserAndNavigate")
    void loginAttempt(){
        //Providing email and password with loginCTA click

        loginPage.setUsernameField(properties.getProperty("username"));
        loginPage.setPasswordField(properties.getProperty("password"));
        loginPage.clickLogin();
    }
}
