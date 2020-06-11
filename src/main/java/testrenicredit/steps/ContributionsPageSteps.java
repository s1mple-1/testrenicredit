package testrenicredit.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testrenicredit.pages.ContributionsPage;

public class ContributionsPageSteps {

    @When("Выбираем валюту {string}")
    public void chooseCurrencyByCode(String code) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.chooseCurrencyByCode(code);
    }

    @When("Заполняем поля калькулятора вкладов")
    public void fillFields(DataTable dataTable) {
        ContributionsPage contributionsPage = new ContributionsPage();
        dataTable.asMap(String.class, String.class)
                .forEach((field, value) -> contributionsPage.fillFields((String) field, (String) value));

    }

    @When("Выбираем опцию {string}")
    public void chooseOptions(String checkBoxName) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.choseCheckBox(checkBoxName);
    }

    @Then("Проверяем результаты рассчета калькулятора вкладов")
    public void checkFields(DataTable dataTable) {
        ContributionsPage contributionsPage = new ContributionsPage();
        dataTable.asMap(String.class, String.class)
                .forEach((field, value) -> contributionsPage.checkCalculatorResults((String) field, (String) value));
    }
}
