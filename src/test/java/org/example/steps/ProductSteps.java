package org.example.steps;

import io.cucumber.java.en.When;
import org.example.config.WebDriverProvider;
import org.example.pom.ProductPage;

public class ProductSteps {

    ProductPage productPage;

    public ProductSteps(WebDriverProvider webDriverProvider) {
        productPage = new ProductPage(webDriverProvider.getDriver());
    }

    @When("Kliknij 'Dodaj do koszyka'")
    public void kliknijDodajDoKoszyka() {
        productPage.addProductToCart();
    }

}
