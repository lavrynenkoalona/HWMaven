package pages.Citrus;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CitrusProductPage {

    SelenideElement productPrice=$x("//b[@class='buy-section__new-price']");
    SelenideElement productBuyButton=$x("//button[contains(@class,'buy-section__buy-btn')]");
    SelenideElement basketClose=$x("//button/i[contains(@class,'el-icon-close')]");
    SelenideElement basketIcon=$x("//div/i[contains(@class,'icon-new-citrus-cart')]");

    public String getProductPrice() {
 return productPrice.getText().trim();
    }

    public void clickByButton() {
        productBuyButton.click();

    }

    public void closeProductBasket() {
        basketClose.click();
    }

    public void clickBasketIcon() {
        basketIcon.click();
    }
}
