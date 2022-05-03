package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class US03_AD_Step_Definitions {

    @Given("Establish the database connection")
    public void establish_the_database_connection() {
        System.out.println("Database Connection is done inside the Hooks");
    }
    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {
        String query = "SELECT bc.name, count(*) from book_borrow bb\n" +
                "INNER JOIN books b on bb.book_id = b.id\n" +
                "INNER JOIN book_categories bc on b.book_category_id = bc.id\n" +
                "GROUP BY name\n" +
                "ORDER BY 2 desc;";
        DB_Util.runQuery("query");
        String actualBookGenre = DB_Util.getCellValue(1,1);
    }
    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedBookGenre) {

    }
}
