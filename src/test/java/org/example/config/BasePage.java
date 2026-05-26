package org.example.config;

import org.example.globalhelper.uiinteract.Clicks;
import org.openqa.selenium.WebDriver;


public class BasePage {

    public WebDriver driver;
    public Clicks clicks;
    public CustomWait customWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        customWait = new CustomWait(driver);
        this.clicks = new Clicks(driver, customWait.wait);
    }

}
