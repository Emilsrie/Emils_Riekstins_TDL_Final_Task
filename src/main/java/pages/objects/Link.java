package pages.objects;

import org.openqa.selenium.WebElement;

public class Link extends BasePageObject {

    public Link(String name, String locator) {
        super(name, locator);
    }

    public void click() {
        WebElement link = getWebElement(getLocator());
        link.click();
        System.out.println("Link " + getName() + " was clicked!");
    }

    public boolean isVisible() {
        WebElement link = getWebElement(getLocator());
        return link.isDisplayed();
    }

}
