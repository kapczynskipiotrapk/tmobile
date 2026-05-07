package org.example.pom;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsCatalogPage extends BasePage {

    public ProductsCatalogPage(WebDriver driver) {
        super(driver);
    }

    public void productListIsDisplayed(By xpath) {
        customWait.waitForElementsToBeLocated(xpath);
    }

    public void selectProduct(String productName){
        By productXpath = By.xpath(String.format("//a[contains (@aria-label, '%s')]", productName));
        clicks.waitAndClick(productXpath);
        System.out.println(String.format("Product %s added to cart", productName));
    }
}
