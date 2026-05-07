package org.example.steps;

import io.cucumber.java.en.When;
import org.example.config.WebDriverProvider;
import org.example.pom.ProductsCatalogPage;
import org.openqa.selenium.WebDriver;


public class ProductsCatalogSteps {

    WebDriver driver;
    ProductsCatalogPage productsCatalogPage;

    public ProductsCatalogSteps(WebDriverProvider webDriverProvider) {
        this.driver = webDriverProvider.getDriver();
        this.productsCatalogPage = new ProductsCatalogPage(driver);
    }

    @When("Kliknij element z listy o nazwie {string}")
    public void kliknijElementZListyONazwie(String name) {
        productsCatalogPage.selectProduct(name);
    }

}
