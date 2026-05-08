package org.example.globalhelper.uiinteract;

import org.example.config.BasePage;
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
}
