package StepDefinition;

import PageObjects.CartPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static testBase.Base.getDriver;

public class CartPageStepDef {

    CartPage cartPage = new CartPage(getDriver());

    @When("user fills in checkout information and clicks continue")
    public void user_fills_in_checkout_information_and_clicks_continue() {
        cartPage.FillCheckOutInfo(getDriver());
    }



    @Then("verify payment information has the correct sauceCard")
    public void verify_payment_information_has_the_correct_sauce_card() throws IOException {
        cartPage.VerifyPaymentInfo(getDriver());
    }
    @Then("user clicks finish checkout button")
    public void user_clicks_finish_checkout_button() {
       cartPage.ClickFinish(getDriver());
    }

    @When("user clicks checkout button")
    public void user_licks_checkout_button() {
       cartPage.ClickCheckOut(getDriver());
    }
}
