package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Link;
import pages.objects.Text;

public class ProgressBarPage {

    public Link mainLogo = new Link("Main logo", "css=a > img");
    public Button randomProgressBarButton = new Button("Random progress bar button", "xpath=/html/body/div/div[1]/div[2]/div/div/div[2]/div/ul/li[2]");

    public ProgressBarPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isInitialized() {
        return this.mainLogo.isVisible();
    }

    public void clickRandomProgressBarButton() {
        this.randomProgressBarButton.click();
    }

}
