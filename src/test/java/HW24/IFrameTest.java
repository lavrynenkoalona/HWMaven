package HW24;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.swing.*;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class IFrameTest {
    WebDriver driver;
    WebDriverWait wait;
    String initialUrl = "http://demo.guru99.com/test/guru99home/";

    @BeforeClass
    public void setupBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void firstIFrame() throws InterruptedException {

        driver.navigate().to(initialUrl);
        WebElement iFrame = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrame);
        wait.until(presenceOfElementLocated(By.xpath("//button[@class='ytp-large-play-button ytp-button']")));

        WebElement playButton = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        playButton.click();

        wait.until(presenceOfElementLocated(By.xpath("//button[@aria-label='Пауза (k)']")));
        WebElement pauseButton = driver.findElement(By.xpath("//button[@aria-label='Пауза (k)']"));
        Actions actionMouseMove=new Actions(driver);
        actionMouseMove.moveToElement(pauseButton).build().perform();
        Assert.assertTrue(driver.findElement(By.xpath("//button[@aria-label='Пауза (k)']")).isDisplayed(),"Button is visible");

        driver.switchTo().parentFrame();
        WebElement elem = driver.findElement(By.xpath("(//h3)[1]"));
        Actions actionMouseMoveOut=new Actions(driver);
        actionMouseMoveOut.moveToElement(elem).build().perform();

        WebElement iFrame2 = driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrame2);
        Assert.assertTrue(driver.findElement(By.xpath("//button[@aria-label='Пауза (k)']")).isDisplayed(),"Button is hidden");

    }


}
