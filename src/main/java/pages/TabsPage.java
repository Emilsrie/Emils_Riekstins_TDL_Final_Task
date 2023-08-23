package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Link;

public class TabsPage {

    public Link mainLogo = new Link("Main logo", "css=a > img");

    public Button section2Button = new Button("Select section 2", "css=body > div > h3:nth-child(3)");

    public TabsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isInitialized() {
        return this.mainLogo.isVisible();
    }

    public void clickSection2Button() {
        this.section2Button.click();
    }
}