package org.example.globalhelper.cookiemanager;

public enum Cookies {

    AKCEPTUJE_WSZYSTKIE("//button[@id='didomi-notice-agree-button']");
    public String xpath;

    Cookies(String xpath) {
        this.xpath = xpath;

    }
}
