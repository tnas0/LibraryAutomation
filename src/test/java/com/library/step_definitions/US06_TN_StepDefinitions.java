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

import java.util.List;

public class US06_TN_StepDefinitions {
    @Given("I am going to the  homepage")
    public void i_am_going_to_the_homepage() {
        LoginPage loginPage=new LoginPage();
        loginPage.login();
    }
    @When("I am going to navigate to {string} page")
    public void i_am_going_to_navigate_to_page(String string) {
        CommonAreaPage commonAreaPage=new CommonAreaPage();
        commonAreaPage.navigateModule(string);
    }
    List<String> actualBookCategories;
    @When("I am g take all book categories in webpage")
    public void i_am_g_take_all_book_categories_in_webpage() {
        BookPage bookPage=new BookPage();
     actualBookCategories= BrowserUtil.getAllSelectOptions(bookPage.mainCategoryElement);
     actualBookCategories.remove(0);
    }
    List<String> expectedBookCategories;
    @When("I am going to execute query to get book categories")
    public void i_am_going_to_execute_query_to_get_book_categories() {
        String query="SELECT name\n" +
                "FROM book_categories";
        DB_Util.runQuery(query);
        expectedBookCategories=DB_Util.getColumnDataAsList(1);
    }
    @Then("I am going to verify book categories must match book_categories table from db")
    public void i_am_going_to_verify_book_categories_must_match_book_categories_table_from_db() {
        Assert.assertEquals(expectedBookCategories,actualBookCategories);
    }


}
