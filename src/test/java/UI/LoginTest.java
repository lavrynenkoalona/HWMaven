package UI;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

    WebDriver driver;
    WebDriverWait wait;
    String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public void closeBworser() {
        driver.quit();
    }

    @Test
    public void positiveLogin() {
        driver.get(url);
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("btnLogin")).click();
//        WebElement logoutLink = wait.until(presenceOfElementLocated(By.linkText("Log out")));
//        logoutLink.click();

        driver.switchTo().alert().accept();
        String resultUrl = driver.getCurrentUrl();

        assertEquals(url, resultUrl);
    }

    @Test
    public void InvalidLogin1() {
        driver.get(url);
        driver.findElement(By.name("uid")).sendKeys("123");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("btnLogin")).click();
//        WebElement logoutLink = wait.until(presenceOfElementLocated(By.linkText("Log out")));
//        logoutLink.click();

        assertEquals(driver.switchTo().alert().getText(),"User or password is invalid");
        driver.switchTo().alert().accept();

        String resultUrl = driver.getCurrentUrl();
        assertEquals(url, resultUrl);
    }

    @Test
    public void InvalidLogin2() {
        driver.get(url);
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("123");
        driver.findElement(By.name("btnLogin")).click();
//        WebElement logoutLink = wait.until(presenceOfElementLocated(By.linkText("Log out")));
//        logoutLink.click();

        assertEquals(driver.switchTo().alert().getText(),"User or password is invalid");
        driver.switchTo().alert().accept();

        String resultUrl = driver.getCurrentUrl();
        assertEquals(url, resultUrl);
    }

    @Test
    public void InvalidLogin3() {
        driver.get(url);
        driver.findElement(By.name("uid")).sendKeys("");
        driver.findElement(By.name("password")).sendKeys("");
        driver.findElement(By.name("btnLogin")).click();
//        WebElement logoutLink = wait.until(presenceOfElementLocated(By.linkText("Log out")));
//        logoutLink.click();

        assertEquals(driver.switchTo().alert().getText(),"User or password is invalid");
        driver.switchTo().alert().accept();

        String resultUrl = driver.getCurrentUrl();
        assertEquals(url, resultUrl);
    }

    @Test
    public void InvalidLogin4() {
        driver.get(url);
        driver.findElement(By.name("uid")).sendKeys("123");
        driver.findElement(By.name("password")).sendKeys("GURU99");
        driver.findElement(By.name("btnLogin")).click();
//        WebElement logoutLink = wait.until(presenceOfElementLocated(By.linkText("Log out")));
//        logoutLink.click();

        assertEquals(driver.switchTo().alert().getText(),"User or password is invalid");
        driver.switchTo().alert().accept();

        String resultUrl = driver.getCurrentUrl();
        assertEquals(url, resultUrl);
    }

    @Test
    public void InvalidLogin5() {
        driver.get(url);
        driver.findElement(By.name("uid")).sendKeys("Guru99");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("btnLogin")).click();
//        WebElement logoutLink = wait.until(presenceOfElementLocated(By.linkText("Log out")));
//        logoutLink.click();

        assertEquals(driver.switchTo().alert().getText(),"User or password is invalid");
        driver.switchTo().alert().accept();

        String resultUrl = driver.getCurrentUrl();
        assertEquals(url, resultUrl);
    }

    @Test
    public void InvalidLogin6() {
        driver.get(url);
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("1303");
        driver.findElement(By.name("btnLogin")).click();
//        WebElement logoutLink = wait.until(presenceOfElementLocated(By.linkText("Log out")));
//        logoutLink.click();

        assertEquals(driver.switchTo().alert().getText(),"User or password is invalid");
        driver.switchTo().alert().accept();

        String resultUrl = driver.getCurrentUrl();
        assertEquals(url, resultUrl);
    }

}