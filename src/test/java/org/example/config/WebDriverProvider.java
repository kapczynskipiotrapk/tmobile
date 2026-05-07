package org.example.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverProvider {

    public WebDriver driver;

    public WebDriver getDriver() {

        if (driver == null) {
            driver = setChromeDriver();
        }

        return driver;
    }

    public WebDriver setChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        return driver;
    }
}
