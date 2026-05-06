package org.example.pom.modules;

import org.example.BasePage;
import org.example.globalhelper.uiinteract.UiHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Navigation extends BasePage {

    UiHelpers uiHelpers;
    private final String navigationXpath = "//a[contains(@class, 'ODSGlobalHeaderMainLink') and contains(text(), '%s')]";
    public Navigation(WebDriver driver) {
        super(driver);
        uiHelpers = new UiHelpers(driver);
    }

    public void navigate(String page, String subpage){
        openDropdownOnHover(page);
        By secondNavigationElement = By.xpath(String.format("//a[contains(@class, 'ODSGlobalHeaderMegaMenu-ListItem') and contains(text(), '%s')]", subpage));
        clicks.waitAndClick(secondNavigationElement);
    }

    public void openDropdownOnHover(String page){
        By firstNavigationElement = By.xpath(String.format(navigationXpath, page));
        uiHelpers.hover(firstNavigationElement);
    }
}
