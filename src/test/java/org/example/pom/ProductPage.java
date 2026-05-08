package org.example.pom;

import org.example.config.BasePage;
import org.example.testdata.ProductPageTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    By productNameXpath = By.xpath("//h1[@data-qa='PRD_ProductName']");
    By productPriceXpath = By.xpath("//section[@class='rowWrapper']/div//span");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        clicks.waitAndClick(By.xpath("//aside[@aria-label='summary']//button[@data-qa='PRD_AddToBasket']"));
    }

    public void saveProductTestData() {
        String productName = customWait.waitForElementToBeLocated(productNameXpath).getText();
        String productPrice = customWait.waitForElementToBeLocated(productPriceXpath).getText();
        ProductPageTestData.saveProductData(productName, productPrice);
    }

    public boolean isProductPageDisplayed() {
        boolean isProductNameDisplayed = customWait.waitForElementToBeLocated(productNameXpath).isDisplayed();
        boolean isProductPriceDisplayed = customWait.waitForElementToBeLocated(productPriceXpath).isDisplayed();
        return isProductNameDisplayed && isProductPriceDisplayed;
    }
}
