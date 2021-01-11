package test;

import businessobjects.VirtualMachine;
import dropdown.CommittedUsage;
import dropdown.MachineClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.EmailYourEstimatePopUpPage;
import pages.GeneratingRandomMailPage;
import pages.GoogleCalculatorPage;
import pages.GoogleCloudHomePage;
import pages.GoogleCloudResultSearchPage;
import service.CreatorVM;
import dropdown.Series;

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
        VirtualMachine vm = CreatorVM.getVirtualMachineWithAllParameters();
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

    @DataProvider(name = "data-provider")
    public static Object[] dataProviderMethod() {
        VirtualMachine virtualMachineAqa = new VirtualMachine();
        virtualMachineAqa.setValueInstance("4");
        virtualMachineAqa.setValueOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        virtualMachineAqa.setDesiredResultVMClass(MachineClass.REGULAR.getName());
        virtualMachineAqa.setValueSeries(Series.N1.getName());
        virtualMachineAqa.setDesiredResultInstanceType("n1-standard-8");
        virtualMachineAqa.setDesiredResultLocalSSD("2x375");
        virtualMachineAqa.setDesiredResultRegion("Frankfurt");
        virtualMachineAqa.setDesiredResultCommitmentTerm(CommittedUsage.ONE_YEAR.getName());

        VirtualMachine virtualMachineDev = new VirtualMachine();
        virtualMachineDev.setValueInstance("1");
        virtualMachineDev.setValueOperatingSystem("Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS");
        virtualMachineDev.setDesiredResultVMClass(MachineClass.REGULAR.getName());
        virtualMachineDev.setValueSeries(Series.N2.getName());
        virtualMachineDev.setDesiredResultInstanceType("n2-standard-8");
        virtualMachineDev.setDesiredResultLocalSSD("1x375");
        virtualMachineDev.setDesiredResultRegion("Iowa");
        virtualMachineDev.setDesiredResultCommitmentTerm(CommittedUsage.ONE_YEAR.getName());
        return new Object[][] { {virtualMachineAqa},
                {virtualMachineDev} };
    }

    @Test(dataProvider = "data-provider")
    public void checkingCalculatorDataWithDP(VirtualMachine virtualMachine) {
        GoogleCloudHomePage googleCloudHomeHCPage = new GoogleCloudHomePage(driver);
        googleCloudHomeHCPage.openPage(URL_HOME_PAGE);
        GoogleCloudResultSearchPage googleCloudResultSearchHCPage = googleCloudHomeHCPage.searchOfQuery(search);
        GoogleCalculatorPage googleCalculatorHCPage = googleCloudResultSearchHCPage.openGoogleCalculator();
        googleCalculatorHCPage
                .activationSection()
                .selectInstances(virtualMachine.getValueInstance())
                .selectOperationSystem(virtualMachine.getValueOperatingSystem())
                .selectMachineClass(virtualMachine.getDesiredResultVMClass())
                .selectSeries(virtualMachine.getValueSeries())
                .selectMachineType(virtualMachine.getDesiredResultInstanceType())
                .selectLocalSSD(virtualMachine.getDesiredResultLocalSSD())
                .selectDatacenter(virtualMachine.getDesiredResultRegion())
                .selectCommitedUsage(virtualMachine.getDesiredResultCommitmentTerm())
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