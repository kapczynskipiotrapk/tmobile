package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWait {

    WebDriver driver;
    WebDriverWait wait;
    public CustomWait(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public WebElement waitForElementToBeLocated(By xpath){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    public void waitForAjax() {

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
