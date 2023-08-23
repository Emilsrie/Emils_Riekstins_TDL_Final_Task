package pages.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Text;

public class SimpleAccordeonFrame {

    public Button section2Button = new Button("Select section 2", "css=body > div > h3:nth-child(3)");

    public Text section2Text = new Text("Selection 2 text", "css=#ui-id-4 > p");

    public SimpleAccordeonFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickSection2Button() {
        this.section2Button.click();
    }

    public String getSelection2Text() {
        return this.section2Text.getContent();
    }
}
