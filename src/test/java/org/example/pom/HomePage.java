package org.example.pom;

import org.example.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    final By mainNavXpath = By.xpath("//div[contains (@class, 'ODSGlobalHeaderMainNav')]");
    final By logoXpath = By.xpath("//a[contains (@class, 'ODSLogo--type-primary')]");
    final By storeDropdown = By.xpath("//div[@class='ODSGlobalHeaderMegaMenu-Container']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean homePageIsDisplayed() {
        WebElement logo = customWait.waitForElementToBeLocated(logoXpath);
        boolean logoHasCorrectTitle = logo.getAttribute("title").equals("T-Mobile Logo");
        boolean isLogoDisplayed = logo.isDisplayed();
        boolean mainNavIsDisplayed = driver.findElement(mainNavXpath).isDisplayed();
        return logoHasCorrectTitle && isLogoDisplayed && mainNavIsDisplayed;
    }

    public boolean storeDropdownListIsDisplayed(){
        return customWait.waitForElementToBeLocated(storeDropdown).isDisplayed();
    }
}
