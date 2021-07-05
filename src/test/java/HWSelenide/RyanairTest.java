package HWSelenide;

import org.testng.annotations.Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.*;

public class RyanairTest {

    @Test
    public void ticketSearchRyanair() throws InterruptedException {
        Configuration.timeout = 15000;
        open("https://www.ryanair.com/");
        $("[class='cookie-popup-with-overlay__button']").click();
        $("#input-button__departure").clear();
        $("#input-button__departure").val("Vienna");
        $("[data-id='VIE']").click();
        $("#input-button__destination").clear();
        $("#input-button__destination").val("Kyiv");
        $("[data-id='KBP']").click();
        $("div[data-ref='calendar-btn-next-month']").click();
        $("div[data-id='2021-08-19']").click();
        $("div[data-id='2021-08-22']").click();
        $x("//div[@class='counter__button-wrapper--enabled'][1]").click();
        $("[class*='passengers__confirm-button']").click();
        $("button[data-ref='flight-search-widget__cta']").click();

        $$("[class*='card-info__cols-container']").shouldHaveSize(2);
        $$("[class*='day-of-month--selected']").get(0).shouldHave(Condition.text("19"));
        //$$("[class*='date-item__month--selected']").get(0).shouldHave(Condition.text("Aug"));
        $$("[class*='day-of-month--selected']").get(1).shouldHave(Condition.text("22"));
        //RyanairTest$$("[class*='date-item__month--selected']").get(1).shouldHave(Condition.text("Aug"));
        $("[class*='details__bottom-bar b2']").shouldHave(Condition.text("2"));
    }
}
