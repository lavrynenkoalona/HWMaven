package pages.Rozetka;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class RozetkaCompareFactoryPage {

    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath ="//a [contains(@class,'comparison-modal')]")
    WebElement monitorCompareLink;
    @FindBy(xpath ="(//a [contains(@class,'product__heading')])[1]")
    WebElement monitorOfComparePage;
    @FindBy(xpath ="(//a [contains(@class,'product__heading')])[1]")
   WebElement firstCompareMonitorName;
    @FindBy(xpath ="//a [contains(@class,'product__heading')])[2]")
    WebElement secondCompareMonitorName;
    public RozetkaCompareFactoryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver,this);

    }

    public void waitMonitorCompareLink() {
        wait.until(visibilityOf(monitorCompareLink));
    }


    public void clickMonitorCompareLink() {
        monitorCompareLink.click();
    }

    public void waitPageCompare() {
        wait.until(visibilityOf(monitorOfComparePage));
    }

    public String firstName() {
        return firstCompareMonitorName.getText();
    }

    public String secondName() {
        return secondCompareMonitorName.getText();
    }

}
