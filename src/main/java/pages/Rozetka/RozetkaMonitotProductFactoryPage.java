package pages.Rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RozetkaMonitotProductFactoryPage {
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath ="//button [contains(@class,'compare-button')]" )
    WebElement productCompare;
    @FindBy (xpath = "//rz-icon-counter//child::span")
   WebElement compareIcon;
    @FindBy(xpath = "//h1")
    WebElement productTitle;
    @FindBy(xpath = "//h1")
    WebElement firstMonitor;
    @FindBy(xpath = "//h1")
    WebElement secondMonitor;


    public RozetkaMonitotProductFactoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver,this);
    }


    public void waitCompareButton() throws AWTException {
        Robot r = new Robot();
        r.mouseMove(300, 300);
        wait.until(visibilityOf(productCompare));

    }

    public void clickProductCompareButton() {
     productCompare.click();

    }

    public void waitCompareIcon() {
        wait.until(visibilityOf(compareIcon));

    }

    public void clickCompareIcon() {
       compareIcon.click();

    }

    public void waitProductTitle() {
        wait.until(visibilityOf(productTitle));
    }

    public String getFirstMonitorName() {
      return firstMonitor.getText();
    }

    public String getSecondMonitorName() {
      return secondMonitor.getText();
    }
}
