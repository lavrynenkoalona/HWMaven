package L25examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class TabsTest {
    WebDriver driver;
    WebDriverWait wait;
//    String initialUrl = "https://rozetka.com.ua/";

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }
        @Test
    public void testTabs() {
        driver.get("https://business.twitter.com/start-advertising");

         String oldTab = driver.getWindowHandle();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.linkText("About the company")));
        driver.findElement(By.linkText("About the company")).click();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));

        // Do what you want here, you are in the new tab

       driver.close();
        // change focus back to old tab
        driver.switchTo().window(oldTab);

            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_CONTROL);
                robot.keyPress(KeyEvent.VK_T);
                robot.keyRelease(KeyEvent.VK_CONTROL);
                robot.keyRelease(KeyEvent.VK_T);
            } catch (AWTException e) {
                e.printStackTrace();
            }

        // Do what you want here, you are in the old tab
    }

}
