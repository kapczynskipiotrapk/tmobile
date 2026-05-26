package org.example.globalhelper.uiinteract;

import org.example.config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class UiHelpers extends BasePage {

    public UiHelpers(WebDriver driver) {
        super(driver);
    }

    public void hover(By xpath){
        Actions actions = new Actions(driver);
        customWait.waitForElementToBeLocated(xpath);
        actions.moveToElement(driver.findElement(xpath)).perform();
    }
}
