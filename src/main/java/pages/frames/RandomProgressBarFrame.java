package pages.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;

public class RandomProgressBarFrame {

    public Button randomColorButton = new Button("Random color button", "css=button#colorButton");

    public Button randomValueDeterminateButton = new Button("Random Value Determinate Button", "css=button#numButton");

    public RandomProgressBarFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRandomColorButton() {
        this.randomColorButton.click();
    }

    public void clickRandomValueDeterminateButton() {
        this.randomValueDeterminateButton.click();
    }
}
