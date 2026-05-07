package org.example.globalhelper.uiinteract;

import org.example.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UiHelpers extends BasePage {

    public UiHelpers(WebDriver driver) {
        super(driver);
    }

    public void hover(By xpath){
        Actions actions = new Actions(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated((xpath)));
        actions.moveToElement(driver.findElement(xpath)).perform();
    }

    public void centerOnElement(Object element){
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";

    }

    public boolean isElementDisplayed(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by).isDisplayed();
    }
}
