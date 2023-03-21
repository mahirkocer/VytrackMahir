package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
    public ContactInfoPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//h1[@class='user-name']")
    public WebElement contactName;

    @FindBy(xpath = "(//ul[@class='extra-list'])[4]")
    public WebElement contactEmail;
}
