package pages.Citrus;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class CitrusFilterPage {
    SelenideElement minPrice=$x("//div[@class='price el-input']/input");
    SelenideElement maxPrice=$x("(//div[@class='price el-input']/input)[2]");


    public void inputMinPrice(String s) {
       minPrice.val(s).pressEnter();
    }

    public void inputMaxPrice(String s) {
        maxPrice.val(s).pressEnter();
    }

    public void inputFirstMemory(String s) {
      $x("//a[(text()='"+s+"')]/../../span[contains(@class,'el-checkbox__input')]");
    }

    public void inputSecondMemory(String s) {
        $x("//a[(text()='"+s+"')]/../../span[contains(@class,'el-checkbox__input')]");
    }
}
