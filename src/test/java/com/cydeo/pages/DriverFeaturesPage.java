package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.List;

public class DriverFeaturesPage {
    public DriverFeaturesPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(@class,'dropdown-level-1')]")
    public List<WebElement> features;

    @FindBy(xpath = "//*[contains(@class,'title-level-2')]")
    public List<WebElement> subFeatures;


    public void hoverToElement(String featureText, String subFeaturesText) throws InterruptedException {

        String moduleLocator = "//*[text()[normalize-space()='" + subFeaturesText + "']]";
        String tabLocator = "//*[text()[normalize-space()='" + featureText + "']]";



        WebElement element = Driver.getDriver().findElement(By.xpath(moduleLocator));
        WebElement tab = Driver.getDriver().findElement(By.xpath(tabLocator));

        Actions actions = new Actions(Driver.getDriver());
        Thread.sleep(15000);
        actions.moveToElement(tab).perform();
        Thread.sleep(2000);
        element.click();


//        for (WebElement feature : features) {
//            if (feature.getText().contains(featureText)) {
//                actions.moveToElement(feature).perform();
////                element.click();
//                for (WebElement subFeature : subFeatures) {
//                    Thread.sleep(1000);
//                    if (subFeature.getText().contains(subFeaturesText)) {
//                        subFeature.click();
//
//                    }
//
//                }
//            }
//        }
    }
}

