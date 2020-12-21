package pages;

import org.openqa.selenium.WebDriver;

public class GoogleCloudResultSearchHCPage extends AbstractPage {

    private String searchResult = "//a[@class = 'gs-title']";

    public GoogleCloudResultSearchHCPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCalculatorHCPage openGoogleCalculator() {
        waitElementToClick(searchResult);
        return new GoogleCalculatorHCPage(driver);
    }
}