package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static String getTestMethodName(ITestResult itestResult) {
        return itestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment (value = "Page screenshot", type="image/png")
    public byte[] saveSScreenshotPNG(WebDriver driver) {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}", type ="text/plain")
    public static String saveTextLog (String message) {
        return message;
    }


    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {


    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
