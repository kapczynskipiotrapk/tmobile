package org.example.pom;

import org.example.BasePage;
import org.example.testdata.pojo.CartTestData;
import org.example.testdata.pojo.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {

    By productNameXpath = By.xpath("//h1[@data-qa='PRD_ProductName']");
    By productPriceXpath = By.xpath("//section[@class='rowWrapper']/div//span");
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart() {
        String productName = customWait.waitForElementToBeLocated(productNameXpath).getText();
        String productPrice = customWait.waitForElementToBeLocated(productPriceXpath).getText();
        Product product = new Product();
        product.setName(productName);
        product.setPrice(productPrice);
        CartTestData.addProductToCartTestData(product);

        clicks.waitAndClick(By.xpath("//aside[@aria-label='summary']//button[@data-qa='PRD_AddToBasket']"));
    }
}
