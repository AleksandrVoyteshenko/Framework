package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GeneratingRandomMailPage extends AbstractPage {

    private String buttonLookMessage = "//*[@id='libcop']/following-sibling::input";
    private String messageIndicator = "//*[@id='nbmail']";
    private String valueNumberMessage = "1 mail";
    private String buttonRefreshMessage = "//*[@id='lrefr']";
    private String nameFrameOfMessage = "ifmail";
    private String xpathContentMessage = "//*[contains(text(), 'Total Estimated')]//..//following::td[1]";
    private String xpathEmailAddress = "//*[@id = 'login']";
    private String nameAttribute = "value";

    public GeneratingRandomMailPage(WebDriver driver) {
        super(driver);
    }

    public String generatingAndCopyMailAddress(String URL_MAIL) {
        openPage(URL_MAIL);
        String atribute = findWebElement(xpathEmailAddress).getAttribute(nameAttribute);
        return atribute;
    }

    public GeneratingRandomMailPage openMessage() {
        waitElementToClick(buttonLookMessage);
        while (!getElementText(messageIndicator).contains(valueNumberMessage)) {
            clickButton(buttonRefreshMessage);
        }
        return this;
    }

    public String getRentalAmountIndicatedInTheEmail() {
        switchToFrameByNameOrId(nameFrameOfMessage);
        String rentalAmountIndicatedInTheEmail = getElementText(xpathContentMessage);
        return rentalAmountIndicatedInTheEmail;
    }

    public void validateSumAmountToMessage(String sumInCalculator, String sumInMessage) {
        Assert.assertTrue(sumInCalculator.contains(sumInMessage));
    }
}