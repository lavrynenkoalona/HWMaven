package pages.Citrus;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class CitrusBasketPage {

    SelenideElement basketWidget=$x("//div[@class='el-dialog el-dialog--medium']");
    ElementsCollection basketProductNames=$$x("//a[contains(@class,'ctrs-basket-product__name')]");
    SelenideElement basketTotalPrice = $x("//span[contains(@class,'ctrs-basket-footer__new-price')]");
    SelenideElement basketDeleteButton= $x("//div[contains(@class,'delete-icon')]");
    SelenideElement basketDeleteButtonYes= $x("//button[contains(@class,'delete-button')]");

    public SelenideElement getBasket() {
        return basketWidget;
    }

    public ElementsCollection getProductNamesFromBasket() {
        return basketProductNames;
    }

    public SelenideElement getBasketTotalPrice() {
        return basketTotalPrice ;
    }

    public void clearBasket() {
        basketDeleteButton.click();
        basketDeleteButtonYes.click();

    }
}
