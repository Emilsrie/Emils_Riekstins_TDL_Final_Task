import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.ConfigFileReader;
import common.TestBase;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import pages.frames.FormFrame;
import pages.frames.SimpleAccordeonFrame;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class FinalTask1 extends TestBase {

    static ExtentReports report;

    ConfigFileReader configFileReader = new ConfigFileReader();

    private WebDriver driver = getDriver();

    @BeforeClass
    public static void staticTest() throws IOException {
        String reportPath =
                "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "reports" + File.separator +
                "TestReport.html";

        String configPath =
                "src" + File.separator +
                "main" + File.separator +
                "resources" + File.separator +
                "configs" + File.separator +
                "extentreports" + File.separator +
                "spark-config.xml";

        report = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
        sparkReporter.loadXMLConfig(configPath);
        sparkReporter.config().setReportName("Final Task Extent Report");
        report.setSystemInfo("Project", "TDL Summer School");
        report.setSystemInfo("Author", "Emils Riekstins");
        report.attachReporter(sparkReporter);
    }

    @Test(groups = "smoke", description = "Smoke test")
    public void firstTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Testing new account creation");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.INFO, "Home page is visible");
        } else {
            test.log(Status.INFO, "Home page is NOT visible");
        }

        // Navigating to dialog boxes page
        homePage.clickDialogBox();

        // Initializing dialog boxes page
        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        if (dialogBoxesPage.isInitialized()) {
            test.log(Status.INFO, "Dialog boxes page is visible");
        } else {
            test.log(Status.INFO, "Dialog boxes is NOT visible");
        }

        // Clicking on "Create New User"
        // TODO add try catch for NullPointerException
        this.driver = switchToIframe("css=div.single_tab_div.resp-tab-content.resp-tab-content-active > p:nth-child(1) > iframe");
        FormFrame formFrame = new FormFrame(driver);
        formFrame.clickCreateNewUserButton();
        if (formFrame.isInitialized()) {
            test.log(Status.INFO, "Form frame is visible");
        } else {
            test.log(Status.INFO, "Form frame is NOT visible");
        }

        // Waiting for form to open for screenshot
        waitToLoad();
        // Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        // Entering my own information and take screenshot
        formFrame.signUp();
        waitToLoad();
        String base64Screenshot2 = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot2).build());

        // Creating new user with entered information
        formFrame.clickCreateAnAccountButton();
        // Checking if new user has been created
        if (formFrame.newUserIsCreated()) {
            test.log(Status.INFO, "New user is created");
        } else {
            test.log(Status.INFO, "New user is NOT created");
        }
    }

    // TODO close popup ads
    @Test(groups = "smoke", description = "Smoke test")
    public void secondTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Testing section 2 display");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.INFO, "Home page is visible");
        } else {
            test.log(Status.INFO, "Home page is NOT visible");
        }

        // Clicking on tabs button
        homePage.clickTabsButton();

        // Initializing tabs page
        TabsPage tabsPage = new TabsPage(driver);
        if (tabsPage.isInitialized()) {
            test.log(Status.INFO, "Tabs page is visible");
        } else {
            test.log(Status.INFO, "Tabs page is NOT visible");
        }

        // Clicking on "section 2"
        // TODO add test.log
        // TODO add try catch for NullPointerException
        this.driver = switchToIframe("xpath=//div[1]/p/iframe");
        SimpleAccordeonFrame simpleAccordeonFrame = new SimpleAccordeonFrame(driver);
        simpleAccordeonFrame.clickSection2Button();

        // Output selection 2 text
        // TODO correcty output text (p:nth-child(1))
        String selection2Text = simpleAccordeonFrame.getSelection2Text();
        if (!selection2Text.isEmpty()) {
            System.out.println("Selection 2 text: " + simpleAccordeonFrame.getSelection2Text());
            test.log(Status.INFO, "Selection 2 text output in console");
        } else {
            test.log(Status.INFO, "Selection 2 text NOT output in console");
        }

        // Wait for dropdown to finish opening for the screenshot
        waitToLoad();
        // Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }

    @AfterMethod
    public void endTask() {
       closeDriver();
    }

    @AfterClass
    public static void endTest() {
        report.flush();
    }
}
