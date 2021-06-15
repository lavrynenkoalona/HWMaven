package Citrus;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Citrus.CitrusFilterPage;
import pages.Citrus.CitrusHomePage;
import pages.Citrus.CitrusProductListPage;

import static com.codeborne.selenide.Selenide.*;

public class CitrusFilterTest {
    CitrusHomePage citrusHomePage;
    CitrusProductListPage citrusProductListPage;
    CitrusFilterPage citrusFilterPage;
    String priceFilterParameter ="Samsung";
    String memoryFilterParameter="Xiaomi";

    @BeforeClass
    public void workWithPagesObjects(){
        open("https://www.citrus.ua/");
        citrusHomePage = new CitrusHomePage();
        citrusProductListPage = new CitrusProductListPage();
        citrusFilterPage = new CitrusFilterPage();
    }

    @Test
    public void usePriceFilter() {
        citrusHomePage.navigateMenuLinkSmartphony();
        citrusHomePage.clickLinkInMenu(priceFilterParameter);
        citrusFilterPage.inputMinPrice("4000");
        citrusFilterPage.inputMaxPrice("10000");
        SelenideElement element = $x("//img[contains(@title,'Samsung')]").shouldBe(Condition.visible);
        citrusProductListPage.getProductNames();
        Assert.assertTrue(citrusProductListPage.isCorrectSearch(citrusProductListPage.getProductNames(),"Samsung"));
        citrusProductListPage.getProductPrices();
        Assert.assertTrue(citrusProductListPage.isCorrectPriceFilter(citrusProductListPage.getProductPrices()));

    }

    @Test
    public void useMemorySizeFilter() {
        citrusHomePage.navigateMenuLinkSmartphony();
        citrusHomePage.clickLinkInMenu(memoryFilterParameter);
        citrusFilterPage.inputFirstMemory("6 Гб");
        citrusFilterPage.inputSecondMemory("8 Гб");
        SelenideElement element = $x("//img[contains(@title,'Xiaomi')]").shouldBe(Condition.visible);
        citrusProductListPage.getProductNames();
        Assert.assertTrue(citrusProductListPage.isCorrectSearch(citrusProductListPage.getProductNames(),"Xiaomi"));
//       citrusProductListPage.getMemory(citrusProductListPage.getProductNames(),"8 Гб","6 Гб");
//        Assert.assertTrue(citrusProductListPage.getMemory(citrusProductListPage.getProductNames(),"8 Гб","6 Гб"));

    }


}
