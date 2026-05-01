package pages.QAPlaygroundBank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.BrowserUtil;
import utils.ElementUtil;
import utils.LogicUtil;

import java.util.List;

//To make transaction across available account
public class QAPlaygroundTransaction {

    WebDriver driver;
    WebDriverWait wait;
    Select select;
    ElementUtil elementUtil;
    BrowserUtil browserUtil;
    LogicUtil logicUtil;
    private static final Logger log = LogManager.getLogger(QAPlaygroundTransaction.class);

    public QAPlaygroundTransaction(WebDriver webDriver, WebDriverWait webDriverWait) {
        this.driver = webDriver;
        this.wait = webDriverWait;
        elementUtil = new ElementUtil(driver);
        browserUtil = new BrowserUtil(driver);
        logicUtil = new LogicUtil();

    }

    private By transactionCTA = By.id("new-transaction-link");
    private By modalTitle = By.id("modal-title");
    private By transactionTypeDropdownOption = By.xpath("//button[@data-testid='transaction-type-select']");
    private By transactionTypeOptionSelect; //Need this to be called post string dropdownOption is updated
    private By fromAccountDropdownOption = By.xpath("(//select[contains(@style,'position: absolute')])[last()]");
    private By amountInputField = By.id("transaction-amount");
    private By descriptionInputField = By.id("transaction-description");
    private By sendNotificationCheckBox = By.id("send-notification");
    private By cancelCTA = By.id("cancel-transaction-btn");
    private By submitTransaction = By.id("submit-transaction-btn");
    private By toastMessage = By.xpath("//li[@data-type='success']");


    public void transactionCTAClick() {
//        wait.until(ExpectedConditions.elementToBeClickable(transactionCTA));
//        driver.findElement(transactionCTA).click();

        elementUtil.performClick(transactionCTA); //This is introduced with ElementUtil class

        //Adding transaction dialog box heading grab to verify if the section was opened successfully
//        wait.until(ExpectedConditions.visibilityOfElementLocated(modalTitle));
//        System.out.println(driver.findElement(modalTitle).getText());

        System.out.println(elementUtil.getElementText(modalTitle));
    }


    /*TODO: First add manual dropdown option selection from the dropdown of the transaction type, and then it can be improved for selecting random option from the dropdown for transaction type and from account*/

    public void selectTransactionType(String optionToSelect) {

        if(optionToSelect!=null && !optionToSelect.isEmpty()) {
            transactionTypeOptionSelect = By.xpath("//div[@role='item' or @role='option']//span[text()='"+optionToSelect+"']");
        }
        //This is a modern UI dropdown which is not compatible with select dropdown selection, hence it is required to use xpath dropdown option selection

        elementUtil.performClick(transactionTypeDropdownOption);
        elementUtil.performClick(transactionTypeOptionSelect);

    }

    public void selectFromAccount() {
//        wait.until(ExpectedConditions.elementToBeClickable(fromAccountDropdown));
//        webElement = driver.findElement(fromAccountDropdown);


        WebElement webElement = elementUtil.getElement(fromAccountDropdownOption);

        select = new Select(webElement);

        List<WebElement> fromAccountOptions = select.getOptions();
        log.info("From account dropdown option sizes: {}",fromAccountOptions.size());

    //    int randomNumber = logicUtil.randomNumberGenerator(fromAccountOptions.size());

        //select.selectByValue(fromAccountOptions.get(randomNumber).getDomProperty("value"));
        //This step can be also written like:
        select.selectByValue(fromAccountOptions.get(logicUtil.randomNumberGenerator()).getDomProperty("value"));
    }

    public void setAmount(){
        elementUtil.sendKeys(amountInputField,"1500");
    }

    public void setDescriptionInputField(String inputForField){
        elementUtil.sendKeys(descriptionInputField, inputForField);
    }

    public void submitCTAClick(){
        elementUtil.clickCTA(submitTransaction);
    }

    public void cancelCTAClick(){
        elementUtil.clickCTA(cancelCTA);
    }

//    public String getAlertText(){
//        return browserUtil.getAlertText();
//    }
//
//    public void acceptAlert(){
//        browserUtil.acceptAlert();
//    }
//  The alert was removed from the website

    public String getToastMessage(){
        return elementUtil.getToastMessage(toastMessage);
    }
}
