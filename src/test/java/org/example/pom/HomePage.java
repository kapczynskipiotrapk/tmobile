package org.example.pom;

import org.example.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    final By logoXpath = By.xpath("//a[contains (@title, 'T-Mobile Logo')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean homePageIsDisplayed() {
        WebElement logo = customWait.waitForElementToBeLocated(logoXpath);
        boolean logoHasCorrectTitle = logo.getAttribute("title").equals("T-Mobile Logo");
        boolean isLogoDisplayed = logo.isDisplayed();
        return logoHasCorrectTitle && isLogoDisplayed;
    }
}
