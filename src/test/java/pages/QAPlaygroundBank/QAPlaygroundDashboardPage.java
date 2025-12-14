package pages.QAPlaygroundBank;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class QAPlaygroundDashboardPage {
    WebDriver driver;
    WebDriverWait wait;
    private By totalBalance = By.id("total-balance");
    private By activeAccounts = By.id("accounts-count");
    private By addAccountCTA = By.id("add-account-quick");
    private By newTransactionsCTA = By.id("new-transaction-quick");
    private By viewAllAccountsCTA = By.id("view-all-accounts");
    private By accountOverviewCards = By.xpath("(//p[contains(@class,'text-2xl font-bold text-purple-600 mb-2')])");

    
    public QAPlaygroundDashboardPage(WebDriver webDriver, WebDriverWait wait){
        this.driver = webDriver;
        this.wait = wait;
    }

    public String getBalance(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(totalBalance));
        return driver.findElement(totalBalance).getText();
    }

    public String getActiveAccounts(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(activeAccounts));
        return driver.findElement(activeAccounts).getText();
    }

    public void addAccountCTAClick(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(addAccountCTA));
        driver.findElement(addAccountCTA).click();
    }

    public void newTransactionsCTAClick(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(newTransactionsCTA));
        driver.findElement(newTransactionsCTA).click();
    }
}
