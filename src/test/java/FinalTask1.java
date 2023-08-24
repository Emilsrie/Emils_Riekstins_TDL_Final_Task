import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.ConfigFileReader;
import common.TestBase;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import pages.*;
import pages.frames.*;

import java.io.File;
import java.io.IOException;

public class FinalTask1 extends TestBase {

    static ExtentReports report;

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

    // TODO [maybe] create BasePage class (or interface) to be extended (or implement) by all other pages for test.log method creation in TestBase to clean up code
    // TODO if popup ad opens, then close it
    @Test//(groups = "smoke", description = "Smoke test")
    public void firstTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test1: testing new account creation");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // 1. Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.PASS, "Home page is visible");
        } else {
            test.log(Status.FAIL, "Home page is NOT visible");
        }

        // 2. Navigating to dialog boxes page
        homePage.clickDialogBox();

        // Initializing dialog boxes page
        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        if (dialogBoxesPage.isInitialized()) {
            test.log(Status.PASS, "Dialog boxes page is visible");
        } else {
            test.log(Status.FAIL, "Dialog boxes is NOT visible");
        }

        // Clicking on "Create New User"
        this.driver = switchToIframe("css=div.single_tab_div.resp-tab-content.resp-tab-content-active > p:nth-child(1) > iframe");
        FormFrame formFrame = new FormFrame(driver);
        formFrame.clickCreateNewUserButton();
        if (formFrame.isInitialized()) {
            test.log(Status.PASS, "Form frame is visible");
        } else {
            test.log(Status.FAIL, "Form frame is NOT visible");
        }

        waitToLoad(); // Waiting for form to open for screenshot
        // Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        formFrame.signUp(); // Entering my own information
        waitToLoad(); // Waiting for form to open for screenshot
        // Creating a screenshot
        String base64Screenshot2 = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot2).build());

        // Creating new user with entered information
        formFrame.clickCreateAnAccountButton();
        // Checking if new user has been created
        if (formFrame.newUserIsCreated()) {
            test.log(Status.PASS, "New user is created");
        } else {
            test.log(Status.FAIL, "New user is NOT created");
        }
    }

    // TODO close popup ads
    @Test//(groups = "smoke", description = "Smoke test")
    public void secondTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test2: testing section 2 display");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.PASS, "Home page is visible");
        } else {
            test.log(Status.FAIL, "Home page is NOT visible");
        }

        // Clicking on tabs button
        homePage.clickTabsButton();

        // Initializing tabs page
        TabsPage tabsPage = new TabsPage(driver);
        if (tabsPage.isInitialized()) {
            test.log(Status.PASS, "Tabs page is visible");
        } else {
            test.log(Status.FAIL, "Tabs page is NOT visible");
        }

        // Hiding popup ads
//        WebElement popupAds = getWebElement("css=ins[data-adsbygoogle-status='done'][data-anchor-status='displayed']");
//        jsExecutor.executeScript("arguments[0].style.display = 'none';", popupAds);

        // Clicking on "section 2"
        // TODO add test.log
        // TODO add try catch for NullPointerException
        this.driver = switchToIframe("xpath=//div[1]/p/iframe");
        SimpleAccordeonFrame simpleAccordeonFrame = new SimpleAccordeonFrame(driver);
        simpleAccordeonFrame.clickSection2Button();


        waitToLoad(); // Wait for dropdown to finish opening for the screenshot
        // Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        this.driver = switchToDefault();
    }

    @Test//(groups = "smoke", description = "Smoke test")
    public void thirdTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test3: testing random color and value");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.PASS, "Home page is visible");
        } else {
            test.log(Status.FAIL, "Home page is NOT visible");
        }

        homePage.clickProgressBarButton(); // Navigating to progress bar tab

        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        progressBarPage.clickRandomProgressBarButton();

        this.driver = switchToIframe("xpath=//div[2]/p/iframe");
        RandomProgressBarFrame randomProgressBarFrame = new RandomProgressBarFrame(driver);
        randomProgressBarFrame.clickRandomColorButton();
        randomProgressBarFrame.clickRandomValueDeterminateButton();

        this.driver = switchToDefault();
    }

    @Test//(groups = "regression", description = "Regression test")
    public void fourthTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test4: testing popup window closing");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.PASS, "Home page is visible");
        } else {
            test.log(Status.FAIL, "Home page is NOT visible");
        }

        homePage.clickDialogBox(); // Navigating to dialog boxes page

        // Initializing dialog boxes page
        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        if (dialogBoxesPage.isInitialized()) {
            test.log(Status.PASS, "Dialog boxes page is visible");
        } else {
            test.log(Status.FAIL, "Dialog boxes is NOT visible");
        }

        // Clicking on messagebox tab
        dialogBoxesPage.clickMessageBoxButton();

        // Switching to message box frame
        this.driver = switchToIframe("xpath=//div[2]/p[1]/iframe");
        MessageBoxFrame messageBoxFrame = new MessageBoxFrame(driver);
        messageBoxFrame.clickOkButton(); // Clicking on message box ok button

        if (!messageBoxFrame.isPopupBoxVisible()) {
            test.log(Status.PASS, "Popup page closed");
        } else {
            test.log(Status.FAIL, "Popup page NOT closed");
        }

        this.driver = switchToDefault();

        // Switching to forms tab
        dialogBoxesPage.clickFormButton();
        // Switching to message box tab
        dialogBoxesPage.clickMessageBoxButton();

        this.driver = switchToIframe("xpath=//div[2]/p[1]/iframe");
        if (!messageBoxFrame.isPopupBoxVisible()) {
            test.log(Status.PASS, "Popup window not visible");
        } else {
            test.log(Status.FAIL, "Popup window IS visible");
        }

        // Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        this.driver = switchToDefault();
    }

    @Test//(groups = "regression", description = "Regression test")
    public void fifthTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test5: testing search field");
        test.log(Status.INFO, "The test is started");

        openUrl2();



        // Initializing homepage
        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);
        if (autoCompletePage.isInitialized()) {
            test.log(Status.PASS, "Auto complete page is visible");
        } else {
            test.log(Status.FAIL, "Auto complete page is NOT visible");
        }

        this.driver = switchToIframe("xpath=//div[1]/p/iframe");
        CategoriesFrame categoriesFrame = new CategoriesFrame(driver);
        categoriesFrame.inputInSearchField();
        categoriesFrame.clickAndersAnderssonButton();

        // Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        this.driver = switchToDefault();
    }

//    @AfterMethod
//    public void endTask() {
//       closeDriver();
//    }

    @AfterClass
    public static void endTest() {
        report.flush();
    }
}
