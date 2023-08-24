package pages.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;

public class MessageBoxFrame {

    public Button okButton = new Button("Ok button", "xpath=/html/body/div[2]/div[3]/div/button[text()='Ok']");


    public MessageBoxFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickOkButton() {
        this.okButton.click();
    }

    public boolean isPopupBoxVisible() {
        return okButton.isVisible();
    }
}