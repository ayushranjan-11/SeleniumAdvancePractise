package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

public class BaseTestClass {
    protected WebDriver webDriver;
    protected FileInputStream fileInputStream;
    protected Properties properties = new Properties();
    Path path = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "pagecontent.properties");
    protected WebDriverWait wait;
    String filePath = path.toString();
    ChromeOptions chromeOptions;


    @BeforeClass
    public void browserSetupWithChrome() throws IOException {
        chromeOptions = new ChromeOptions();
        Map<String, Object> preference = new HashMap<>();
        preference.put("profile.password_manager_leak_detection", false);
        preference.put("credentials_enable_service",false);
        preference.put("profile.credentials_enable_service",false);

        /*
        * These above three preference were added to eliminate the password save notification and Change password leak
        * detection warning message
        * */

        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.setExperimentalOption("prefs",preference); //After adding set of rules in preference this is required to set those rule in opened browser
        webDriver = new ChromeDriver(chromeOptions);
        webDriver.manage().window().maximize();
        fileInputStream = new FileInputStream(filePath);
        properties.load(fileInputStream);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
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
