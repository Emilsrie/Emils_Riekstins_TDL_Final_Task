package pages.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;

public class RandomProgressBarFrame {

    public Button randomColorButton = new Button("Random color button", "xpath=//*[@id='Random Progress Bar']");

    public Button randomValueDeterminateButton = new Button("Random Value Determinate Button", "xpath=//*[@id='numButton']");

    public RandomProgressBarFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRandomColorButton() {
        this.randomColorButton.click();
    }

    public void clickRandomValueDeterminateButton() {
        this.randomColorButton.click();
    }
}
