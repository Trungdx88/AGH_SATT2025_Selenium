package Report;

import Common.Constant.Constant;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class ExtentTestNGITestListener implements ITestListener{
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, "Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());

        try {
            TakesScreenshot ts = (TakesScreenshot) Constant.WEBDRIVER;
            String screenshotBase64 = ts.getScreenshotAs(OutputType.BASE64);
            test.get().addScreenCaptureFromBase64String(screenshotBase64, "Failed Screenshot");
        } catch (Exception e) {
            test.get().log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
