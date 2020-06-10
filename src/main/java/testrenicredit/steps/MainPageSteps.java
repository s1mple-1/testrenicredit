package testrenicredit.steps;

import io.cucumber.java.en.When;
import testrenicredit.pages.MainPage;

public class MainPageSteps {

    @When("Переходим на страницу Вклады")
    public void goToContributionsPage() {
        new MainPage().goToContributionsPage();
    }

}
