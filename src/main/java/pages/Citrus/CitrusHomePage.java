package pages.Citrus;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;
public class CitrusHomePage {
    SelenideElement smartphonyMenuLink=$x("//main[@class='home-page']//a[@href='/smartfony/']/span[@class='title']");
    SelenideElement searchInput =$("#search-input");

    public void navigateMenuLinkSmartphony() {
        smartphonyMenuLink.hover();

    }

    public void clickLinkInMenu(String linkText) {
    $x("//main[@class='home-page']//a/span[text()='" + linkText +"']").click();
    }

    public void searchProduct(String searchValue) {
        searchInput.val(searchValue).pressEnter();
    }
}
