package Citrus;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.Citrus.CitrusBasketPage;
import pages.Citrus.CitrusHomePage;
import pages.Citrus.CitrusProductListPage;
import pages.Citrus.CitrusProductPage;
import steps.Citrus.CitrusBasketPageSteps;
import steps.Citrus.CitrusHomePageSteps;
import steps.Citrus.CitrusProductListPageSteps;
import steps.Citrus.CitrusProductPageSteps;
import utils.LogListener;
import utils.TestListener;

import static com.codeborne.selenide.Selenide.open;
@Listeners(TestListener.class)
public class CitrusBasketTest {
//    CitrusHomePage citrusHomePage;
//    CitrusProductListPage citrusProductListPage;
//    CitrusProductPage citrusProductPage;
//    CitrusBasketPage citrusBasketPage;
    CitrusHomePageSteps citrusHomePageSteps;
    CitrusProductListPageSteps citrusProductListPageSteps;
    CitrusProductPageSteps citrusProductPageSteps;
    CitrusBasketPageSteps citrusBasketPageSteps;

    String productName="Apple iPhone 11 64Gb Black";
    String searchValue="Apple iPhone 11";
    @BeforeClass
    public void workWithPagesObjects() {
      open("https://www.citrus.ua/");
        //citrusHomePage = new CitrusHomePage();
//        citrusProductListPage = new CitrusProductListPage();
//        citrusProductPage = new CitrusProductPage();
//        citrusBasketPage = new CitrusBasketPage();
        citrusHomePageSteps=new CitrusHomePageSteps();
        citrusProductListPageSteps = new CitrusProductListPageSteps();
        citrusProductPageSteps= new CitrusProductPageSteps();
        citrusBasketPageSteps = new CitrusBasketPageSteps();
    }


    @Test (priority = 1)
    public void addProductPageBasketTest() {
//        citrusHomePage.navigateMenuLinkSmartphony();
//        citrusHomePage.clickLinkInMenu("Apple");
        citrusHomePageSteps.clickLinkInMenu("Apple");
//        citrusProductListPage.clickOnProductByName(productName);
        citrusProductListPageSteps.clickProductByName(productName);

//        String productPrice = citrusProductPage.getProductPrice().replace("₴","").trim();
//        citrusProductPage.clickByButton();
        String productPrice = citrusProductPageSteps.clickOnByButton();
//        citrusProductPage.closeProductBasket();
//        citrusProductPage.clickBasketIcon();
        citrusProductPageSteps.clickBasketIcon();
//        citrusBasketPage.getBasket().shouldBe(Condition.visible);
//        citrusBasketPage.getProductNamesFromBasket().shouldHaveSize(1);
//        citrusBasketPage.getProductNamesFromBasket().get(0).shouldHave(Condition.text(productName));
//        citrusBasketPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));
        citrusBasketPageSteps.citrusBasketPageVerifyDetails(productName,productPrice);
//        citrusBasketPage.clearBasket();
        citrusBasketPageSteps.clearBasket();
    }


    @Test
    public void addProductListingPageBasketTest() {
        //citrusHomePage.searchProduct(searchValue);
        citrusHomePageSteps.searchProduct(searchValue);
//        String productPrice= citrusProductListPage.getProductPriceByName(productName);
//        citrusProductListPage.addProductToBasket(productName );
        String productPrice=citrusProductListPageSteps.addProductToBasket(productName);
//        citrusProductPage.closeProductBasket();
//        citrusProductPage.clickBasketIcon();
//        citrusProductPageSteps.clickBasketIcon();
//        citrusBasketPage.getBasket().shouldBe(Condition.visible);
//        citrusBasketPage.getProductNamesFromBasket().shouldHaveSize(1);
//        citrusBasketPage.getProductNamesFromBasket().get(0).shouldHave(Condition.text(productName));
//        citrusBasketPage.getBasketTotalPrice().shouldHave(Condition.text(productPrice));
        citrusBasketPageSteps.citrusBasketPageVerifyDetails(productName,productPrice);
    }

}
