package org.example.globalhelper.webelementhelpers;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

public class Helper {

    public static boolean isButtonClickable(WebElement element) {
        boolean isEnabled = element.isEnabled();
        boolean isDisplayed = element.isDisplayed();
        return isEnabled && isDisplayed;
    }

    public static boolean hasWebElementBackgroundColorCorrect(WebElement element, String colorAsHex){
        return Color.fromString(element.getCssValue("background-color")).asHex().equals(colorAsHex);
    }

    public static boolean hasWebElementColorCorrect(WebElement element, String colorAsHex){
        return Color.fromString(element.getCssValue("color")).asHex().equals(colorAsHex);
    }

//    public static boolean isWebElementDisplayed(WebElement element){

//    }
}
