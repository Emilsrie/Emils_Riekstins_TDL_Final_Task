package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Link;

public class HomePage {

    public Link mainLogo = new Link("Main logo", "css=a > img");

    public Button dialogBoxButton = new Button("Dialog box button", "xpath=//a[text()='DialogBox']");

    public Button TabsButton = new Button("Tabs button", "xpath=//a[text()='Tabs']");

    public boolean isInitialized() {
        return this.mainLogo.isVisible();
    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickDialogBox() {
        this.dialogBoxButton.click();
    }

    public void clickTabsButton() {
        this.TabsButton.click();
    }

    //TODO if popup ad opens, then close it
}
