package pages;

import base.BaseTestClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;


public class FrameTest extends BaseTestClass {
    String listXpath = "//html//body//ul//li[contains(@id,'right')]";
    String framePageNavigationXpath = "//a[@id='framestest']";
    String formPageNavigationXpath = "//a[@id='htmlformtest']";
    WebElement indexPageElement;
    String fileUploadXpath = "//input[@type='file']";
    int screenshotCount = 0;

    @Test(priority = 1)
    public void loginAndRedirect() {
        webDriver.get(properties.getProperty("testPagesURL"));
        indexPageElement = webDriver.findElement(By.xpath("//div[@class='page-navigation']"));
    }

    //Now switching to the frame and retrieving the list
    @Test(priority = 2)
    public void listRetrieve() {

        //Navigating to the frame section in the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(framePageNavigationXpath)));
        webDriver.findElement(By.xpath(framePageNavigationXpath)).click();

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//frame[@name='right']")));
        //webDriver.switchTo().frame("right");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(listXpath)));

        List<WebElement> itemList = webDriver.findElements(By.xpath(listXpath));
        System.out.println(itemList.size());

        for (WebElement i : itemList) {
            System.out.println(i.getText());
        }
        webDriver.switchTo().defaultContent();

        //Navigating back to index page
        webDriver.navigate().back();
//        if (indexPageElement.isDisplayed()) {
//            indexPageElement.click();
//        } else {
//            webDriver.navigate().back();
//        }
    }

    @Test(priority = 3)
    public void fileUpload() throws IOException {
        //Setting element identifier
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(formPageNavigationXpath)));
        webDriver.findElement(By.xpath(formPageNavigationXpath)).click();

        //To upload file
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(fileUploadXpath)));
        //webDriver.findElement(By.xpath(fileUploadXpath));
        path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "upload", "screenshotForSeleniumUpload.png");
        String filePath = path.toString();
        webDriver.findElement(By.xpath(fileUploadXpath)).sendKeys(filePath);

        //TODO: add screenshot for successful file upload check

        path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "download", "screenshotProofForUpload"+screenshotCount+".png");
        String destinationFilePathName = path.toString();
        File screenshotFile = ((TakesScreenshot)webDriver).getScreenshotAs(OutputType.FILE);
        File locationFile = new File(destinationFilePathName);
        FileUtils.copyFile(screenshotFile,locationFile);
        screenshotCount++;
    }
}
