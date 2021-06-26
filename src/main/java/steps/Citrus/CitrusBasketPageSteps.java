package steps.Citrus;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.Citrus.CitrusBasketPage;

public class CitrusBasketPageSteps {
    CitrusBasketPage citrusBasketPage = new CitrusBasketPage();

    @Step("Verify Details of Basket Page")
    public void citrusBasketPageVerifyDetails(String productName,String productPrice) {
        citrusBasketPage.getBasket().shouldBe(Condition.visible);
        citrusBasketPage.getProductNamesFromBasket().shouldHaveSize(1);
        citrusBasketPage.getProductNamesFromBasket().get(0).shouldHave(Condition.text(productName));
        citrusBasketPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));
    }

    @Step("Clear basket")
    public void clearBasket() {
        citrusBasketPage.clearBasket();
    }
}
