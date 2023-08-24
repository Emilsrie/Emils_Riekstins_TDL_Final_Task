package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Link;
import pages.objects.TextField;

public class HomePage {

    public Link mainLogo = new Link("Main logo", "css=a > img");
    public Button dialogBoxButton = new Button("Dialog box button", "xpath=//a[text()='DialogBox']");
    public Button progressBarButton = new Button("Progress bar button", "xpath=//a[text()='ProgressBar']");
    public Button TabsButton = new Button("Tabs button", "xpath=//a[text()='Tabs']");

    public boolean isInitialized() {
        return this.mainLogo.isVisible();
    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickDialogBox() {
        this.progressBarButton.scrollElementIntoView();
        this.dialogBoxButton.click();
    }

    public void clickProgressBarButton() {
        this.progressBarButton.scrollElementIntoView();
        this.progressBarButton.click();
    }

    public void clickTabsButton() {
        this.progressBarButton.scrollElementIntoView();
        this.TabsButton.click();
    }
}
