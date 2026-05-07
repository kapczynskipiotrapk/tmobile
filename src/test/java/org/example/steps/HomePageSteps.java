package org.example.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.CustomWait;
import org.example.config.WebDriverProvider;
import org.example.globalhelper.cookiemanager.CookieManager;
import org.example.globalhelper.cookiemanager.Cookies;
import org.example.globalhelper.uiinteract.UiHelpers;
import org.example.pom.modules.HomePage;
import org.example.pom.modules.Navigation;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class HomePageSteps {

    WebDriver driver;
    Navigation navigation;
    UiHelpers uiHelpers;
    HomePage homePage;

    public HomePageSteps(WebDriverProvider webDriverProvider) {
        this.driver = webDriverProvider.getDriver();
        this.uiHelpers = new UiHelpers(driver);
        this.navigation = new Navigation(driver);
        this.homePage = new HomePage(driver);
    }

    @When("Uzytkownik wchodzi na strone tmobile")
    public void tmobileJestOtwarty() {
        driver.get("https://www.t-mobile.pl/");
        new CustomWait(driver).waitForAjax();
        new CookieManager(driver).handleCookies(Cookies.AKCEPTUJE_WSZYSTKIE);
    }

    @Then("Strona glowa jest widoczna")
    public void mainPageIsDisplayed() {
        Assert.assertTrue("strona glowna nie zaladowala sie poprawnie", homePage.homePageIsDisplayed());
    }

}
