package tests;

import base.BaseTestClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTestClass {


    @Test
    void openBrowserAndNavigate() {
        webDriver.get(properties.getProperty("url"));
        System.out.println("Visited URL is -> "+webDriver.getCurrentUrl());
    }
}
