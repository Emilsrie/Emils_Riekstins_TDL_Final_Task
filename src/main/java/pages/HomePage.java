package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.objects.Button;
import pages.objects.Link;

public class HomePage {

    public Link mainLogo = new Link("Main logo", "css=a > img");

    public Button dialogBox = new Button("Dialog box", "xpath=//div[2]/div[1]/ul/li[6]/a");

    //public Button closePopupAd = new Button("Close popup ad", "css=ins>span>svg>path");

    public boolean isInitialized() {
        return this.mainLogo.isVisible();
    }

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickDialogBox() {
        this.dialogBox.scrollElementIntoView();
        this.dialogBox.click();
    }
//    public void clickClosePopupAd() {
//        this.closePopupAd.click();
//    }

}
