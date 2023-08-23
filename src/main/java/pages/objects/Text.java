package pages.objects;

import org.openqa.selenium.WebElement;

public class Text extends BasePageObject {

    public Text(String name, String locator) {
        super(name, locator);
    }

    public String getContent() {
        WebElement content = getWebElement(getLocator());
        return content.getText();
    }
}
