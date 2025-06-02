package tests;

import base.BaseTestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;


public class LoginPageTest extends BaseTestClass {
    LoginPage loginPage;
    SoftAssert softAssert;


    @Test(priority = 1)
    void openBrowserAndNavigate() {
        loginPage = new LoginPage(webDriver);
        webDriver.get(properties.getProperty("url"));
        System.out.println("Visited URL is -> " + webDriver.getCurrentUrl());
    }

    @Test(priority = 3, dependsOnMethods = "openBrowserAndNavigate")
    void validLoginAttempt() {
        //Providing email and password with loginCTA click

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(properties.getProperty("usernameFieldXpath"))));
        loginPage.setUsernameField(properties.getProperty("username"));
        loginPage.setPasswordField(properties.getProperty("password"));
        loginPage.clickLogin();

        //Verify login
        wait.until(ExpectedConditions.urlToBe(properties.getProperty("dashboardURL")));
        Assert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("dashboardURL"));
    }

    @Test(priority = 2)
    void inValidLoginAttempt1() {
        //Providing email and password with loginCTA click

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(properties.getProperty("usernameFieldXpath"))));
        loginPage.setUsernameField(properties.getProperty("invalidUsername"));
        loginPage.setPasswordField(properties.getProperty("invalidPassword"));
        loginPage.clickLogin();

        //Verify login
        wait.until(ExpectedConditions.urlToBe(properties.getProperty("dashboardURL")));
        softAssert.assertEquals(webDriver.getCurrentUrl(), properties.getProperty("dashboardURL"));
    }
}
