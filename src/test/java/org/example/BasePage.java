package org.example;

import org.example.config.ScenarioContext;
import org.example.globalhelper.uiinteract.Clicks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;


public class BasePage {

    public WebDriver driver;
    public Clicks clicks;
    public WebDriverWait wait;
    public ScenarioContext scenarioContext;
    public Actions action;
    public CustomWait customWait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.of(10, ChronoUnit.SECONDS));
        this.clicks = new Clicks(driver, wait);
        customWait = new CustomWait(driver);
    }

}
