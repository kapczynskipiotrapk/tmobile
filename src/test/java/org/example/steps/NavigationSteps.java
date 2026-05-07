package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.config.WebDriverProvider;
import org.example.globalhelper.uiinteract.UiHelpers;
import org.example.pom.ProductsCatalogPage;
import org.example.pom.HomePage;
import org.example.pom.modules.Navigation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NavigationSteps {

    WebDriver driver;
    Navigation navigation;
    UiHelpers uiHelpers;
    HomePage homePage;
    ProductsCatalogPage productsCatalogPage;

    public NavigationSteps(WebDriverProvider webDriverProvider) {
        this.driver = webDriverProvider.getDriver();
        this.uiHelpers = new UiHelpers(driver);
        this.navigation = new Navigation(driver);
        this.homePage = new HomePage(driver);
        this.productsCatalogPage = new ProductsCatalogPage(driver);
    }

    @When("Z gornej belki rozwin liste {string}")
    public void rozwinListe(String page) {
        navigation.openDropdownOnHover(page);
    }

    @Then("Widoczna jest rozwijana lista produktow")
    public void widocznaJestRozwijanaListaProduktow() {
        homePage.storeDropdownListIsDisplayed();
    }

    @When("Kliknij {string} z sekcji {string}")
    public void kliknijBezAbonamentuZSekcjiSmartfony(String element, String section) {
        navigation.selectFromDropdown(element, section);
    }

    @Then("Widoczna jest lista smartfonow")
    public void widocznaJestListaSmartfonow() {
        productsCatalogPage.productListIsDisplayed(By.xpath("//div[contains (@data-qa, 'LST_ProductCard')][position()<=6]"));
    }

    @When("Przejdz na strone glowna TMobile")
    public void przejdzNaStroneGlowna() {
        navigation.navigateToHomePageByClickOnLogo();
    }

    @When("Kliknij Koszyk")
    public void przejdDoKoszyka() {
        navigation.navigateToCart();
    }
}
