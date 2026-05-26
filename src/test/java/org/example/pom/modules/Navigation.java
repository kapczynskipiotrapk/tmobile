package org.example.pom.modules;

import org.example.config.BasePage;
import org.example.globalhelper.uiinteract.UiHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends BasePage {

    UiHelpers uiHelpers;

    private final String navigationXpath = "//button[text()= '%s']";
    private final By logoXpath = By.xpath("//a[contains (@title, 'T-Mobile Logo')]");
    private final By cartXpath = By.xpath("//a[@aria-label='Koszyk']");
    private final By submenuXpath = By.xpath("//div[@aria-label='Podmenu' and @aria-hidden='false']");

    public Navigation(WebDriver driver) {
        super(driver);
        uiHelpers = new UiHelpers(driver);
    }


    public void openDropdownOnHover(String page) {
        By firstNavigationElement = By.xpath(String.format(navigationXpath, page));
        uiHelpers.hover(firstNavigationElement);
    }

    public void selectFromDropdown(String element, String section) {
        By listElementXpath = By.xpath(String.format("//span[contains (text(), '%s')]/ancestor::ul//a[contains (text(), '%s')]", section, element));
        clicks.waitAndClick(listElementXpath);
    }

    public void navigateToCart() {
        clicks.waitAndClick(cartXpath);
    }

    public boolean storeDropdownListIsDisplayed() {
        return customWait.waitForElementToBeLocated(submenuXpath).isDisplayed();
    }
}
