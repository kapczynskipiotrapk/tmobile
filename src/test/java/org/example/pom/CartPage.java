package org.example.pom;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    final By cartContentXpath = By.xpath("//main[@class='basketContent']");
    final By summaryXpath = By.id("basketSummary");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageDisplayed() {
        boolean isCartContentDisplayed = customWait.waitForElementToBeLocated(cartContentXpath).isDisplayed();
        boolean isSummaryDisplayed = customWait.waitForElementToBeLocated(summaryXpath).isDisplayed();
        return  isSummaryDisplayed && isCartContentDisplayed;
    }
}
