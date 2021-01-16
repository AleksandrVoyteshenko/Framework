package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import driver.Driver;
import service.CreatorVM;
import util.TestListener;

import java.io.IOException;

@Listeners({TestListener.class})
abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void openBrowser() {
        driver = Driver.getDriver();
    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser(){
        Driver.closeDriver();
    }
}