package pages.objects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Button extends BasePageObject {

    public Button(String name, String locator) {
        super(name, locator);
    }

    public void click() {
        WebElement button = getWebElement(getLocator());
        button.sendKeys(Keys.DOWN);
        button.click();
        System.out.println("Button '" + getName() + "' was clicked!");
    }

    public void scrollElementIntoView() {
        WebElement button = getWebElement(getLocator());
        if (!button.isDisplayed()) {
            getJavascriptExecutor().executeScript("arguments[0].scrollIntoView(alignToTop);", button);
        }
    }

}
