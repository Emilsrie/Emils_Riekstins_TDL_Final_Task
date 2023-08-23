package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersianCatPricePage {

    public PersianCatPricePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div h2")
    private WebElement pageTitle;

    @FindBy(css = "a.Button[href$='EST-16']")
    private WebElement addAdultFemalePersianToCartButton;

    public boolean isInitialized() {
        return this.pageTitle.isDisplayed();
    }

    public void clickAddAdultFemalePersianToCartButton() {
        this.addAdultFemalePersianToCartButton.click();
    }

}
