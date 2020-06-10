package testrenicredit.steps;

import io.qameta.allure.Attachment;
import testrenicredit.pages.ContributionsPage;
import testrenicredit.utils.AllureUtils;

import java.util.Map;

public class ContributionsPageSteps {


    public void chooseCurrencyByCode(String code) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.chooseCurrencyByCode(code);
    }


    public ContributionsPageSteps fillFields(Map<String, String> fields) {
        fields.forEach(this::fillField);
        return this;
    }

    private void fillField(String fieldName, String value) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.fillFields(fieldName, value);
    }

    public void chooseOptions() {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.choseCheckBox();
    }


    public ContributionsPageSteps checkFields(Map<String, String> resultFields) {
        resultFields.forEach(this::checkField);
        return this;
    }

    private void checkField(String fieldName, String value) {
        ContributionsPage contributionsPage = new ContributionsPage();
        contributionsPage.checkCalculatorResults(fieldName, value);
    }
}
