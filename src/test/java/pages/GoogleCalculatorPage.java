package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class GoogleCalculatorPage extends AbstractPage {

    private String EmailEstimateButton = "//*[@id = 'email_quote']";
    private String parentFrame = "//*[@id='cloud-site']/devsite-iframe/iframe";
    private int indexParentFrame = 0;
    private String nameChildFrame = "myFrame";
    private String activationSectionComputeEngine = "//*[@id='mainForm']//md-tab-item[1]";
    private String activationInputNumberOfInstanceXpath = "//*[contains(@ng-model, 'computeServer.quantity')]";
    private String operatingSystemDropdown = "//*[contains(text(), 'Operating System')]//..//md-select-value";
    private String machineClassDropdown = "//*[contains(text(), 'Machine Class')]//..//md-select-value";
    private String seriesDropdown = "//*[contains(text(), 'Series')]//..//md-select-value";
    private String machineTypeDropdown = "//*[contains(text(), 'Machine type')]//..//md-select-value";
    private String localSSDDropdown = "//*[contains(@ng-model, 'computeServer.ssd')]/child::md-select-value";
    private String datacenterDropdown = "//*[contains(@ng-model, 'computeServer.location')]/child::md-select-value";
    private String committedUsageDropdown = "//*[contains(@ng-model, 'computeServer.cud')]/child::md-select-value";
    private String addToEstimateButton = "//button[contains(text(), 'Add to Estimate')]";
    private String valueDropdown = "//div[@aria-hidden = 'false']//descendant::md-option//*[contains(text(), '%s')]";
    private String resultOfRentAmount = "//h2/b";

    public GoogleCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCalculatorPage activationSection() {
        findWebElement(parentFrame).isDisplayed();
        switchToFrameByIndex(indexParentFrame);
        switchToFrameByNameOrId(nameChildFrame);
        waitElementToVisibility(activationSectionComputeEngine);
        return this;
    }

    public GoogleCalculatorPage selectInstances(String valueInstance) {
        clickField(activationInputNumberOfInstanceXpath);
        inputText(activationInputNumberOfInstanceXpath, valueInstance);
        return this;
    }

    public GoogleCalculatorPage selectOperationSystem(String valueOperatingSystem) {
        selectValueFromDropdown(operatingSystemDropdown);
        waitElementToClick(String.format(valueDropdown, valueOperatingSystem));
        return this;
    }

    public GoogleCalculatorPage selectMachineClass(String desiredResultVMClass) {
        selectValueFromDropdown(machineClassDropdown);
        waitElementToClick(String.format(valueDropdown, desiredResultVMClass));
        return this;
    }

    public GoogleCalculatorPage selectSeries(String valueSeries) {
        scrollToElement(addToEstimateButton);
        selectValueFromDropdown(seriesDropdown);
        waitElementToClick(String.format(valueDropdown, valueSeries.toUpperCase()));
        return this;
    }

    public GoogleCalculatorPage selectMachineType(String desiredResultInstanceType) {
        selectValueFromDropdown(machineTypeDropdown);
        waitElementToClick(String.format(valueDropdown, desiredResultInstanceType));
        return this;
    }

    public GoogleCalculatorPage selectLocalSSD(String desiredResultLocalSSD) {
        selectValueFromDropdown(localSSDDropdown);
        waitElementToClick(String.format(valueDropdown, desiredResultLocalSSD));
        return this;
    }

    public GoogleCalculatorPage selectDatacenter(String desiredResultRegion) {
        selectValueFromDropdown(datacenterDropdown);
        scrollToElement(String.format(valueDropdown, desiredResultRegion));
        waitElementToClick(String.format(valueDropdown, desiredResultRegion));
        return this;
    }

    public GoogleCalculatorPage selectCommitedUsage(String desiredResultCommitmentTerm) {
        selectValueFromDropdown(committedUsageDropdown);
        scrollToElement(String.format(valueDropdown, desiredResultCommitmentTerm));
        waitElementToClick(String.format(valueDropdown, desiredResultCommitmentTerm));
        return this;
    }

    public GoogleCalculatorPage clickAddToEstimateButton() {
        scrollToElement(addToEstimateButton);
        clickButton(addToEstimateButton);
        return this;
    }

    public GeneratingRandomMailPage openNewWindow() {
        driver.switchTo().newWindow(WindowType.TAB);
        return new GeneratingRandomMailPage(driver);
    }

    public EmailYourEstimatePopUpPage openPopUp() {
        switchWindow(0);
        switchToFrameByIndex(indexParentFrame);
        switchToFrameByNameOrId(nameChildFrame);
        clickButton(EmailEstimateButton);
        return new EmailYourEstimatePopUpPage(driver);
    }

    public String getRentalAmountReceivedInCalculator() {
        return getElementText(resultOfRentAmount);
    }
}