package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.WebDriverProvider;
import org.example.pom.ProductPage;
import org.junit.Assert;

public class ProductSteps {

    ProductPage productPage;

    public ProductSteps(WebDriverProvider webDriverProvider) {
        productPage = new ProductPage(webDriverProvider.getDriver());
    }

    @When("Kliknij 'Dodaj do koszyka'")
    public void kliknijDodajDoKoszyka() {
        productPage.addProductToCart();
    }

    @Then("Widoczna strona produktu")
    public void widocznaStronaProduktu() {
        Assert.assertTrue("Product page is not displayed", productPage.isProductPageDisplayed());
    }
}
