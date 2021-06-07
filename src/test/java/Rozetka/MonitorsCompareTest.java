package Rozetka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

//(singleThreaded = true)
public class MonitorsCompareTest {
    WebDriver driver;
    WebDriverWait wait;
    int minPrice = 4000;
    String initialUrl = "https://rozetka.com.ua/";
    int firstPrice = 0;
    int secondPrice;
    String firstMonitorName;
    String secondMonitorName;
    int a;
    int b;

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(initialUrl);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void closeBworser() {
        driver.quit();
    }

//    @BeforeMethod
//    public void navigateToSite() {
//        driver.get(initialUrl);
//    }

    @Test(priority = 1)
    public void findFistMonitor() {
        driver.navigate().to("https://rozetka.com.ua/computers-notebooks/c80089/");
        List<WebElement> products = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int counter = 1;
        for (WebElement p : products) {
            int a = Integer.parseInt(p.getText().replaceAll(" ", ""));
            if (a < minPrice) {
                firstPrice = a;
                driver.findElement(By.xpath("(//span[@class='goods-tile__price-value']//preceding::a[2])" + "[" + counter + "]")).click();
                break;
            }
            counter++;
        }
    }

    @Test(priority = 2)
    public void addMonitorToCompare() throws InterruptedException {
        wait.until(presenceOfElementLocated(By.xpath("//button [@class='compare-button ng-star-inserted']")));
        WebElement element = driver.findElement(By.xpath("//button [@class='compare-button ng-star-inserted']"));
        //Thread.sleep(10000);
        element.click();
        wait.until(presenceOfElementLocated(By.xpath("//rz-icon-counter//child::span")));
        assertEquals(driver.findElement(By.xpath("//rz-icon-counter//child::span")).getText(), "1");
    }

    @Test(priority = 3)
    public void getFistMonitorName() {
        wait.until(presenceOfElementLocated(By.xpath("//h1")));
        String firstMonitorName = driver.findElement(By.cssSelector("h1")).getText();
        driver.navigate().back();
    }

    @Test(priority = 4)
    public void findSecondMonitor() throws InterruptedException {
        List<WebElement> monitors = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int counter = 1;
        int secondPrice = 0;
        for (WebElement m : monitors) {
            int b = Integer.parseInt(m.getText().replaceAll(" ", ""));
            if (b < firstPrice) {
                secondPrice = b;
                driver.findElement(By.xpath("(//span[@class='goods-tile__price-value']//preceding::a[2])" + "[" + counter + "]")).click();
                break;
            }
            counter++;
        }
    }

    @Test(priority = 5)
    public void addSecondMonitorToCompare() throws InterruptedException {
        wait.until(presenceOfElementLocated(By.xpath("//button [@class='compare-button ng-star-inserted']")));
        WebElement element = driver.findElement(By.xpath("//button [@class='compare-button ng-star-inserted']"));
        //Thread.sleep(10000);
        element.click();
        wait.until(presenceOfElementLocated(By.xpath("//rz-icon-counter//child::span")));
        assertEquals(driver.findElement(By.xpath("//rz-icon-counter//child::span")).getText(), "2");
    }

    @Test(priority = 6)
    public void getSecondMonitorName() {
        wait.until(presenceOfElementLocated(By.xpath("//h1")));
        String secondMonitorName = driver.findElement(By.cssSelector("h1")).getText();
        driver.navigate().back();
    }

    @Test(priority = 7)
    public void checkComparePage() {
        wait.until(presenceOfElementLocated(By.xpath(" ")));
        WebElement compareIcon = driver.findElement(By.xpath("//rz-icon-counter/span"));
        compareIcon.click();
        wait.until(presenceOfElementLocated(By.xpath("//rz-comparison-category")));
        String firstName = driver.findElement(By.xpath("((//rz-compare-tile//a)[1])")).getText();
        String secondName = driver.findElement(By.xpath("((//rz-compare-tile//a)[2])")).getText();
        assertEquals(firstName, firstMonitorName);
        assertEquals(secondName, secondMonitorName);
        assertEquals(driver.findElement(By.xpath("(//div[@class='product__price product__price--red ng-star-inserted'])[1]")), a);
        assertEquals(driver.findElement(By.xpath("(//div[@class='product__price product__price--red ng-star-inserted'])[2]")), b);
    }

}

