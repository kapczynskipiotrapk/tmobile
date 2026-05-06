package org.example;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWait {


    WebDriver driver;

    public CustomWait(WebDriver driver){
        this.driver = driver;
    }

    public void waitForAjax() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(webDriver ->
                js.executeScript("return document.readyState").toString().equals("complete")
        );

        Boolean jQueryDefined = (Boolean) js.executeScript("return typeof jQuery != 'undefined'");
        if (jQueryDefined) {
            wait.until(webDriver ->
                    (Long) js.executeScript("return jQuery.active") == 0
            );
        }

        wait.until(webDriver ->
                Boolean.TRUE.equals(js.executeScript(
                        "return (window.pendingRequests === undefined || window.pendingRequests === 0);"
                ))
        );
    }

}
