package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Link;

public class HomePage {

    public Link signIn = new Link("Sign in", "xpath=//a[text()='Sign In']");

    public boolean isInitialized() {
        return this.signIn.isVisible();
    }

    /*
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "keyword")
    private WebElement searchField;

    @FindBy(name = "searchProducts")
    private WebElement searchButton;

    @FindBy(css = "#SidebarContent a:first-child") // Using xpath: //div[@id="SidebarContent"]/a
    private WebElement fishButton;

    @FindBy(css = "#SidebarContent a:nth-child(7)") // Using xpath: //div[@id="SidebarContent"]/a
    private WebElement catButton;

    public void search(String searchKeyword) {
        this.searchField.sendKeys(searchKeyword);
        this.searchButton.click();
    }

    public void clickFishButton() {
        this.fishButton.click();
    }

    public void clickCatButton() {
        this.catButton.click();
    }
     */
}
