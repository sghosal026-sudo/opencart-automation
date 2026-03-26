package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import core.ContextManager;
import core.TestContext;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utilities.ExtentReporter;
import utilities.RunManager;
import utilities.ScreenshotUtil;

public class TestListeners implements ITestListener {

    ExtentReports reports;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        String testRunFolderName = context.getCurrentXmlTest().getName();
        RunManager.setTestName(testRunFolderName);
        reports = ExtentReporter.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = getTestCaseName(result);

        ExtentTest test = reports.createTest(testName);
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
        extentTest.get().pass(
                "Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath(result)).build()
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable());

        extentTest.get().fail(
                "Screenshot",
                MediaEntityBuilder.createScreenCaptureFromPath(getScreenshotPath(result)).build()
        );
    }

    @Override
    public void onFinish(ITestContext context) {
        reports.flush();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.get().skip(result.getThrowable());
    }

    private String getTestCaseName(ITestResult result) {
        String description = result.getMethod().getDescription();
        if (description != null && !description.isEmpty()) {
            return description;
        }

        return result.getMethod().getMethodName();
    }

    public String getScreenshotPath(ITestResult result) {
        String path = "";
        try {
            TestContext context = ContextManager.getContext();
            if (context == null) {
                return path;
            }

            WebDriver driver = context.getDriver();
            path = ScreenshotUtil.captureScreenshot(driver, getTestCaseName(result));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}
