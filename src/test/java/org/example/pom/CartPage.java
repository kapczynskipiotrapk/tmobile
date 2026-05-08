package org.example.pom;

import org.example.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class CartPage extends BasePage {

    final By cartContentXpath = By.xpath("//main[@class='basketContent']");
    final By summaryXpath = By.id("basketSummary");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isCartPageDisplayed() {
        boolean isCartContentDisplayed = customWait.waitForElementToBeLocated(cartContentXpath).isDisplayed();
        boolean isSummaryDisplayed = customWait.waitForElementToBeLocated(summaryXpath).isDisplayed();
        return isSummaryDisplayed && isCartContentDisplayed;
    }

    public String getProductPrice(String productName) {
        By priceLocator = RelativeLocator.with(By.xpath("//div[contains (@class, 'amount')]")).toRightOf(By.xpath(String.format("//div[text()='%s']", productName)));
        return customWait.waitForElementToBeLocated(priceLocator).getText();
    }
}
