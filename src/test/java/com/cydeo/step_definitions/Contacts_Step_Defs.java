package com.cydeo.step_definitions;

import com.cydeo.pages.ContactInfoPage;
import com.cydeo.pages.ContactsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.DBUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.*;
import java.util.Map;

public class Contacts_Step_Defs {
    ContactsPage contactsPage = new ContactsPage();


    public void userConnectTheDatabase() throws SQLException {
        DBUtils.createConnection();

        System.out.println("CONNECTION IS SUCCESSFUL");

    }


    @And("user clicks the {string} from contacts")
    public void userClicksTheFromContacts(String email) {
        BrowserUtils.waitFor(1);
        contactsPage.contactEmail("cherrylarmstrong@yahoo.com").click();
        ContactInfoPage contactInfo = new ContactInfoPage();

        System.out.println("Name = " + contactInfo.contactName.getText());
        System.out.println("Email = " + contactInfo.contactEmail.getText());


    }

    @Then("information should be same with database")
    public void informationShouldBeSameWithDatabase() throws InterruptedException {
        DBUtils.createConnection();
        String query = "select concat(first_name,' ',last_name) as fullName ,oce.email from orocrm_contact\n" +
                "left join orocrm_contact_email oce on orocrm_contact.id = oce.owner_id\n" +
                "where oce.email ='cherrylarmstrong@yahoo.com'";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
        System.out.println("rowMap = " + rowMap);

        ContactInfoPage contactInfo = new ContactInfoPage();


Thread.sleep(5000);
        String actualName = contactInfo.contactName.getText();
        contactInfo.contactEmail.getText();

        String expectedFullName = (String) rowMap.get("fullName");

        Assert.assertEquals(expectedFullName,actualName);


    }
}
