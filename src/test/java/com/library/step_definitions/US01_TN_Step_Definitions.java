package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_TN_Step_Definitions {
    @Given("To connect the database")
    public void to_connect_the_database() {
        System.out.println("Database connection has done inside the Hook class");
    }
     List<String> actualID;
    @When("run the query to get all IDs from users")
    public void run_the_query_to_get_all_i_ds_from_users() {
      String allIDS="SELECT id\n" +
              "FROM users";
        DB_Util.runQuery(allIDS);
        actualID=DB_Util.getColumnDataAsList(1);
    }
    @Then("to verify all users has unique ID")
    public void to_verify_all_users_has_unique_id() {
      String uniqueIDs="SELECT DISTINCT id\n" +
              "FROM users";
      DB_Util.runQuery(uniqueIDs);
      List<String> expectedID=DB_Util.getColumnDataAsList(1);
        Assert.assertEquals(actualID,expectedID);
    }



    List<String> actualColumnsOfUsers;
    @When("run the query get all columns")
    public void run_the_query_get_all_columns() {
     String allColumns="SELECT * FROM users";
     DB_Util.runQuery(allColumns);
     actualColumnsOfUsers=DB_Util.getAllColumnNamesAsList();
    }
    @Then("to verify the columns are listed in down bellow")
    public void to_verify_the_columns_are_listed_in_down_bellow(List<String> expectedColumnsOfUsers) {
     Assert.assertEquals(actualColumnsOfUsers,expectedColumnsOfUsers);
    }

}
