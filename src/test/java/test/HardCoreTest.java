package test;

import model.VirtualMachine;
import org.testng.annotations.Test;
import pages.GeneratingRandomMailPage;
import pages.GoogleCalculatorHCPage;
import pages.GoogleCloudHomeHCPage;
import pages.GoogleCloudResultSearchHCPage;
import service.CreatorVM;

/**
 * При выполнении задания необходимо использовать возможности Selenium WebDriver, юнит-тест фреймворка и концепцию Page Object. Автоматизировать следующий сценарий:
 *
 * 1. Открыть https://cloud.google.com/
 * 2. Нажав кнопку поиска по порталу вверху страницы, ввести в поле поиска"Google Cloud Platform Pricing Calculator"
 * 3. Запустить поиск, нажав кнопку поиска.
 * 4. В результатах поиска кликнуть "Google Cloud Platform Pricing Calculator" и перейти на страницу калькулятора.
 * 5. Активировать раздел COMPUTE ENGINE вверху страницы
 * 6. Заполнить форму следующими данными:
 *     * Number of instances: 4
 *     * What are these instances for?: оставить пустым
 *     * Operating System / Software: Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS
 *     * VM Class: Regular
 *     * Instance type: n1-standard-8    (vCPUs: 8, RAM: 30 GB)
 *     * Выбрать Add GPUs
 *         * Number of GPUs: 1
 *         * GPU type: NVIDIA Tesla V100
 *     * Local SSD: 2x375 Gb
 *     * Datacenter location: Frankfurt (europe-west3)
 *     * Commited usage: 1 Year
 * 7. Нажать Add to Estimate
 * 8. Выбрать пункт EMAIL ESTIMATE
 * 9. В новой вкладке открыть https://10minutemail.com или аналогичный сервис для генерации временных email'ов
 * 10. Скопировать почтовый адрес сгенерированный в 10minutemail
 * 11. Вернуться в калькулятор, в поле Email ввести адрес из предыдущего пункта
 * 12. Нажать SEND EMAIL
 * 13. Дождаться письма с рассчетом стоимости и проверить что Total Estimated Monthly Cost в письме совпадает с тем, что отображается в калькуляторе
 */

public class HardCoreTest extends BaseTest {

    private String URL_MAIL = "http://www.yopmail.com/ru/email-generator.php";
    private String URL_HOME_PAGE = "https://cloud.google.com";
    private String search = "Google Cloud Platform Pricing Calculator";

    @Test
    public void checkingCalculatorData() {
        VirtualMachine vm = CreatorVM.withCredentialsFromProperty();
        GoogleCloudHomeHCPage googleCloudHomeHCPage = new GoogleCloudHomeHCPage(driver);
        googleCloudHomeHCPage.openPage(URL_HOME_PAGE);
        GoogleCloudResultSearchHCPage googleCloudResultSearchHCPage = googleCloudHomeHCPage.searchOfQuery(search);
        GoogleCalculatorHCPage googleCalculatorHCPage = googleCloudResultSearchHCPage.openGoogleCalculator();
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
                .addMailAddress(mail);
        String sumInMessage = generatingRandomMailPage
                .openMessage()
                .getRentalAmountIndicatedInTheEmail();
        generatingRandomMailPage.validateSumAmountToMessage(sumInCalculator, sumInMessage);
    }
}