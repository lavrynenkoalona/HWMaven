package steps.Citrus;

import io.qameta.allure.Step;
import pages.Citrus.CitrusHomePage;

public class CitrusHomePageSteps {
   CitrusHomePage citrusHomePage = new CitrusHomePage();

   @Step("Click link in menu")
    public void clickLinkInMenu(String s) {
        citrusHomePage.navigateMenuLinkSmartphony();
        citrusHomePage.clickLinkInMenu(s);
    }

    @Step("Search Product")
    public void searchProduct(String searchValue) {
        citrusHomePage.searchProduct(searchValue);
    }
}
