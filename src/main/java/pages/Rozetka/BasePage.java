package pages.Rozetka;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public void backPreviousPage() {
        driver.navigate().back();
    }
}
