package HW24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

public class DragAndDropTest {
    WebDriver driver;
    WebDriverWait wait;
    String initialUrl = "http://demo.guru99.com/test/drag_drop.html";
    Set<Cookie> cookies;

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.navigate().to(initialUrl);
    }

    @Test
    public void dragAndDrop() {
        WebElement From1=driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement To1=driver.findElement(By.xpath("//*[@id='bank']/li"));
        WebElement From2=driver.findElement(By.xpath("//*[@id='credit1']/a"));
        WebElement To2=driver.findElement(By.xpath("//*[@id='loan']/li"));
        WebElement From3=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement To3=driver.findElement(By.xpath("//*[@id='amt7']/li"));
        WebElement From4=driver.findElement(By.xpath("//*[@id='fourth']/a"));
        WebElement To4=driver.findElement(By.xpath("//*[@id='amt8']/li"));

        Actions act=new Actions(driver);
        act.dragAndDrop(From1, To1).build().perform();
        act.dragAndDrop(From2, To2).build().perform();
        act.dragAndDrop(From3, To3).build().perform();
        act.dragAndDrop(From4, To4).build().perform();

        if(driver.findElement(By.xpath("//a[contains(text(),'Perfect')]")).isDisplayed()){
            System.out.println("Perfect Displayed !!!");
        } else {
            System.out.println("Perfect not Displayed !!!");
        }
    }
}
