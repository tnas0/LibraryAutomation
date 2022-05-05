package com.library.step_definitions;

import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US03_TN_Step_Definitions {
    @Given("To connect with Database")
    public void to_connect_with_database() {
        System.out.println("Database connection has done inside the Hook class");
    }
    String actualPopularGenre;
    @When("Create query for finding most popular book genre")
    public void create_query_for_finding_most_popular_book_genre() {
       String query= "SELECT book_categories.name, COUNT(*) AS countofbookcategories\n" +
               "FROM book_borrow\n" +
               "         INNER JOIN books\n" +
               "             ON book_borrow.book_id = books.id\n" +
               "         INNER JOIN book_categories\n" +
               "             ON books.book_category_id = book_categories.id\n" +
               "GROUP BY book_categories.name\n" +
               "ORDER BY countofbookcategories DESC";
        DB_Util.runQuery(query);
        actualPopularGenre=DB_Util.getFirstRowFirstColumn();

    }
    @Then("the most popular book genre should be {string}.")
    public void the_most_popular_book_genre_should_be(String expectedPopularGenre) {
        Assert.assertEquals(expectedPopularGenre,actualPopularGenre);
    }
}
