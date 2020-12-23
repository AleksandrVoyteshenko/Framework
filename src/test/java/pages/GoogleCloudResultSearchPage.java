package pages;

import org.openqa.selenium.WebDriver;

public class GoogleCloudResultSearchPage extends AbstractPage {

    private String searchResult = "//a[@class = 'gs-title']";

    public GoogleCloudResultSearchPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCalculatorPage openGoogleCalculator() {
        waitElementToClick(searchResult);
        return new GoogleCalculatorPage(driver);
    }
}