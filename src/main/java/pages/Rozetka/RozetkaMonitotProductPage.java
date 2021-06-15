package pages.Rozetka;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class RozetkaMonitotProductPage {
    WebDriver driver;
    WebDriverWait wait;
    By productCompare =By.xpath("//button [contains(@class,'compare-button')]");
    By compareIcon = By.xpath("//rz-icon-counter//child::span");
    By productTitle= By.xpath("//h1");
    By firstMonitor=By.cssSelector("h1");
    By secondMonitor= By.cssSelector("h1");


    public RozetkaMonitotProductPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    public void waitCompareButton() throws AWTException {
        Robot r = new Robot();
        r.mouseMove(300, 300);
        wait.until(presenceOfElementLocated(productCompare));

    }

    public void clickProductCompareButton() {
        driver.findElement(productCompare).click();

    }

    public void waitCompareIcon() {
        wait.until(presenceOfElementLocated(compareIcon));

    }

    public void clickCompareIcon() {
        driver.findElement(compareIcon).click();

    }

    public void waitProductTitle() {
        wait.until(presenceOfElementLocated(productTitle));
    }

    public String getFirstMonitorName() {
      return driver.findElement(firstMonitor).getText();
    }

    public String getSecondMonitorName() {
      return driver.findElement(secondMonitor).getText();
    }
}
