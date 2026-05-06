package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CustomWait;
import org.example.config.WebDriverProvider;
import org.example.globalhelper.cookiemanager.CookieManager;
import org.example.globalhelper.cookiemanager.Cookies;
import org.example.globalhelper.uiinteract.UiHelpers;
import org.example.pom.modules.Navigation;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TmobileSteps {

    WebDriver driver;
    Navigation navigation;
    UiHelpers uiHelpers;

    public TmobileSteps(WebDriverProvider webDriverProvider) {
        this.driver = webDriverProvider.getDriver();
        this.uiHelpers = new UiHelpers(driver);
        this.navigation = new Navigation(driver);
    }

    @When("Uzytkownik jest na stronie tmobile")
    public void tmobileJestOtwarty() {
        driver.get("https://www.t-mobile.pl/");
        new CustomWait(driver).waitForAjax();
//        new CookieManager(driver).handleCookies(Cookies.AKCEPTUJE_WSZYSTKIE);
//        new CustomWait(driver).waitForAjax();

    }

    @When("Rozwin liste {string}")
    public void rozwinListe(String page) {
        navigation.openDropdownOnHover(page);
    }


    @Then("Lista jest widoczna")
    public void listaJestWidoczna() {

        boolean isListDisplayed = uiHelpers.isElementDisplayed(By.xpath("//a[text()='Sklep']/ancestor::div[@class=\"navInner\"]/following-sibling::nav//a[text()=\"Smartfony\"]"));
        Assert.assertTrue(isListDisplayed);
    }

}
