package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Link;

public class DialogBoxesPage {

    public Link mainLogo = new Link("Main logo", "css=a > img");

    public Button messageBoxButton = new Button("Message box button", "xpath=html/body/div/div[1]/div[2]/div/div/div[2]/div/ul/li[2]");

    public Button formButton = new Button("Form button", "css=#Form");

    public DialogBoxesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isInitialized() {
        return this.mainLogo.isVisible();
    }

    public void clickMessageBoxButton() {
        this.messageBoxButton.click();
    }

    public void clickFormButton() {
        this.formButton.click();
    }
}
