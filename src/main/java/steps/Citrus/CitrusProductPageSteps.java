package steps.Citrus;

import io.qameta.allure.Step;
import pages.Citrus.CitrusProductPage;

public class CitrusProductPageSteps {
    CitrusProductPage citrusProductPage= new CitrusProductPage();
    @Step("Click on By Button")
    public String clickOnByButton(){
        String productPrice = citrusProductPage.getProductPrice().replace("₴","").trim();
        citrusProductPage.clickByButton();
        return productPrice;
    }
    @Step("click Basket Icon")
    public void clickBasketIcon() {
        citrusProductPage.closeProductBasket();
        citrusProductPage.clickBasketIcon();
    }

}
