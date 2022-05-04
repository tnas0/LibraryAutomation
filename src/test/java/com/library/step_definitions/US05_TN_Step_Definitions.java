package com.library.step_definitions;

import com.library.pages.BookPage;
import com.library.pages.CommonAreaPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US05_TN_Step_Definitions {
    BookPage bookPage;
    @Given("I am going to the homepage of library app")
    public void i_am_going_to_the_homepage_of_library_app() {
        LoginPage loginPage=new LoginPage();
        loginPage.login();
    }
    @When("I will navigate to {string} page")
    public void i_will_navigate_to_page(String module) {
        CommonAreaPage commonAreaPage=new CommonAreaPage();
        commonAreaPage.navigateModule(module);
    }
    String bookName;
    @When("I will open a book called {string}")
    public void i_will_open_a_book_called(String searching) {
         bookPage=new BookPage();
        bookName=searching;
        bookPage.search.sendKeys(searching);
        BrowserUtil.waitFor(3);
    }
    @When("I will run query to get the book information from books table")
    public void i_will_run_query_to_get_the_book_information_from_books_table() {
       String query="SELECT name, author, year\n" +
               "FROM books\n" +
               "WHERE name = 'Chordeiles minor'";
        DB_Util.runQuery(query);


    }
    @Then("To verify book DB and UI information should be same")
    public void to_verify_book_db_and_ui_information_should_be_same() {
        String actualName=bookPage.bookName.getText();
        String actualArtName=bookPage.authorName.getText();
        String actualYear=bookPage.year.getText();
        String expectedName=DB_Util.getCellValue(1,1);
        String expectedArtName=DB_Util.getCellValue(1,2);
        String expectedYear=DB_Util.getCellValue(1,3);
        Assert.assertEquals(expectedName,actualName);
        Assert.assertEquals(expectedArtName,actualArtName);
        Assert.assertEquals(expectedYear,actualYear);
    }

}
