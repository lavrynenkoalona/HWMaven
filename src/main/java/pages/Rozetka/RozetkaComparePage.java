package pages.Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RozetkaComparePage {

    WebDriver driver;
    WebDriverWait wait;

    By monitorCompareLink= By.xpath("//a [contains(@class,'comparison-modal')]");
    By monitorOfComparePage =By.xpath("(//a [contains(@class,'product__heading')])[1]");
    By firstCompareMonitorName= By.xpath("(//a [contains(@class,'product__heading')])[1]");
    By secondCompareMonitorName= By.xpath("(//a [contains(@class,'product__heading')])[2]");
    public RozetkaComparePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);

    }

    public void waitMonitorCompareLink() {
        wait.until(presenceOfElementLocated(monitorCompareLink));
    }


    public void clickMonitorCompareLink() {
        driver.findElement(monitorCompareLink).click();
    }

    public void waitPageCompare() {
        wait.until(presenceOfElementLocated(monitorOfComparePage));
    }

    public String firstName() {
        return driver.findElement(firstCompareMonitorName).getText();
    }

    public String secondName() {
        return driver.findElement(secondCompareMonitorName).getText();
    }

}
