package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class GoogleCalculatorHCPage extends AbstractPage {

    private String buttonEmailEstimate = "//*[@id = 'email_quote']";
    private String xpathActivationFieldAddMail = "//*[@type = 'email']";
    private String buttonPushMessage = "//*[contains(text(), 'Send Email')]";
    private String parentFrame = "//*[@id='cloud-site']/devsite-iframe/iframe";
    private int indexParentFrame = 0;
    private String nameChildFrame = "myFrame";
    private String activationSectionComputeEngine = "//*[@id='mainForm']//md-tab-item[1]";
    private String activationInputNumberOfInstanceXpath = "//*[contains(@ng-model, 'computeServer.quantity')]";
    private String dropdownOperatingSystemXpath = "//*[contains(text(), 'Operating System')]//..//md-select-value";
    private String dropdownMachineClassXpath = "//*[contains(text(), 'Machine Class')]//..//md-select-value";
    private String dropdownSeriesXpath = "//*[contains(text(), 'Series')]//..//md-select-value";
    private String dropdownMachineTypeXpath = "//*[contains(text(), 'Machine type')]//..//md-select-value";
    private String dropdownLocalSSDXpath = "//*[contains(@ng-model, 'computeServer.ssd')]/child::md-select-value";
    private String dropdownDatacenterXpath = "//*[contains(@ng-model, 'computeServer.location')]/child::md-select-value";
    private String dropdownCommittedUsageXpath = "//*[contains(@ng-model, 'computeServer.cud')]/child::md-select-value";
    private String addToEstimateButton = "//button[contains(text(), 'Add to Estimate')]";
    private String valueDropdown = "//div[@aria-hidden = 'false']//descendant::md-option//*[contains(text(), '%s')]";
    private String resultOfRentAmount = "//h2/b";
    private String nameAttribute = "disabled";

    public GoogleCalculatorHCPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCalculatorHCPage activationSection() {
        findWebElement(parentFrame).isDisplayed();
        switchToFrameByIndex(indexParentFrame);
        switchToFrameByNameOrId(nameChildFrame);
        waitElementToVisibility(activationSectionComputeEngine);
        return this;
    }

    public GoogleCalculatorHCPage selectInstances(String valueInstance) {
        clickField(activationInputNumberOfInstanceXpath);
        inputText(activationInputNumberOfInstanceXpath, valueInstance);
        return this;
    }

    public GoogleCalculatorHCPage selectOperationSystem(String valueOperatingSystem) {
        selectValueFromDropdown(dropdownOperatingSystemXpath);
        waitElementToClick(String.format(valueDropdown, valueOperatingSystem));
        return this;
    }

    public GoogleCalculatorHCPage selectMachineClass(String desiredResultVMClass) {
        selectValueFromDropdown(dropdownMachineClassXpath);
        waitElementToClick(String.format(valueDropdown, desiredResultVMClass));
        return this;
    }

    public GoogleCalculatorHCPage selectSeries(String valueSeries) {
        selectValueFromDropdown(dropdownSeriesXpath);
        waitElementToClick(String.format(valueDropdown, valueSeries.toUpperCase()));
        return this;
    }

    public GoogleCalculatorHCPage selectMachineType(String desiredResultInstanceType) {
        selectValueFromDropdown(dropdownMachineTypeXpath);
        waitElementToClick(String.format(valueDropdown, desiredResultInstanceType));
        return this;
    }

    public GoogleCalculatorHCPage selectLocalSSD(String desiredResultLocalSSD) {
        selectValueFromDropdown(dropdownLocalSSDXpath);
        waitElementToClick(String.format(valueDropdown, desiredResultLocalSSD));
        return this;
    }

    public GoogleCalculatorHCPage selectDatacenter(String desiredResultRegion) {
        selectValueFromDropdown(dropdownDatacenterXpath);
        waitElementToClick(String.format(valueDropdown, desiredResultRegion));
        return this;
    }

    public GoogleCalculatorHCPage selectCommitedUsage(String desiredResultCommitmentTerm) {
        selectValueFromDropdown(dropdownCommittedUsageXpath);
        waitElementToClick(String.format(valueDropdown, desiredResultCommitmentTerm));
        return this;
    }

    public GoogleCalculatorHCPage clickAddToEstimateButton() {
        clickButton(addToEstimateButton);
        return this;
    }

    public GeneratingRandomMailPage openNewWindow() {
        driver.switchTo().newWindow(WindowType.TAB);
        return new GeneratingRandomMailPage(driver);
    }

    public GeneratingRandomMailPage addMailAddress(String mail) {
        switchWindow(0);
        switchToFrameByIndex(indexParentFrame);
        switchToFrameByNameOrId(nameChildFrame);
        clickButton(buttonEmailEstimate);
        waitElementToClick(xpathActivationFieldAddMail);
        inputText(xpathActivationFieldAddMail, mail);
        if (driver.findElements(By.xpath(xpathActivationFieldAddMail)).size() == 0) {
            inputText(xpathActivationFieldAddMail, mail);
        }
        waitElementToClick(buttonPushMessage);
        switchWindow(1);
        return new GeneratingRandomMailPage(driver);
    }

    public String getRentalAmountReceivedInCalculator() {
        return getElementText(resultOfRentAmount);
    }
}