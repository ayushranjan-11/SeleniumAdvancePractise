package pages.QAPlaygroundBank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ElementUtil;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

//To make transaction across available account
public class QAPlaygroundTransaction {

    WebDriver driver;
    WebDriverWait wait;
    WebElement webElement;
    Select select;
    ElementUtil elementUtil;

    public QAPlaygroundTransaction(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.driver = webDriver;
        this.wait = webDriverWait;
        elementUtil = new ElementUtil(driver);

    }

    private By transactionCTA = By.id("new-transaction-link");
    private By modalTitle = By.id("modal-title");
    private By transactionTypeDropdown = By.xpath("(//select[contains(@style,'position: absolute')])[last()-1]");
    private By fromAccountDropdown = By.xpath("(//select[contains(@style,'position: absolute')])[last()]");
    private By amountInputField = By.id("transaction-amount");
    private By descriptionInputField = By.id("transaction-description");
    private By sendNotificationCheckBox = By.id("send-notification");
    private By cancelCTA = By.id("cancel-transaction-btn");
    private By submitTransaction = By.id("submit-transaction-btn");

    public void transactionCTAClick() {
//        wait.until(ExpectedConditions.elementToBeClickable(transactionCTA));
//        driver.findElement(transactionCTA).click();

        elementUtil.performClick(transactionCTA,10); //This is introduced with ElementUtil class

        //Adding transaction dialog box heading grab to verify if the section was opened successfully
//        wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
//        System.out.println(driver.findElement(modalTitle).getText());

        System.out.println(elementUtil.getElementText(modalTitle,10));
    }


    /*TODO: First add manual dropdown option selection from the dropdown of the transaction type, and then it can be improved for selecting random option from the dropdown for transaction type and from account*/

    public void selectTransactionType() {
        wait.until(ExpectedConditions.elementToBeClickable(transactionTypeDropdown));
        webElement = driver.findElement(transactionTypeDropdown);
        select = new Select(webElement);

        List<WebElement> transactionDropdownOptions = select.getOptions();
//        for (WebElement option : transactionDropdownOptions) {
//            System.out.println(option.getText());
//        }
        select.selectByValue(transactionDropdownOptions.getFirst().getDomAttribute("value"));

    }

    public void selectFromAccount(){
        wait.until(ExpectedConditions.elementToBeClickable(fromAccountDropdown));
        webElement = driver.findElement(fromAccountDropdown);
        select = new Select(webElement);

        List<WebElement> fromAccountOptions = select.getOptions();

        select.selectByValue(fromAccountOptions.getLast().getDomAttribute("value"));
    }
}
