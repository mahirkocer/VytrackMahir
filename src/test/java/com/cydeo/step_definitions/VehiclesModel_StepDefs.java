package com.cydeo.step_definitions;

import com.cydeo.pages.VehiclesModelPage;
import com.cydeo.utilities.DBUtils;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class VehiclesModel_StepDefs {
    VehiclesModelPage vehiclesModels = new VehiclesModelPage();

    @When("the user clicks the {string}")
    public void the_user_clicks_the(String modelName) {
        vehiclesModels.modelName(modelName).click();
    }

    @Then("the {string} information should be match with database")
    public void the_information_should_be_match_with_database(String modelName) {

        DBUtils.createConnection();

        String query = "select ModelName,Make,Cost,FuelType_id,CO2Fee,TotalCost,\n" +
                "CatalogValue,Logo_id,CO2Emissions,Vendors,Canberequested from oro_ext_vehiclesmodel\n" +
                "where ModelName ='"+modelName+"'";
        List<List<Object>> queryResultList = DBUtils.getQueryResultList(query);
        List<String> text = new ArrayList<>();

        for (WebElement modelInfo : vehiclesModels.modelInfos()) {
           text.add(modelInfo.getText().trim());

        }

        Assert.assertEquals(text,queryResultList);





    }

}
