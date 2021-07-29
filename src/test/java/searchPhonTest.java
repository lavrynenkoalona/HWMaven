package Rozetka;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class searchPhonTest {
    WebDriver driver;
    WebDriverWait wait;
    String initialUrl = "https://rozetka.com.ua/";

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void closeBworser(){
        driver.quit();
    }

    @BeforeMethod
    public void navigateAction() {
        driver.get(initialUrl);
    }

    @Test
    public void searchPhoneByManufacturer() {
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("samsung" + Keys.ENTER);
        WebElement stats = wait.until(presenceOfElementLocated(By.xpath("//input[@name='search']")));
        WebElement element = driver.findElement(By.xpath("//span[text()='Мобильные телефоны']"));
        element.click();
        WebElement apple = driver.findElement(By.xpath("//label [@for='Apple']"));
        apple.click();
        WebElement huawei = driver.findElement(By.xpath("//label [@for='Huawei']"));
        huawei.click();
        List<WebElement> phones = driver.findElements(By.xpath("//span [@class='goods-tile__title']"));
        int k=0;
        while (k>phones.size()){
        for (WebElement p : phones) {
            if ((p.getText().contains("Apple")) || (p.getText().contains("Huawei")) || (p.getText().contains("Samsung"))) {
                break;
            } else {
                System.out.println("Incorrect Filter");
            }}
        k++;
        }
    }

    @Test
    public void searchPhoneByPrice() {
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("samsung" + Keys.ENTER);
        WebElement stats = wait.until(presenceOfElementLocated(By.xpath("//input[@name='search']")));
        WebElement element = driver.findElement(By.xpath("//span[text()='Мобильные телефоны']"));
        element.click();
        WebElement minPrice =driver.findElement(By.xpath("//input[@formcontrolname='min']"));
                minPrice.clear();
                minPrice.sendKeys("5000");
        WebElement maxPrice=driver.findElement(By.xpath("//input[@formcontrolname='max']"));
               maxPrice.clear();
                maxPrice.sendKeys("15000" + Keys.ENTER);
        List<WebElement> products = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int k=0;
        int max=15000;
        int min=5000;
        while (k>products.size()){
        for (WebElement p : products) {
            int a = Integer.parseInt(p.getText().replaceAll(" ", ""));
            if ((a < 15000) || (a > 5000)) {
                break;
            } else {
                System.out.println("Incorrect Filter");
            }}
            k++;       }
    }
}

