package pages.objects;

import common.TestBase;

public class BasePageObject extends TestBase {
    private String name;
    private String locator;
    private String value;

    public BasePageObject(String name, String locator, String value) {
        this.name = name;
        this.locator = locator;
        this.value = value;
    }

    public BasePageObject(String name, String locator) {
        this.name = name;
        this.locator = locator;
    }

    public String getName() {
        return name;
    }

    public String getLocator() {
        return locator;
    }

    public String getValue() {
        return value;
    }

    public void clearField() {
        getWebElement(getLocator()).clear();
    }
}
