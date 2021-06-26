package steps.Citrus;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.Citrus.CitrusFilterPage;
import pages.Citrus.CitrusProductListPage;

import static com.codeborne.selenide.Selenide.$x;

public class CitrusProductListPageSteps {
    CitrusProductListPage citrusProductListPage = new CitrusProductListPage();

    @Step("click Product by Name")
    public void clickProductByName(String productName) {
        citrusProductListPage.clickOnProductByName(productName);
    }

    @Step("Add Product To Basket")
    public String addProductToBasket(String productName){
        String productPrice= citrusProductListPage.getProductPriceByName(productName);
       citrusProductListPage.addProductToBasket(productName );
       return productPrice;
    }

    @Step("Check Names")
    public void checkNames() {
        SelenideElement element = $x("//img[contains(@title,'Samsung')]").shouldBe(Condition.visible);
        citrusProductListPage.getProductNames();
        Assert.assertTrue(citrusProductListPage.isCorrectSearch(citrusProductListPage.getProductNames(),"Samsung"));

    }

    @Step("Check Prices")
    public void checkPrices() {
        citrusProductListPage.getProductPrices();
        Assert.assertTrue(citrusProductListPage.isCorrectPriceFilter(citrusProductListPage.getProductPrices()));
    }

    @Step("Check Names and Memories")
    public void checkNamesAndMemories() {
        SelenideElement element = $x("//img[contains(@title,'Xiaomi')]").shouldBe(Condition.visible);
        citrusProductListPage.getProductNames();
        Assert.assertTrue(citrusProductListPage.isCorrectSearch(citrusProductListPage.getProductNames(),"Xiaomi"));
        citrusProductListPage.getMemory(citrusProductListPage.getProductNames(),"8 Гб","6 Гб");
        Assert.assertTrue(citrusProductListPage.getMemory(citrusProductListPage.getProductNames(),"8 Гб","6 Гб"));
    }
}
