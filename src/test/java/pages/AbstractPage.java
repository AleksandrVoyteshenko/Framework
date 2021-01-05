package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public abstract class AbstractPage {

    protected WebDriver driver;
    private int TIME_OUT_SECOND = 30;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public AbstractPage openPage(String URL) {
        driver.get(URL);
        return this;
    }

    protected WebElement findWebElement(String locator) {
       return driver.findElement(By.xpath(locator));
    }

    protected AbstractPage clickButton(String locator) {
        findWebElement(locator).click();
        return this;
    }

    protected AbstractPage selectValueFromDropdown(String locator) {
        findWebElement(locator).click();
        return this;
    }

    protected AbstractPage clickField(String locator) {
        findWebElement(locator).click();
        return this;
    }

    protected String getElementText(String locator) {
        String text = findWebElement(locator).getText();
        return text;
    }

    protected AbstractPage inputText(String locator, String text) {
        findWebElement(locator).sendKeys(text);
        return this;
    }

    protected AbstractPage waitElementToClick(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_SECOND)).until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
        return this;
    }

    protected AbstractPage waitElementToVisibility(String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_SECOND)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator))).click();
        return this;
    }

    protected AbstractPage switchToFrameByNameOrId(String nameOrId) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_SECOND)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(nameOrId));
        return this;
    }

    protected AbstractPage switchToFrameByIndex(int index) {
        new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_SECOND)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
        return this;
    }

    public ArrayList<String> getWindow() {
        ArrayList<String> windowsPages = new ArrayList<>(driver.getWindowHandles());
        return windowsPages;
    }

    public AbstractPage switchWindow(int indexWindow) {
        driver.switchTo().window(getWindow().get(indexWindow));
        return this;
    }

    public AbstractPage scrollToElement(String locator) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(false);", findWebElement(locator));
        return this;
    }
}