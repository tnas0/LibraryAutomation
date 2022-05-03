package com.library.step_definitions;

import com.library.utilities.DB_Util;
import com.library.utilities.QueryReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class US01_AD_Step_Definitions {

    @Given("establish the database connection")
    public void establish_the_database_connection(){
        System.out.println("Database Connection is done inside the Hooks");
    }
    List<String> actualIds;
    @When("execute query to get all IDs from users")
    public void execute_query_to_get_all_ids_from_users() {
        String query = "SELECT id\n" +
                "FROM users;";
        DB_Util.runQuery(query);
        actualIds = DB_Util.getColumnDataAsList(1);
    }
    @Then("verify all users has unique ID")
    public void verify_all_users_has_unique_id() {
        String query = "SELECT DISTINCT id\n" +
                "from users;";
        DB_Util.runQuery(query);
        List<String> expectedIds = DB_Util.getColumnDataAsList(1);
        Assert.assertEquals(expectedIds,actualIds);
    }

    List<String> actualColumn;
    @When("execute query to get all columns")
    public void execute_query_to_get_all_columns() {
        DB_Util.runQuery(QueryReader.read("us01_all_user_ids"));
        actualColumn = DB_Util.getAllColumnNamesAsList();
    }
    @Then("verify the below columns are listed in result")
    public void verify_the_below_columns_are_listed_in_result(List<String> expectedColumn) {
        Assert.assertEquals(expectedColumn,actualColumn);
    }
}
