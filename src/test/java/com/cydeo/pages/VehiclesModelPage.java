package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclesModelPage {

    public VehiclesModelPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }



    public WebElement modelName(String modelName){
        WebElement element = Driver.getDriver().findElement(By.xpath("//td[text() ='" + modelName + "']"));
        return element;
    }

    public List<WebElement> modelInfos(){
        List<WebElement> elementList = Driver.getDriver().findElements(By.xpath("//div[@class='control-label']"));
  return elementList;
    }
}
