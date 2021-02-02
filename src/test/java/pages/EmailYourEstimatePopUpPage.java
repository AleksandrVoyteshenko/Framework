package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class EmailYourEstimatePopUpPage extends AbstractPage {

    private String activationFieldAddData = "//label[contains(text(), '%s')]/following-sibling::input";
    private String pushMessageButton = "//*[contains(text(), 'Send Email')]";

    public EmailYourEstimatePopUpPage(WebDriver driver) {
        super(driver);
    }

    public GeneratingRandomMailPage addMailAddress(String mail, String nameValueField) {
        scrollToElement(pushMessageButton);
        do {waitElementToClick(String.format(activationFieldAddData, nameValueField));
            inputText(String.format(activationFieldAddData, nameValueField), mail);
        } while (driver.findElements(By.xpath(String.format(activationFieldAddData, nameValueField))).size() == 0);
        waitElementToClick(pushMessageButton);
        switchWindow(1);
        return new GeneratingRandomMailPage(driver);
    }
}