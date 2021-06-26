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

import java.util.List;
import java.util.Optional;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class FindStylusUAResultTest {
    WebDriver driver;
    WebDriverWait wait;

    //@BeforeClass
    public void setupBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

   // @AfterClass
    public void closeBworser(){
        driver.quit();
    }

    //@BeforeMethod
    public void navigateAction(){
        driver.get("https://google.com/ncr");
    }
    //@Test
    public void testSearchByEnterClick() {
        driver.findElement(By.name("q")).sendKeys("iphone kyiv buy" + Keys.ENTER);
        WebElement stats = wait.until(presenceOfElementLocated(By.cssSelector("#result-stats")));

//        assertTrue(stats.getText().contains("results"));
//    }

   // @Test
    //public void testSearchStylusUA() {
        int nextPage=1;

        while(nextPage<5){

//            List<WebElement> stylus=driver.findElements(By.xpath("//cite[@text='https://stylus.ua/']"));
            List<WebElement> stylus=driver.findElements(By.xpath("//cite"));
            Optional<WebElement> any = stylus.stream().filter(e -> e.getText().contains("stylus.ua")).findAny();

            if(any.isPresent()){
                System.out.println("STYLUS.UA found on " + nextPage + " page");
                break;
            }else {
                driver.findElements(By.xpath("//a[@id='pnnext']")).get(0).click();
                nextPage++;
            }
                System.out.println("STYLUS.UA not found on first 5 pages");
        }
    }

}
