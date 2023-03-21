package com.cydeo.step_definitions;

import com.cydeo.pages.DriverFeaturesPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class DriverFeatures_Step_Defs {
    DriverFeaturesPage driverFeaturesPage =  new DriverFeaturesPage();


    @When("the user navigates to {string} {string}")
    public void theUserNavigatesTo(String featureText, String subFeatureText) throws InterruptedException {

      driverFeaturesPage.hoverToElement(featureText,subFeatureText);
    }
}
