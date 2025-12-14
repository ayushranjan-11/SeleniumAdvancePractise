package tests.QAPlaygroundBank;

import base.BaseTestClass;
import org.testng.annotations.Test;
import pages.QAPlaygroundBank.QAPlaygroundDashboardPage;

public class DashboardTest extends BaseTestClass {
    QAPlaygroundDashboardPage dashboardPage;

    @Test
    public void balanceCheck(){
        dashboardPage = new QAPlaygroundDashboardPage(webDriver,wait);
        System.out.println(dashboardPage.getBalance());
    }
}
