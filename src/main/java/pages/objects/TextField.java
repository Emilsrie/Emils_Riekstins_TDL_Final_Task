package pages.objects;

import org.openqa.selenium.WebElement;

public class TextField extends BasePageObject {
    public TextField(String name, String locator, String value) {
        super(name, locator, value);
    }

    public void setValue() {
        WebElement textField = getWebElement(getLocator());
        textField.sendKeys(getValue());
        System.out.println("In field " + getName() + " the following value was entered: '" + getValue() + "'");
    }

}
