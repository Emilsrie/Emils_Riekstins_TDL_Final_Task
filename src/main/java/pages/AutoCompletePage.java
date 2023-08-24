package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Link;
import pages.objects.TextField;

public class AutoCompletePage {

    public Link mainLogo = new Link("Main logo", "css=a > img");

    public boolean isInitialized() {
        return this.mainLogo.isVisible();
    }

    public AutoCompletePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
