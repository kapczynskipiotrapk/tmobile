package org.example.globalhelper.cookiemanager;


import org.example.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CookieManager extends BasePage {

    public CookieManager(WebDriver driver) {
        super(driver);
    }

    public void handleCookies(Cookies cookiesOption) {
        clicks.waitAndClick(cookiesOption.xpath);
        customWait.waitForElementInvisibility(By.xpath(cookiesOption.xpath));
    }
}
