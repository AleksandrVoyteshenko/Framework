package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleCloudHomePage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement buttonSearch;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudResultSearchPage searchOfQuery(String search) {
        buttonSearch.click();
        buttonSearch.sendKeys(search, Keys.ENTER);
        return new GoogleCloudResultSearchPage(driver);
    }
}