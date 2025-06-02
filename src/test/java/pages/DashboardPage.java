package pages;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DashboardPage {
    Path filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "pagecontent.properties");
    String filePathOfProperties = filePath.toString();
    Properties properties = new Properties();

    FileInputStream fileInputStream;
    private WebDriver webDriver;


    public DashboardPage(WebDriver driver) throws IOException {
        this.webDriver = driver;

        try {
            fileInputStream = new FileInputStream(filePathOfProperties);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
