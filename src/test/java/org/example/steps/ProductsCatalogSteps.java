package org.example.steps;

import io.cucumber.java.en.When;
import org.example.config.WebDriverProvider;
import org.example.pom.ProductPage;
import org.example.pom.ProductsCatalogPage;
import org.openqa.selenium.WebDriver;


public class ProductsCatalogSteps {

    WebDriver driver;
    ProductsCatalogPage productsCatalogPage;
    ProductPage productPage;

    public ProductsCatalogSteps(WebDriverProvider webDriverProvider) {
        this.driver = webDriverProvider.getDriver();
        this.productsCatalogPage = new ProductsCatalogPage(driver);
        this.productPage = new ProductPage(driver);
    }

    @When("Kliknij element z listy o nazwie {string} i zapisz dane {string}")
    public void kliknijElementZListyONazwie(String name, String option) {
        productsCatalogPage.selectProduct(name);
        if (option.equals("TAK")) {
            productPage.saveProductTestData();
        }
    }

}
