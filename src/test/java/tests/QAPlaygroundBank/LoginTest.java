package tests.QAPlaygroundBank;
import org.testng.annotations.Test;

import base.BaseTestClass;
import pages.QAPlaygroundBank.QAPlaygroundLoginPage;

public class LoginTest extends BaseTestClass {
QAPlaygroundLoginPage loginPage;
    @Test(priority=1)
    public void openApplication(){
        loginPage = new QAPlaygroundLoginPage(webDriver, wait);
        webDriver.get(properties.getProperty("qaPlaygroundBankURL"));
    }

    @Test(priority=2)
    public void loginIntoApplicationWithCredentials(){
        loginPage.enterUsername();
        loginPage.enterPassowrd();
        loginPage.loginButtonClick();
    }
    
}
