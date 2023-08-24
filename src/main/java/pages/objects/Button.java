package pages.objects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class Button extends BasePageObject {

    public Button(String name, String locator) {
        super(name, locator);
    }

    public void click() {
        WebElement button = getWebElement(getLocator());
        //button.sendKeys(Keys.DOWN);
        button.click();
        System.out.println("Button '" + getName() + "' was clicked!");
    }

    public boolean isVisible() {
        WebElement button = getWebElement(getLocator());
        return button.isDisplayed();
    }

    public void scrollElementIntoView() {
        WebElement button = getWebElement(getLocator());
        if (!button.isDisplayed()) {
            getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(alignToTop);", button);
        }
    }

}
