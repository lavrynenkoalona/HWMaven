package Citrus;

import com.codeborne.selenide.Condition;
import javafx.scene.layout.Priority;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Citrus.CitrusBasketPage;
import pages.Citrus.CitrusHomePage;
import pages.Citrus.CitrusProductListPage;
import pages.Citrus.CitrusProductPage;

import static com.codeborne.selenide.Selenide.open;

public class CitrusBasketTest {
    CitrusHomePage citrusHomePage;
    CitrusProductListPage citrusProductListPage;
    CitrusProductPage citrusProductPage;
    CitrusBasketPage citrusBasketPage;

    String productName="Apple iPhone 11 64Gb Black";
    String searchValue="Apple iPhone 11";
    @BeforeClass
    public void workWithPagesObjects() {
      open("https://www.citrus.ua/");
        citrusHomePage = new CitrusHomePage();
        citrusProductListPage = new CitrusProductListPage();
        citrusProductPage = new CitrusProductPage();
        citrusBasketPage = new CitrusBasketPage();
    }
    @Test (priority = 1)
    public void addProductPageBasketTest() {
        citrusHomePage.navigateMenuLinkSmartphony();
        citrusHomePage.clickLinkInMenu("Apple");

        citrusProductListPage.clickOnProductByName(productName);

        String productPrice = citrusProductPage.getProductPrice().replace("₴","").trim();
        citrusProductPage.clickByButton();
        citrusProductPage.closeProductBasket();
        citrusProductPage.clickBasketIcon();
        citrusBasketPage.getBasket().shouldBe(Condition.visible);
        citrusBasketPage.getProductNamesFromBasket().shouldHaveSize(1);
        citrusBasketPage.getProductNamesFromBasket().get(0).shouldHave(Condition.text(productName));
        citrusBasketPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));
        citrusBasketPage.clearBasket();
    }

    @Test
    public void addProductListingPageBasketTest() {
        citrusHomePage.searchProduct(searchValue);
        String productPrice= citrusProductListPage.getProductPriceByName(productName);
        citrusProductListPage.addProductToBasket(productName );
        citrusProductPage.closeProductBasket();
        citrusProductPage.clickBasketIcon();
        citrusBasketPage.getBasket().shouldBe(Condition.visible);
        citrusBasketPage.getProductNamesFromBasket().shouldHaveSize(1);
        citrusBasketPage.getProductNamesFromBasket().get(0).shouldHave(Condition.text(productName));
        citrusBasketPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));
    }

}
