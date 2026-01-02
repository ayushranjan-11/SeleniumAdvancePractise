package tests.QAPlaygroundBank;

import base.BaseTestClass;
import org.testng.annotations.Test;
import pages.QAPlaygroundBank.QAPlaygroundDashboardPage;
import pages.QAPlaygroundBank.QAPlaygroundTransaction;

public class DashboardTest extends BaseTestClass {
    QAPlaygroundDashboardPage dashboardPage;
    QAPlaygroundTransaction transactionAction;

    @Test(priority = 1)
    public void balanceCheck(){
        dashboardPage = new QAPlaygroundDashboardPage(webDriver,wait);
        System.out.println(dashboardPage.getBalance());
    }

    @Test(priority = 2)
    public void transactionCheck(){
        transactionAction = new QAPlaygroundTransaction(webDriver,wait);
        transactionAction.transactionCTAClick();
        transactionAction.selectTransactionType();
        transactionAction.selectFromAccount();
    }
}
