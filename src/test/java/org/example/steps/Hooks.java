package org.example.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.example.config.WebDriverProvider;
import org.openqa.selenium.WebDriver;

public class Hooks {

    WebDriver driver;
    Scenario scenario;

   public Hooks (WebDriverProvider webDriverProvider){
        this.driver = webDriverProvider.getDriver();
    }

    @After
    public void afterTest(Scenario scenario){
        if(scenario.isFailed()){
            driver.quit();
        }
    }

}
