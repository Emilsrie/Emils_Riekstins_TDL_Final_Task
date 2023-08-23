import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.ConfigFileReader;
import common.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

import java.awt.peer.ChoicePeer;
import java.io.File;
import java.io.IOException;

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
    public void smokeTest() {
        openUrl();
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());


        // Closeing popup ad
        //homePage.clickClosePopupAd();

        // Navigating to dialog boxes page
        homePage.clickDialogBox();

        // Initializing dialog boxes page
        DialogBoxesPage dialogBoxesPage = new DialogBoxesPage(driver);
        Assert.assertTrue(dialogBoxesPage.isInitialized());

//        // Searching for search keyword
//        homePage.search("Angelfish");
//
//        // Initializing ResultsPage
//        ResultsPage resultsPage = new ResultsPage(driver);
//        Assert.assertTrue(resultsPage.isInitialized());
//
//        // Validate that we have found the product with the specific ID
//        //Assert.assertEquals(resultsPage.getProductId(), "FI-SW-01");
//        if (resultsPage.getProductId().equals("FI-SW-01")) {
//            System.out.println("Product with ID: FI-SW-01 is found!");
//            Reporter.log("Product with ID: FI-SW-01 is found!");
//        } else {
//            System.out.println("Product was not found!");
//            Reporter.log("Product was not found!");
//        }
    }

//    @Test(groups = "regression", description = "Regression test")
//    public void regressionTest() {
//
//    }

    @AfterClass
    public static void endTest() {
        report.flush();
    }
}
