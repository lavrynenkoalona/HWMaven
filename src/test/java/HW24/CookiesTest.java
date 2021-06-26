package HW24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.*;
import static org.testng.AssertJUnit.assertNotNull;

public class CookiesTest {
    WebDriver driver;
    WebDriverWait wait;
    String initialUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    Set<Cookie> cookies;

    //@BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.navigate().to(initialUrl);
    }

    //@Test
    public void login() {
        wait.until(presenceOfElementLocated(By.name("btnLogin")));
        driver.findElement(By.name("uid")).click();
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("btnLogin")).click();
        wait.until(presenceOfElementLocated(By.xpath("//*[contains(@href,'Logout')]")));
        String button = driver.findElement(By.xpath("//*[contains(@href,'Logout')]")).getText();
        assertEquals(button,"Log out");
    }

    //@Test
    public void printCookies() {

        cookies = driver.manage().getCookies();
        assertNotNull("cookies is empty", cookies);
        System.out.println(this.cookies);
    }


    //@Test
    public void deletingCookie() {
        driver.manage().deleteAllCookies();
        Set<Cookie> cookiesAfterDelete = driver.manage().getCookies();
        assertTrue(cookiesAfterDelete.isEmpty());

    }

    //@Test
    public void xcheckAfterRefresh() {
        driver.navigate().refresh();
        String button2 = driver.findElement(By.xpath("//table//preceding::a[1]")).getText();
        assertEquals(button2,"Log out");
    }

}
