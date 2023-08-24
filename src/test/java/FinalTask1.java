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

    @Test(groups = "regression", description = "Regression test 1")
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

        // 3. Clicking on "Create New User"
        this.driver = switchToIframe("css=div.single_tab_div.resp-tab-content.resp-tab-content-active > p:nth-child(1) > iframe");
        FormFrame formFrame = new FormFrame(driver);
        formFrame.clickCreateNewUserButton();
        if (formFrame.isInitialized()) {
            test.log(Status.PASS, "Form frame is visible");
        } else {
            test.log(Status.FAIL, "Form frame is NOT visible");
        }

        waitToLoad(); // Waiting for form to open for screenshot
        // 4. Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        // 5. and 6. clearing fields and entering my own information
        formFrame.signUp();
        waitToLoad(); // Waiting for form to open for screenshot

        // 8. Creating a screenshot
        String base64Screenshot2 = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot2).build());

        // 9. Creating new user with entered information
        formFrame.clickCreateAnAccountButton();

        // 10. Checking if new user has been created
        if (formFrame.newUserIsCreated()) {
            test.log(Status.PASS, "New user is created");
        } else {
            test.log(Status.FAIL, "New user is NOT created");
        }
    }

    @Test(groups = "smoke", description = "Smoke test 1")
    public void secondTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test2: testing section 2 display");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // 1. Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.PASS, "Home page is visible");
        } else {
            test.log(Status.FAIL, "Home page is NOT visible");
        }

        // 2. Clicking on tabs button
        homePage.clickTabsButton();
        // Initializing tabs page
        TabsPage tabsPage = new TabsPage(driver);
        if (tabsPage.isInitialized()) {
            test.log(Status.PASS, "Tabs page is visible");
        } else {
            test.log(Status.FAIL, "Tabs page is NOT visible");
        }

        // Hiding popup ads
        //WebElement popupAds = getWebElement("css=ins[data-adsbygoogle-status='done'][data-anchor-status='displayed']");
        //jsExecutor.executeScript("arguments[0].style.display = 'none';", popupAds);

        // Switching to simple accordion frame
        this.driver = switchToIframe("xpath=//div[1]/p/iframe");
        SimpleAccordeonFrame simpleAccordeonFrame = new SimpleAccordeonFrame(driver);

        // 3. Clicking on "section 2"
        simpleAccordeonFrame.clickSection2Button();

        // 4. validate that the section 2 has been expanded
        if (simpleAccordeonFrame.section2IsInitialized()) {
            test.log(Status.PASS, "Section 2 is initialized");
        } else {
            test.log(Status.FAIL, "Section 2 is NOT initialized");
        }

        waitToLoad(); // Wait for dropdown to finish opening for the screenshot

        // 5. Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        this.driver = switchToDefault();
    }

    @Test(groups = "regression", description = "Regression test 2")
    public void thirdTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test3: testing random color and value");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // 1. Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.PASS, "Home page is visible");
        } else {
            test.log(Status.FAIL, "Home page is NOT visible");
        }

        // 2. Navigating to progress bar tab
        homePage.clickProgressBarButton();
        ProgressBarPage progressBarPage = new ProgressBarPage(driver);
        progressBarPage.clickRandomProgressBarButton();

        // Switching to random progress bar frame
        this.driver = switchToIframe("xpath=//div[2]/p/iframe");
        RandomProgressBarFrame randomProgressBarFrame = new RandomProgressBarFrame(driver);

        // 3. Clicking on random color button
        randomProgressBarFrame.clickRandomColorButton();

        // 4. Clicking on random value
        randomProgressBarFrame.clickRandomValueDeterminateButton();

        // 5. Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        this.driver = switchToDefault();
    }

    @Test(groups = "smoke", description = "Smoke test 2")
    public void fourthTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test4: testing popup window closing");
        test.log(Status.INFO, "The test is started");

        openUrl();
        // 1. Initializing homepage
        HomePage homePage = new HomePage(driver);
        if (homePage.isInitialized()) {
            test.log(Status.PASS, "Home page is visible");
        } else {
            test.log(Status.FAIL, "Home page is NOT visible");
        }

        // 2.  Navigating to dialog boxes page
        homePage.clickDialogBox();
        // Initializing dialog boxes page
        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        if (dialogBoxesPage.isInitialized()) {
            test.log(Status.PASS, "Dialog boxes page is visible");
        } else {
            test.log(Status.FAIL, "Dialog boxes is NOT visible");
        }

        // 3. Clicking on messagebox tab
        dialogBoxesPage.clickMessageBoxButton();

        // Switching to message box frame
        this.driver = switchToIframe("xpath=//div[2]/p[1]/iframe");
        MessageBoxFrame messageBoxFrame = new MessageBoxFrame(driver);
        // 4. Clicking on message box ok button
        messageBoxFrame.clickOkButton();

        // 5. Validating that the message box is no longer displayed
        if (!messageBoxFrame.isPopupBoxVisible()) {
            test.log(Status.PASS, "Popup page closed");
        } else {
            test.log(Status.FAIL, "Popup page NOT closed");
        }

        this.driver = switchToDefault(); // switching to default driver

        // 6. Switching to forms tab
        dialogBoxesPage.clickFormButton();

        // 7. Switching to message box tab
        dialogBoxesPage.clickMessageBoxButton();

        // 8. Validating that message box is no longer visible
        this.driver = switchToIframe("xpath=//div[2]/p[1]/iframe");
        if (!messageBoxFrame.isPopupBoxVisible()) {
            test.log(Status.PASS, "Popup window not visible");
        } else {
            test.log(Status.FAIL, "Popup window IS visible");
        }

        this.driver = switchToDefault();
    }

    @Test(groups = "regression", description = "Regression test 3")
    public void fifthTest() {
        // Start ExtentTest
        ExtentTest test = report.createTest("Test5: testing search field");
        test.log(Status.INFO, "The test is started");

        openUrl2();
        // 1. Initializing auto complete page
        AutoCompletePage autoCompletePage = new AutoCompletePage(driver);
        if (autoCompletePage.isInitialized()) {
            test.log(Status.PASS, "Auto complete page is visible");
        } else {
            test.log(Status.FAIL, "Auto complete page is NOT visible");
        }

        // Switching to categories frame
        this.driver = switchToIframe("xpath=//div[1]/p/iframe");
        CategoriesFrame categoriesFrame = new CategoriesFrame(driver);

        // 2. writing "and" in search field
        categoriesFrame.inputInSearchField();

        // 3. selecting "Anders Andersson" value
        categoriesFrame.clickAndersAnderssonButton();

        // 4. Creating a screenshot
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BASE64);
        test.pass(MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

        this.driver = switchToDefault();
    }

    @AfterClass
    public void endTask() {
       closeDriver();
    }

    @AfterClass
    public static void endTest() {
        report.flush();
    }
}
