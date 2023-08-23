package pages.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Text;
import pages.objects.TextField;

public class FormFrame {

    public Button createNewUserButton = new Button("Create new user", "xpath=.//button[text()='Create new user']");
    public TextField fullname = new TextField("Full name", "xpath=//*[@id='name']", "Emils Riekstins");
    public TextField email = new TextField("Email", "xpath=//label[contains(text(),'Email')]", "emils@riekstins.com");
    public TextField password = new TextField("password", "xpath=//label[contains(text(),'Password')]", "mypassword");


    public FormFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewUserButton() {
        this.createNewUserButton.click();
    }

    public void signUp() {
        this.fullname.clearField();
        this.email.clearField();
        this.password.clearField();
        this.fullname.setValue();
        this.email.setValue();
        this.password.setValue();
    }
}