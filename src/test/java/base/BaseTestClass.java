package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class BaseTestClass {
    protected WebDriver webDriver;
    protected FileInputStream fileInputStream;
    protected Properties properties = new Properties();
    Path path = Paths.get(System.getProperty("user.dir"),"src","test","resources","pagecontent.properties");
    String filePath = path.toString();


    @BeforeClass
    public void browserSetupWithChrome() throws IOException {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        fileInputStream = new FileInputStream(filePath);
        properties.load(fileInputStream);
        //webDriver.get(visitURL);
    }

//    //@BeforeClass
//    public void browserSetupWithFireFox(String visitURL) {
//        webDriver = new FirefoxDriver();
//        webDriver.manage().window().maximize();
//        webDriver.get(visitURL);
//    }

    @AfterClass
    public void quitBrowser() {
        if (webDriver != null) {
            webDriver.quit();
        } else System.out.println("Driver found to be null");
    }
}
