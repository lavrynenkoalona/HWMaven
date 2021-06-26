package steps.Citrus;

import io.qameta.allure.Step;
import pages.Citrus.CitrusFilterPage;

public class CitrusFilterPageSteps {
    CitrusFilterPage citrusFilterPage = new CitrusFilterPage();

    @Step("Set Min And Max Price")
    public void setMinAndMaxPrice(String i, String i1) {
        citrusFilterPage.inputMinPrice(i);
        citrusFilterPage.inputMaxPrice(i1);
    }

    @Step("Set First And Second Memory")
    public void inputFirstAndSecondMemory() {
        citrusFilterPage.inputFirstMemory("6 Гб");
        citrusFilterPage.inputSecondMemory("8 Гб");
    }
}
