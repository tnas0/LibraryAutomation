package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US04_TN_Step_Definitions {
    @Given("Establish the database connection successfully")
    public void establish_the_database_connection_successfully() {
        System.out.println("Database connection has done successfully");
    }
    String actualBestReader;
    @When("to find most popular user")
    public void to_find_most_popular_user() {
     String query="SELECT full_name, COUNT(*) AS countofreadbooks\n" +
             "FROM users u\n" +
             "         INNER JOIN book_borrow bb ON u.id = bb.user_id\n" +
             "GROUP BY full_name\n" +
             "ORDER BY countofreadbooks DESC";
        DB_Util.runQuery(query);
        actualBestReader=DB_Util.getFirstRowFirstColumn();

    }
    @Then("To verify {string} likes to read more")
    public void to_verify_likes_to_read_more(String expectedBestReader) {
        Assert.assertEquals(expectedBestReader,actualBestReader);
    }
}
