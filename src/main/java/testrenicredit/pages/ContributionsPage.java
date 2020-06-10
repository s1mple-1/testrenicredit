package testrenicredit.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContributionsPage extends BasePage {
    @FindBy(xpath = "//span[text()='Рубли']")
    private WebElement rubElement;

    @FindBy(xpath = "//span[text()='Доллары США']")
    private WebElement usdElement;

    @FindBy(xpath = "//span[text()='Евро']")
    private WebElement eurElement;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amountField;

    @FindBy(xpath = "//div[@class='jq-selectbox__select-text']")
    private WebElement countOfMonthField;

    @FindBy(xpath = "//input[@name='replenish']")
    private WebElement replenishField;

    @FindBy(xpath = "//span[text()='Ежемесячная капитализация']")
    private WebElement capitalizationCheckBox;

    @FindBy(xpath = "//span[text()='Частичное снятие']")
    private WebElement withdrawCheckBox;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    private WebElement earnedCheckElement;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    private WebElement replenishCheckElement;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    private WebElement resultCheckField;


    public void chooseCurrencyByCode(String currencyCode) {
        switch (currencyCode) {
            case "RUB":
                clickToElement(rubElement);
                waitElementRefreshing(resultCheckField);
                break;
            case "USD":
                clickToElement(usdElement);
                waitElementRefreshing(resultCheckField);
                break;
            case "EUR":
                clickToElement(eurElement);
                waitElementRefreshing(resultCheckField);
                break;
        }
    }

    public void fillFields(String fieldName, String value) {
        switch (fieldName) {
            case "Сумма вклада":
                fillField(amountField, value);
                break;
            case "На срок":
                fillDate(value);
                break;
            case "Ежемесячное пополнение":
                fillField(replenishField, value);
                break;
        }
    }

    private void fillField(WebElement webElement, String value) {
        clickToElement(webElement);
        webElement.sendKeys(value);
        waitElementRefreshing(resultCheckField);
    }

    private void fillDate(String value) {
        clickToElement(countOfMonthField);
        String xPath = String.format("//li[text()='%s месяцев']", value);
        WebElement currentDate = findElement(xPath);
        currentDate.click();
        waitElementRefreshing(resultCheckField);
    }

    public void choseCheckBox(String checkBoxName) {
        switch (checkBoxName) {
            case "Ежемесячная капитализация":
                clickToElement(capitalizationCheckBox);
                waitElementRefreshing(resultCheckField);
                break;
            case "Частичное снятие":
                clickToElement(withdrawCheckBox);
                waitElementRefreshing(resultCheckField);
                break;
        }
    }

    public void checkCalculatorResults(String fieldName, String value) {
        String actual;
        switch (fieldName) {
            case "Начислено %":
                actual = earnedCheckElement.getText();
                Assert.assertEquals(String.format("Ожидаемое значение %s, фактическое %s", value, actual), value, actual);
                break;
            case "Пополнение":
                actual = replenishCheckElement.getText();
                Assert.assertEquals(String.format("Ожидаемое значение %s, фактическое %s", value, actual), value, actual);
                break;
            case "К снятию":
                actual = resultCheckField.getText();
                Assert.assertEquals(String.format("Ожидаемое значение %s, фактическое %s", value, actual), value, actual);
                break;
        }
    }
}
