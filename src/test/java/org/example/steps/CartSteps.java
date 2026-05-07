package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.config.WebDriverProvider;
import org.example.pom.CartPage;
import org.example.pom.ProductPage;
import org.example.testdata.pojo.ProductPageTestData;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CartSteps {

    WebDriver driver;
    CartPage cartPage;
    ProductPage productPage;

    public CartSteps(WebDriverProvider webDriverProvider) {
        this.driver = webDriverProvider.getDriver();
        this.cartPage = new CartPage(webDriverProvider.getDriver());
        this.productPage = new ProductPage(webDriverProvider.getDriver());
    }

    @Then("Widoczna strona Twoj koszyk")
    public void widocznaStronaTwojKoszyk() {
        boolean isCartPageDisplayed = cartPage.isCartPageDisplayed();
        Assert.assertTrue("cart is not displayed", isCartPageDisplayed);
        System.out.println(ProductPageTestData.productsTestData.get(0).getName());
    }

    @And("Cena urzadzenia {string} w koszyku zgadzaja sie z cena ze strony produktu")
    public void cenaUrzadzeniaZgadzajaSieZCenaZeStronyProduktu(String productName) {
        String cartPrice = cartPage.getProductPrice(productName);
        String productPagePrice = ProductPageTestData.getProductByName(productName).getPrice();
        System.out.println("Product " + productName + " price on product details page: " + productPagePrice + " | product price in cart: " + cartPrice);
        Assert.assertEquals(cartPrice, productPagePrice);
    }

    @Then("Koszyk zawiera")
    public void koszykZawiera(List<String> expectedProductsInCart) {
        List<String> productsInCart= driver.findElements(By.xpath("//div[contains (@class, 'productName')]/h3")).stream().map(WebElement::getText).toList();
        Assert.assertEquals("mismatch between actual products in cart and expected products", expectedProductsInCart, productsInCart);
    }
}
