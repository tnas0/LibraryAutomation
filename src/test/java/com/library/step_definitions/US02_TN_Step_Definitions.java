package com.library.step_definitions;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_TN_Step_Definitions {
    String actualBarrowedbooks;
    @Given("I am in  library app's homepage")
    public void i_am_in_library_app_s_homepage() {
        LoginPage loginPage=new LoginPage();
        loginPage.login();
    }
    @When("I will take borrowed books number")
    public void i_will_take_borrowed_books_number() {
        DashBoardPage dashBoardPage=new DashBoardPage();
        BrowserUtil.waitFor(3);
        actualBarrowedbooks=dashBoardPage.borrowedBooksNumber.getText();
    }
    @Then("borrowed books number information should be same with DB")
    public void borrowed_books_number_information_should_be_same_with_db() {
         String DB="SELECT COUNT(*)\n" +
                 "FROM book_borrow\n" +
                 "WHERE is_returned = 0;";
        DB_Util.runQuery(DB);
        String expectedBookNumber=DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBookNumber,actualBarrowedbooks);
    }

}
