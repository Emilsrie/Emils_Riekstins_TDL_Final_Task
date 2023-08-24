package pages.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.TextField;

public class CategoriesFrame {
    public TextField searchField = new TextField("Search field", "xpath=//*[@id='search']", "and");
    public Button andersAnderssonButton = new Button("Anders Andersson Button", "xpath=/html/body/ul/li[4]/div");

    public CategoriesFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void inputInSearchField() {
        this.searchField.setValue();
    }

    public void clickAndersAnderssonButton() {
        this.andersAnderssonButton.click();
    }
}
