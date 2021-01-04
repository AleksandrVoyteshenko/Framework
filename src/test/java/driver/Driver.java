package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import service.TestDataReader;

import java.io.IOException;
import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() throws IOException {
        if (driver == null) {
            if (System.getProperty("browser") == null) {
               setupDriverWithFileProperties();
            } else {
                setupDriverWithSystemProperties();
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }

    public static WebDriver setupDriverWithSystemProperties() {
        switch (System.getProperty("browser")) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
        }
        return driver;
    }

    public static WebDriver setupDriverWithFileProperties() throws IOException {
        switch (TestDataReader.getData("browser")) {
            case "firefox": {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            }
            case "chrome": {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            }
        }
        return driver;
    }
}