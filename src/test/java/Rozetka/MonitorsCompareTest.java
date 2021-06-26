package Rozetka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Rozetka.BaseePage;
import pages.Rozetka.RozetkaAllMonitorsFactoryPage;
import pages.Rozetka.RozetkaCompareFactoryPage;
import pages.Rozetka.RozetkaMonitotProductFactoryPage;

import java.awt.*;

import static org.testng.Assert.assertEquals;

//(singleThreaded = true)
public class MonitorsCompareTest {
    WebDriver driver;
    WebDriverWait wait;
    String initialUrl = "https://rozetka.com.ua/";
    int firstPrice;
    int secondPrice;
    String first;
    String second;
    String firstName;
    String secondName;
    RozetkaAllMonitorsFactoryPage allMonitors;
    RozetkaMonitotProductFactoryPage monitorProduct;
    RozetkaCompareFactoryPage comparePage;
    BaseePage base;

    //@BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(initialUrl);
        wait = new WebDriverWait(driver, 10);
        base = new BaseePage(driver);
    }

    //@AfterClass
    public void closeBworser() {
        driver.quit();
    }

//    @BeforeMethod
//    public void navigateToSite() {
//        driver.get(initialUrl);
//    }

    //@Test(priority = 1)
    public void findFistMonitor() {
        allMonitors = new RozetkaAllMonitorsFactoryPage(driver);
        allMonitors.navigateToAllMonitorPage();
        allMonitors.findMonitorPriceLessThanMinPrice();
    }

    //@Test(priority = 2)
    public void addMonitorToCompare() throws InterruptedException, AWTException {
        monitorProduct = new RozetkaMonitotProductFactoryPage(driver);
        monitorProduct.waitCompareButton();
        monitorProduct.clickProductCompareButton();
        monitorProduct.waitCompareIcon();
        assertEquals(driver.findElement(By.xpath("//rz-icon-counter//child::span")).getText(), "1");
    }

    //@Test(priority = 3)
    public void getFistMonitorName() {
        monitorProduct.waitProductTitle();
        first = monitorProduct.getFirstMonitorName();
        base.backPreviousPage();
    }

    //@Test(priority = 4)
    public void findSecondMonitor() throws InterruptedException {
        allMonitors.findMonitorPriceLessThanCurrentPrice();
    }

    //@Test(priority = 5)
    public void addSecondMonitorToCompare() throws InterruptedException, AWTException {
        monitorProduct = new RozetkaMonitotProductFactoryPage(driver);
        monitorProduct.waitCompareButton();
        monitorProduct.clickProductCompareButton();
        monitorProduct.waitCompareIcon();
        assertEquals(driver.findElement(By.xpath("//rz-icon-counter//child::span")).getText(), "2");
    }

    //@Test(priority = 6)
    public void getSecondMonitorName() {
        monitorProduct.waitProductTitle();
       second= monitorProduct.getSecondMonitorName();
    }

    //@Test(priority = 7)
    public void checkComparePage() throws AWTException {
        comparePage=new RozetkaCompareFactoryPage(driver);
        monitorProduct. waitCompareIcon();
        monitorProduct.clickCompareIcon();
        comparePage.waitMonitorCompareLink();
        comparePage.clickMonitorCompareLink();
        comparePage.waitPageCompare();
        firstName = comparePage.firstName();
        secondName = comparePage.secondName();
        assertEquals(firstName,first);
        assertEquals(secondName, second);
    }

}

