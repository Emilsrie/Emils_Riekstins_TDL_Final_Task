import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import common.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;

import java.io.File;
import java.io.IOException;

public class Task1 extends TestBase {
    private WebDriver driver;
    static ExtentReports report;

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
        sparkReporter.config().setReportName("Sample Extent Report");
        report.setSystemInfo("Project", "TDL Summer School");
        report.setSystemInfo("Author", "Emils Rieksitns");
        report.attachReporter(sparkReporter);
    }

    /*
    @Test
    public void firstTest() {
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());

        // Searching for search keyword
        homePage.search("Angelfish");

        // Initializing ResultsPage
        ResultsPage resultsPage = new ResultsPage(driver);
        Assert.assertTrue(resultsPage.isInitialized());

        // Validate that we have found the product with the specific ID
        //Assert.assertEquals(resultsPage.getProductId(), "FI-SW-01");
        if (resultsPage.getProductId().equals("FI-SW-01")) {
            System.out.println("Product with ID: FI-SW-01 is found!");
            Reporter.log("Product with ID: FI-SW-01 is found!");
        } else {
            System.out.println("Product was not found!");
            Reporter.log("Product was not found!");
        }
    }

    // Scenario:
    // We go to the Fish page and get all of the fish that contain the phrase "Fish" in their name
    @Test(description = "Test2")
    public void secondTest() {
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());

        // Clicking on the Fish button
        homePage.clickFishButton();

        // Initializing fish page
        FishPage fishPage = new FishPage(driver);
        Assert.assertTrue(fishPage.isInitialized());

        // Get fish list
        ArrayList<String> expectedFishNames = new ArrayList<>();
        expectedFishNames.add("Angelfish");
        expectedFishNames.add("Goldfish");

        int counter = 0;
        for (int i = 0; i < fishPage.getFishList().size(); i++) {
            String fishName = fishPage.getFishList().get(i).getText();
            //if (fishName.equals("Angelfish") || fishName.equals("Goldfish")) {
            if (expectedFishNames.get(i).equals(fishName)) {
                System.out.println(fishPage.getFishList().get(i).getText());
                counter++;
            }
        }
        System.out.print(counter);
        Assert.assertEquals(counter, 2);
    }

    // Scenario:
    // We add a Fish to the shopping card and validate that we have the correct fish added there
    @Test(description = "Test3")
    public void thirdTest() {
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());

        // Clicking on the Fish button
        homePage.clickFishButton();

        // Initializing fish page
        FishPage fishPage = new FishPage(driver);
        Assert.assertTrue(fishPage.isInitialized());
        fishPage.clickAngelFishButton();

        // Initializing Angelfish page
        AngelfishPricePage angelfishPricePage = new AngelfishPricePage(driver);
        Assert.assertTrue(angelfishPricePage.isInitialized());
        angelfishPricePage.clickAddSmallAnglerFishToCartButton();

        // Initializing Shopping Cart page
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.isInitialized();

        // Check if small Angelfish is added to cart
        Assert.assertEquals(shoppingCart.getSmallAngelFishID(), "EST-2");
    }

    // Scenario:
    // We add a cat and a dog tp the shopping cart amd check all the details to see
    // if they are correctly added
    @Test(description = "Test4")
    public void fourthTest() {
        // Initializing homepage
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isInitialized());

        // Clicking on the Fish button
        homePage.clickCatButton();

        // Initializing cat page
        CatPage catPage = new CatPage(driver);
        Assert.assertTrue(catPage.isInitialized());
        catPage.clickPersianCatButton();

        // Initializing Persian cat page
        PersianCatPricePage persianCatPricePage = new PersianCatPricePage(driver);
        Assert.assertTrue(persianCatPricePage.isInitialized());
        persianCatPricePage.clickAddAdultFemalePersianToCartButton();

        // Initializing Shopping cart page
        ShoppingCart shoppingCart = new ShoppingCart(driver);
        shoppingCart.isInitialized();

        // Click Dog page button
        shoppingCart.clickDogPageButton();

        // Initializing Dog page
        DogPage dogPage = new DogPage(driver);
        dogPage.clickGoldenRetrieverDogButton();

        // Initializing Golden Retriever page
        GoldenRetrieverPricePage goldenRetrieverPricePage = new GoldenRetrieverPricePage(driver);
        Assert.assertTrue(goldenRetrieverPricePage.isInitialized());
        goldenRetrieverPricePage.clickAddAdultFemaleGoldenRetrieverToCartButton();

        // Check that all animals are correctly added
        Assert.assertEquals(shoppingCart.getAdultFemalePersianID(), "EST-16");
        Assert.assertEquals(shoppingCart.getAdultFemaleGoldenRetrieverID(), "EST-28");
    }
     */

    @Test(description = "Testing the Extent Reporter")
    public void extentReporterTest() {
        ExtentTest test = report.createTest("Testing the extent reporter");
        test.log(Status.INFO, "The test is started");
        openUrl();
        HomePage homePage = new HomePage();
        if (homePage.isInitialized()) {
            test.log(Status.INFO, "Home page is visible");
        } else {
            test.log(Status.INFO, "Home page is NOT visible");
        }

        homePage.signIn.click();

        SignInPage signInPage = new SignInPage();
        // TODO create isInitialized() checker like homepage
        signInPage.signIn();
        test.log(Status.INFO, "Signing into the Pet store");
        test.log(Status.INFO, "The test is finished");

        closeDriver();
    }

    @AfterClass
    public static void endTest() {
        report.flush();
    }
}
