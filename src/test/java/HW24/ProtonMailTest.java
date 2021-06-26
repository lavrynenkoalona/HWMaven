package HW24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.invisibilityOfElementWithText;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;

public class ProtonMailTest {
    WebDriver driver;
    WebDriverWait wait;
    String initialUrl = "https://protonmail.com/";
    String inboxMailBefore;
    String inboxMailAfter;

    //@BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(initialUrl);
        wait = new WebDriverWait(driver, 10);
    }

    //@Test
    public void authToSite() {
        driver.findElement(By.xpath("(//li [@class='action'])[1]")).click();
        driver.findElement(By.name("username")).sendKeys("a.light.na");
        driver.findElement(By.name("password")).sendKeys("Parol@882255");
        driver.findElement(By.id("login_btn")).click();
    }

        //@Test
        public void newEmailForm() throws InterruptedException {
            wait.until(presenceOfElementLocated(By.xpath("//button [@class='compose pm_button sidebar-btn-compose']")));
            inboxMailBefore = driver.findElement(By.xpath("//em [@class='navigationItem-counter']")).getText().replace("(","").replace(")","");
            driver.findElement(By.xpath("//button [@class='compose pm_button sidebar-btn-compose']")).click();
            try {
                Robot robot = new Robot();
                robot.keyPress(KeyEvent.VK_TAB);
                robot.keyRelease(KeyEvent.VK_TAB);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            wait.until(presenceOfElementLocated(By.xpath("//span [@ng-click='unminimize(message);']")));
            driver.findElement(By.xpath("//span [@ng-click='unminimize(message);']")).click();
            wait.until(presenceOfElementLocated(By.xpath("//div [@class='awesomplete']//child::input[1]")));
            WebElement to = driver.findElement(By.xpath("//div [@class='awesomplete']//child::input[1]"));
            to.click();
            to.sendKeys("a.light.na@protonmail" + Keys.TAB + Keys.TAB);
            WebElement subject = driver.findElement(By.xpath("//div [@class='row subjectRow composer-field-Subject composerSubject-container']//child::input[1]"));
            subject.click();
            subject.sendKeys("Test Mail" + Keys.TAB + Keys.TAB);
            By fileInput = By.xpath("(//input [@type='file'])[2]");
            String filePath;
            filePath = "C:/HWMavenAndTestNG/src/test/resources/TestText1.txt";
            driver.findElement(fileInput).sendKeys(filePath);
             WebElement sendButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div [@class='pull-right']//child::button[3]")));
            sendButton.click();
            //wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//button [@class='compose pm_button sidebar-btn-compose']"))));
            inboxMailAfter = driver.findElement(By.xpath("//em [@class='navigationItem-counter']")).getText().replace("(","").replace(")","");
            assertEquals(Integer.valueOf(inboxMailAfter), Integer.valueOf(inboxMailBefore+1));

        }


}
