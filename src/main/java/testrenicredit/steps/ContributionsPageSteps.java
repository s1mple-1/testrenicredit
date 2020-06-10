package testrenicredit.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testrenicredit.pages.ContributionsPage;

import java.util.Map;

public class ContributionsPageSteps {

    @When("Выбираем валюту {string}")
    public void chooseCurrencyByCode(String code) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.chooseCurrencyByCode(code);
    }


    @When("Заполняем поля калькулятора вкладов")
    public void fillFields(DataTable dataTable) {
        fillFields(dataTable.asMap(String.class, String.class));
    }

    private ContributionsPageSteps fillFields(Map<String, String> fields) {
        fields.forEach(this::fillField);
        return this;
    }

    private void fillField(String fieldName, String value) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.fillFields(fieldName, value);
    }

    @When("Выбираем опцию {string}")
    public void chooseOptions(String checkBoxName) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.choseCheckBox(checkBoxName);
    }


    @Then("Проверяем результаты рассчета калькулятора вкладов")
    public void checkFields(DataTable dataTable) {
        checkFields(dataTable.asMap(String.class, String.class));
    }

    private ContributionsPageSteps checkFields(Map<String, String> resultFields) {
        resultFields.forEach(this::checkField);
        return this;
    }

    private void checkField(String fieldName, String value) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.checkCalculatorResults(fieldName, value);
    }
}
