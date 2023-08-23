package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Link;

public class DialogBoxesPage {

    public Link mainLogo = new Link("Main logo", "css=a > img");

    public DialogBoxesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isInitialized() {
        return this.mainLogo.isVisible();
    }
}
