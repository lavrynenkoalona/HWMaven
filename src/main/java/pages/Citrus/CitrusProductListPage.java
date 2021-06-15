package pages.Citrus;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.ShouldBe;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class CitrusProductListPage {

    ElementsCollection productNames = $$x("//div [@class='product-card__name']");
    ElementsCollection productPrices = $$x("//div[@class='prices__price']");

    public void clickOnProductByName(String productName) {
        $x("//a/span[contains (text(),'" + productName + "')]").click();
    }

    public String getProductPriceByName(String productName) {
        return $x("//h5[contains(text(),'" + productName + "')]/../../..//span[@class='price-number']").getText();
    }

    public void addProductToBasket(String productName) {
        $x("//h5[contains(text(),'" + productName + "')]/../following::div[@class='itm-footer-desc']//child::i").click();
    }

    public ElementsCollection getProductNames() {
        return productNames;
    }

    public ElementsCollection getProductPrices() {
        return productPrices;

    }

    public boolean isCorrectSearch(ElementsCollection list,String filterParameter) {
        return list.stream().allMatch(e->e.getText().contains(filterParameter));
    }

    public boolean isCorrectPriceFilter(ElementsCollection list) {
        return list.stream().noneMatch(w -> {
            String s = w.getText().replace("грн", "").replaceAll(" ","").trim();
            int k = Integer.parseInt(s);
            return k <= 4000 || k >= 10000;
        });
    }

    public boolean getMemory(ElementsCollection list,String memoryFirstParameter,String memorySecondParameter) {
        return list.stream().allMatch(e->e.getText().contains(memoryFirstParameter) || e.getText().contains(memorySecondParameter));
    }


}
