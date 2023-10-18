package StepDefinition;

import PageObjects.LoginPage;
import Utilitis.ApplicationSpecific;
import Utilitis.ExcelHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;

import static testBase.Base.getDriver;

public class LoginPage_StepDef {

    ApplicationSpecific applicationSpecific = new ApplicationSpecific(getDriver());

    LoginPage loginPage = new LoginPage(getDriver());

    @Given("user navigates to sauce demo website")
    public void user_navigates_to_sauce_demo_website() {
      applicationSpecific.launchBrowser();

    }

    @Then("user confirms css value of Login button")
    public void user_confirms_css_value_of_login_button() throws Exception {

       loginPage.VerifyLoginBtnCSSValue(getDriver());
       applicationSpecific.quitBrowser();

    }


    @Then("username and password text is displayed")
    public void username_and_password_text_is_displayed() throws IOException {
        loginPage.VerifyUsernameandPasswordText(getDriver());
        applicationSpecific.quitBrowser();
    }

    @When("user logs in with correct username and password")
    public void user_logs_in_with_correct_username_and_password() {
        loginPage.LoginIn(getDriver(),applicationSpecific.getValue("username"),applicationSpecific.getValue("password"));
    }

    @When("user enters incorrect username and password")
    public void user_enters_incorrect_username_and_password() {
        loginPage.LoginIn(getDriver(), applicationSpecific.getValue("WrongUsername"), applicationSpecific.getValue("WrongPassword"));

    }

    @Then("error message is displayed")
    public void error_message_is_displayed() throws IOException {
        loginPage.ErrorMessage(getDriver());
    }

    @Then("user clicks on the X icon on the error message to make it disappear")
    public void user_clicks_on_the_x_icon_on_the_error_message_to_make_it_disappear() {
        loginPage.XIcon(getDriver());
        applicationSpecific.quitBrowser();
    }


}
