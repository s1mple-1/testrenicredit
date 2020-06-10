package testrenicredit.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testrenicredit.steps.BaseSteps;

class BasePage {

    BasePage() {
        PageFactory.initElements(BaseSteps.getWebDriver(), this);
    }

    void clickToElement(WebElement webElement) {
        BaseSteps.webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    WebElement findElement(String xpath) {
        return BaseSteps.getWebDriver().findElement(By.xpath(xpath));
    }

    void moveToElement(WebElement webElement) {
        BaseSteps.actions.moveToElement(webElement).perform();
    }


    void scrollIntoView(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) BaseSteps.getWebDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false)", webElement);
    }

    void waitElementRefreshing(WebElement webElement) {
        BaseSteps.webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
        WebDriverWait webDriverWait = new WebDriverWait(BaseSteps.getWebDriver(), 10);
        webDriverWait.until(webDriver -> {
            String oldValue = webElement.getText();//берем старое значение целевого поля
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String newValue = webElement.getText();//получаем новое значение целевого поля
            return newValue.equals(oldValue);//если значение не равны ждем
        });
    }

}
