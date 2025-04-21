package CucumberStepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.remote.RemoteWebDriver;
import yehiaEngine.assertions.SoftAssertHelper;
import yehiaEngine.loggers.AllureReportLogger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import static yehiaEngine.browserActions.WindowManager.closeCurrentWindow;
import static yehiaEngine.browserActions.WindowManager.navigateToURL;
import static yehiaEngine.driverManager.BrowserFactory.getDriver;
import static yehiaEngine.driverManager.BrowserFactory.openBrowser;
import static yehiaEngine.loggers.LogHelper.setLogFileName;
import static yehiaEngine.loggers.Screenshot.captureFailure;
import static yehiaEngine.loggers.Screenshot.captureSuccess;
import static yehiaEngine.managers.PropertiesManager.getPropertiesValue;

public class BaseSteps {

    protected ThreadLocal<RemoteWebDriver> isolatedDriver;;
    protected String productName;
    protected List<String> productNames = new ArrayList<>();

    @Before (order = 1)
    public void OpenBrowser() throws MalformedURLException {
        //Open Browser
        isolatedDriver = openBrowser();

        //Perform actions on Window
        navigateToURL(getDriver(isolatedDriver),getPropertiesValue("baseUrlWeb"));
    }

    @After (order = 1)
    public void closeBrowser () {
        //Close Browser
       closeCurrentWindow(getDriver(isolatedDriver));
    }



    @Before (order = 2)
    public void setLogFiles (Scenario scenario) {
        //Set Log File for Test Methods
        setLogFileName("Test - "+scenario.getName());
    }

    @After (order = 2)
    public void takeScreenshots(Scenario scenario) throws IOException {

        //Take Screenshot after every Passed test
        if (!scenario.isFailed() && getDriver(isolatedDriver) != null)
            captureSuccess(getDriver(isolatedDriver), scenario);

        //Take Screenshot after every failed test
        else if (scenario.isFailed() && getDriver(isolatedDriver) != null)
            captureFailure(getDriver(isolatedDriver), scenario);

        //Log Summery Report for Soft Assertion Errors after Every Run
        SoftAssertHelper.reportSoftAssertionErrors(scenario);

        //Upload the Log Files to Allure Report
        AllureReportLogger.uploadLogFileIntoAllure("Test - "+scenario.getName());
    }
}


