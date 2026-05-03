package tests.QAPlaygroundBank;
import org.testng.annotations.Test;

import base.BaseTestClass;
import pages.QAPlaygroundBank.QAPlaygroundLoginPage;
import utils.LogicUtil;

public class LoginTest extends BaseTestClass {
QAPlaygroundLoginPage loginPage;
LogicUtil logicUtil = new LogicUtil();
    @Test(priority=1)
    public void openApplication(){
        loginPage = new QAPlaygroundLoginPage(webDriver, wait);
        webDriver.get(properties.getProperty("qaPlaygroundBankURL"));
    }


    @Test(priority=2)
    public void loginIntoApplicationWithWrongCredentialsForUsername(){
        //User enters wrong username
        loginPage.enterUsername(properties.getProperty("invalidUsername"));
        loginPage.enterPassowrd(loginPage.getPasswordFromPage());
        loginPage.loginButtonClick();
        String loginErrorMessage = loginPage.getLoginErrorMessage();
        logicUtil.checkErrorMessageContent(loginErrorMessage);
        webDriver.navigate().refresh();
    }

    @Test(priority=3)
    public void loginIntoApplicationWithWrongCredentialsForPassword(){
        //User enters wrong password
        loginPage.enterUsername(loginPage.getUsernameFromPage());
        loginPage.enterPassowrd(properties.getProperty("invalidPassword"));
        loginPage.loginButtonClick();
        String loginErrorMessage = loginPage.getLoginErrorMessage();
        logicUtil.checkErrorMessageContent(loginErrorMessage);
        webDriver.navigate().refresh();
    }
    @Test(priority=4)
    public void loginIntoApplicationWithCredentials(){
        loginPage.enterUsername(loginPage.getUsernameFromPage());
        loginPage.enterPassowrd(loginPage.getPasswordFromPage());
        loginPage.loginButtonClick();
    }
    
}
