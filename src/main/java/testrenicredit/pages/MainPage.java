package testrenicredit.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    @FindBy(xpath = "//div[@class='service__title']//a[@href='/contributions/']")
    private WebElement contributionsElement;

    public void goToContributionsPage() {
        clickToElement(contributionsElement);
    }

}
