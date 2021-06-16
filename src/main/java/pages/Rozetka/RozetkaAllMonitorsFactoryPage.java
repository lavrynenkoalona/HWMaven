package pages.Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RozetkaAllMonitorsFactoryPage {
    WebDriver driver;
    WebDriverWait wait;
    int counter = 1;
    int counter2 = 1;
    int minPrice=4000;
    String allMonitorsLink ="https://rozetka.com.ua/computers-notebooks/c80089/";
    int firstSuitablePrice;
    int secondSuitablePrice;
    List<WebElement> products;
    List<WebElement> monitors;
    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    List<WebElement> allPrices;

    String xPathTitle = "(//span[@class='goods-tile__price-value']//preceding::a[2])[%d]";
    @FindBy(xpath ="(\"(//span[@class='goods-tile__price-value']//preceding::a[2])\" + \"[\" + counter2 + \"]\")")
    WebElement secondMonitorTitleLink;


    public RozetkaAllMonitorsFactoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver,this);

    }


    public int getSecondSuitablePrice() {
        return secondSuitablePrice;
    }

    public void navigateToAllMonitorPage (){
        driver.navigate().to(allMonitorsLink);
    }

    public void findMonitorPriceLessThanMinPrice() {
        List<WebElement> products = allPrices;
        for (WebElement p : products) {
            firstSuitablePrice = Integer.parseInt(p.getText().replaceAll(" ", ""));
            if (firstSuitablePrice < minPrice) {
                minPrice = firstSuitablePrice;
                driver.findElement(By.xpath(String.format(xPathTitle, counter))).click();
                break;
            }
            counter++;
        }
    }


    public void findMonitorPriceLessThanCurrentPrice() {
        List<WebElement> products = allPrices;
        for (WebElement m : products) {
            int secondSuitablePrice = Integer.parseInt(m.getText().replaceAll(" ", ""));
            if (secondSuitablePrice < minPrice) {
                driver.findElement(By.xpath(String.format(xPathTitle, counter2))).click();
                break;
            }
            counter2++;
        }

    }
}
