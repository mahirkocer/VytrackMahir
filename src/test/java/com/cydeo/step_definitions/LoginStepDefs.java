package com.cydeo.step_definitions;

import com.cydeo.pages.LoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefs {
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() throws InterruptedException {
        String url = ConfigurationReader.getProperty("url");
        Driver.getDriver().get(url);

    }

    @When("the user enters the driver information")
    public void the_user_enters_the_driver_information() throws InterruptedException {
        String username = ConfigurationReader.getProperty("driver_username");
        String password = ConfigurationReader.getProperty("driver_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() throws InterruptedException {
        BrowserUtils.waitFor(3);
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals("Dashboard",actualTitle);

    }

    @When("the user enters the sales manager information")
    public void the_user_enters_the_sales_manager_information() throws InterruptedException {
        String username = ConfigurationReader.getProperty("sales_manager_username");
        String password = ConfigurationReader.getProperty("sales_manager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);

    }

    @When("the user enters the store manager information")
    public void the_user_enters_the_store_manager_information() {
        String username = ConfigurationReader.getProperty("store_manager_username");
        String password = ConfigurationReader.getProperty("store_manager_password");

        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @When("the user logs in using {string} and {string}")
    public void the_user_logs_in_using_and(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username,password);
    }

    @Then("the title contains {string}")
    public void the_title_contains(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),15);
        wait.until(ExpectedConditions.titleIs(expectedTitle));
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));

    }


    @When("the user logs in as a {string}")
    public void theUserLogsInAsA(String userType) {
        String username = ConfigurationReader.getProperty(userType+"_username");
        String password = ConfigurationReader.getProperty(userType+"_password");
        LoginPage loginPage = new LoginPage();

        loginPage.login(username,password);

    }


}
