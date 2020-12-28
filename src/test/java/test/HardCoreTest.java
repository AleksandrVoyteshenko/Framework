package test;

import businessobjects.VirtualMachine;
import org.testng.annotations.Test;
import pages.EmailYourEstimatePopUpPage;
import pages.GeneratingRandomMailPage;
import pages.GoogleCalculatorPage;
import pages.GoogleCloudHomePage;
import pages.GoogleCloudResultSearchPage;
import service.CreatorVM;

/**
 * Задача - построить фреймворк для автоматизации Hardcore  задания из курса WebDriver.
 *
 * Что должно быть в итоговом фреймворке:
 *
 * webdrivermanager для управления коннекторам к браузерам
 * Page Object / Page Factory для абстракций страниц
 * Модель для бизнес-объектов необходимых сущностей
 * properties файлы с тестовыми данным для разных окружений (как минимум 2)
 * xml suites для smoke тестов и всех тестов
 * При падении теста должен быть сделан скриншот с датой и временем
 * Фреймворк должен иметь возможность запуска с Jenkins и параметризацией браузера, тест suite, environment.
 * Результаты тестов должны быть на графике джобы, скриншоты должны быть заархивированны как артефакты
 */

public class HardCoreTest extends BaseTest {

    private String URL_MAIL = "http://www.yopmail.com/ru/email-generator.php";
    private String URL_HOME_PAGE = "https://cloud.google.com";
    private String search = "Google Cloud Platform Pricing Calculator";
    private String nameValueField = "Email";

    @Test
    public void checkingCalculatorData() {
        VirtualMachine vm = CreatorVM.getVirtualMachineWithDataFromProperties();
        GoogleCloudHomePage googleCloudHomeHCPage = new GoogleCloudHomePage(driver);
        googleCloudHomeHCPage.openPage(URL_HOME_PAGE);
        GoogleCloudResultSearchPage googleCloudResultSearchHCPage = googleCloudHomeHCPage.searchOfQuery(search);
        GoogleCalculatorPage googleCalculatorHCPage = googleCloudResultSearchHCPage.openGoogleCalculator();
        googleCalculatorHCPage
                .activationSection()
                .selectInstances(vm.getValueInstance())
                .selectOperationSystem(vm.getValueOperatingSystem())
                .selectMachineClass(vm.getDesiredResultVMClass())
                .selectSeries(vm.getValueSeries())
                .selectMachineType(vm.getDesiredResultInstanceType())
                .selectLocalSSD(vm.getDesiredResultLocalSSD())
                .selectDatacenter(vm.getDesiredResultRegion())
                .selectCommitedUsage(vm.getDesiredResultCommitmentTerm())
                .clickAddToEstimateButton();
        String sumInCalculator = googleCalculatorHCPage.getRentalAmountReceivedInCalculator();
        GeneratingRandomMailPage generatingRandomMailPage = googleCalculatorHCPage.openNewWindow();
        String mail = generatingRandomMailPage.generatingAndCopyMailAddress(URL_MAIL);
        googleCalculatorHCPage
                .openPopUp();
        EmailYourEstimatePopUpPage emailYourEstimatePage = new EmailYourEstimatePopUpPage(driver);
        emailYourEstimatePage
                .addMailAddress(mail, nameValueField);
        String sumInMessage = generatingRandomMailPage
                .openMessage()
                .getRentalAmountIndicatedInTheEmail();
        generatingRandomMailPage.validateSumAmountToMessage(sumInCalculator, sumInMessage);
    }
}