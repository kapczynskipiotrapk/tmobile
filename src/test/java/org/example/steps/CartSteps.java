package org.example.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.WebDriverProvider;
import org.example.pom.CartPage;
import org.example.testdata.ProductPageTestData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class CartSteps {

    WebDriver driver;
    CartPage cartPage;

    public CartSteps(WebDriverProvider webDriverProvider) {
        this.driver = webDriverProvider.getDriver();
        this.cartPage = new CartPage(webDriverProvider.getDriver());
    }

    @Then("Widoczna strona Twoj koszyk")
    public void yourCartPageIsDisplyed() {
        boolean isCartPageDisplayed = cartPage.isCartPageDisplayed();
        Assertions.assertTrue(isCartPageDisplayed, "cart is not displayed");

    }

    @And("Cena urzadzenia {string} w koszyku zgadzaja sie z cena ze strony produktu")
    public void devicePriceInCartIsSameAsInCatalog(String productName) {
        String cartPrice = cartPage.getProductPrice(productName);
        String productPagePrice = ProductPageTestData.getProductByName(productName).getPrice();
        System.out.println("[INFO] Product " + productName + " price on product details page: " + productPagePrice + " | product price in cart: " + cartPrice);
        Assertions.assertEquals(cartPrice, productPagePrice);
    }

    @Then("Koszyk zawiera")
    public void cartContains(List<String> expectedProductsInCart) {
        List<String> productsInCart= driver.findElements(By.xpath("//div[contains (@class, 'productName')]/h3")).stream().map(WebElement::getText).toList();
        Assertions.assertEquals(expectedProductsInCart, productsInCart, "mismatch between actual products in cart and expected products");
    }

    @When("Przejdz na strone glowna TMobile")
    public void goToMainPage() {
        cartPage.navigateToHomePageByClickOnLogo();
    }


}
