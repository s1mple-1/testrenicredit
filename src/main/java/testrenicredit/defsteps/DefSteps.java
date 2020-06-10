package testrenicredit.defsteps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.When;
import testrenicredit.steps.ContributionsPageSteps;
import testrenicredit.steps.MainPageSteps;
import testrenicredit.utils.AllureUtils;

public class DefSteps {
    ContributionsPageSteps contributionsPageSteps = new ContributionsPageSteps();

    @When("Переходим на страницу Вклады")
    public void goToContributionsPage() {
        new MainPageSteps().goToContributionsPage();
    }

    @When("Выбираем валюту {string}")
    public void chooseCurrencyByCode(String code) {
        contributionsPageSteps.chooseCurrencyByCode(code);
    }

    @When("Заполняем поля калькулятора вкладов")
    public void fillFields(DataTable dataTable) {
        contributionsPageSteps.fillFields(dataTable.asMap(String.class, String.class));
    }

    @When("Выбираем опцию {string}")
    public void chooseOptions(String checkBoxName) {
        AllureUtils.takeScreenshot();
        contributionsPageSteps.chooseOptions(checkBoxName);
    }

    @When("Проверяем поля результатов калькулятора вкладов")
    public void checkFields(DataTable dataTable) {
        contributionsPageSteps.checkFields(dataTable.asMap(String.class, String.class));
    }


}
