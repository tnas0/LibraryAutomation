package com.library.step_definitions;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtil;
import com.library.utilities.ConfigReader;
import com.library.utilities.DB_Util;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_AD_Step_Definitions {

    LoginPage loginPage;
    //LoginPage loginPage =new LoginPage();
    DashBoardPage dashBoardPage;
    String actualBorrowedBooksNumber;

    @Given("I am on the homepage of library app")
    public void iAmOnTheHomepageOfLibraryApp() {

        loginPage = new LoginPage();
        loginPage.login();
    }

    @When("I take borrowed books number")
    public void iTakeBorrowedBooksNumber() {
        dashBoardPage = new DashBoardPage();
        BrowserUtil.waitFor(3);
        actualBorrowedBooksNumber = dashBoardPage.borrowedBooksNumber.getText();
    }
    @Then("borrowed books number information must match with DB")
    public void borrowedBooksNumberInformationMustMatchWithDB() {
        String query = "SELECT COUNT(*)\n" +
                "FROM book_borrow\n" +
                "WHERE is_returned = 0;";
        DB_Util.runQuery(query);
        String expectedBorrowedBooksNumber = DB_Util.getFirstRowFirstColumn();
        Assert.assertEquals(expectedBorrowedBooksNumber, actualBorrowedBooksNumber);
    }
}
