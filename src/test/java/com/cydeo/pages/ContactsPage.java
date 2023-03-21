package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
    public ContactsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//table[contains(@class,'grid table-hover table table-bordered table-condensed')]/tbody/tr/td[2]")
    public WebElement row1Name;

    public WebElement contactEmail(String email) {
        String xpath = "//*[contains(text(),'" + email + "')]";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }
}