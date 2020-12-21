package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import driver.DriverSingleton;
import util.TestListener;

@Listeners({TestListener.class})
abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void openBrowser() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser(){
        DriverSingleton.closeDriver();
    }
}