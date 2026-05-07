package org.example.steps;

import io.cucumber.java.en.Then;
import org.example.config.WebDriverProvider;
import org.example.pom.CartPage;
import org.example.testdata.pojo.CartTestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class CartSteps {

    WebDriver driver;
    CartPage cartPage;

    public CartSteps(WebDriverProvider webDriverProvider) {
        this.driver = webDriverProvider.getDriver();
        this.cartPage = new CartPage(webDriverProvider.getDriver());
    }

    @Then("Widoczna strona Twoj koszyk")
    public void widocznaStronaTwojKoszyk() {
        boolean isCartPageDisplayed = cartPage.isCartPageDisplayed();
        Assert.assertTrue("cart is not displayed", isCartPageDisplayed);
        System.out.println(CartTestData.productsInCart.get(0).getName());
    }
}
