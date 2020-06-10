package testrenicredit.defsteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import testrenicredit.steps.ContributionsPageSteps;
import testrenicredit.steps.MainPageSteps;
import testrenicredit.utils.AllureUtils;

public class DefSteps {
    ContributionsPageSteps contributionsPageSteps = new ContributionsPageSteps();

    @When("Переходим на страницу Вклады")
    public void go() {
        new MainPageSteps().goToContributionsPage();
    }

    @When("Выбираем валюту {string}")
    public void chooseCurrency(String code) {
        contributionsPageSteps.chooseCurrencyByCode(code);
    }

    @When("Заполняем поля калькулятора вкладов")
    public void filling(DataTable dataTable) {
        contributionsPageSteps.fillFields(dataTable.asMap(String.class, String.class));
    }

    @When("Выбираем опцию")
    public void chooseOptions() {
        AllureUtils.takeScreenshot();
        contributionsPageSteps.chooseOptions();
    }

    @When("Проверяем поля результатов калькулятора вкладов")
    public void checking(DataTable dataTable) {
        contributionsPageSteps.checkFields(dataTable.asMap(String.class, String.class));
    }


}
