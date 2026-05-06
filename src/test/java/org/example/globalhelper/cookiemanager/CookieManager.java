package org.example.globalhelper.cookiemanager;


import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookieManager extends BasePage {

    public CookieManager(WebDriver driver) {
        super(driver);
    }

    public void handleCookies(Cookies cookiesOption) {
        clicks.waitAndClick(cookiesOption.xpath);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(cookiesOption.xpath)));
    }
}
