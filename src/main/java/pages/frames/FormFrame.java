package pages.frames;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Text;
import pages.objects.TextField;

public class FormFrame {

    public Button createNewUserButton = new Button("Create new user", "xpath=.//button[text()='Create new user']");
    public Button createAnAccountButton = new Button("Create an account", "xpath=.//button[text()='Create an account']");
    public TextField fullName = new TextField("Full name", "css=input#name", "Emils Riekstins");
    public TextField email = new TextField("Email", "css=input#email", "emils@riekstins.com");
    public TextField password = new TextField("password", "css=input#password", "mypassword");
    public Text enteredFullName = new Text("Entered full name (Emils Riekstins)", "xpath=.//td[text()='Emils Riekstins']");


    public FormFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isInitialized() {
        return this.createNewUserButton.isVisible();
    }

    public void clickCreateNewUserButton() {
        this.createNewUserButton.click();
    }

    public void clickCreateAnAccountButton() {
        this.createAnAccountButton.click();
    }

    public void signUp() {
        this.fullName.clearField();
        this.fullName.setValue();
        this.email.clearField();
        this.email.setValue();
        this.password.clearField();
        this.password.setValue();
    }

    public boolean newUserIsCreated() {
        return this.enteredFullName.isVisible() && enteredFullName.getContent().equals("Emils Riekstins");
    }
}