package by.htp.vk.listener;

import by.htp.vk.driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


public class ScreenshotListener implements ITestListener {
    private int index = 0;
    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        takeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestContext) {
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
    }

    private void takeScreenshot() {
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            File screen = new File(String.format("./screenshots/screenshot_%s.png", index));
            index++;
            FileUtils.copyFile(screenCapture, screen);
            System.setProperty("org.uncommons.reportng.escape-output", "false");

            Reporter.log("<img src=\"" + screen.getAbsolutePath() + "\"/>");
        } catch (IOException e) {
            System.out.println("Failed to save screenshot: "
                    + e.getLocalizedMessage());
        }

    }
}
