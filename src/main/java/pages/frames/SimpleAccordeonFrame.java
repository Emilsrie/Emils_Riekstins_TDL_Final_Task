package pages.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Text;

public class SimpleAccordeonFrame {

    public Button section2Button = new Button("Section 2 button", "css=body > div > h3:nth-child(3)");
    public Text section2Text = new Text("Section 2 text", "css=#ui-id-4");

    public SimpleAccordeonFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSection2Button() {
        this.section2Button.click();
    }

    public boolean section2IsInitialized() {
        return section2Text.isVisible();
    }

}
