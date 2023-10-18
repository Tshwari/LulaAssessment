package StepDefinition;

import PageObjects.HomePage;
import Utilitis.ApplicationSpecific;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static testBase.Base.getDriver;

public class HomePageStepDef {

    ApplicationSpecific applicationSpecific = new ApplicationSpecific(getDriver());

    HomePage homePage = new HomePage(getDriver());

    @Then("verify correct homepage is loaded")
    public void verify_correct_homepage_is_loaded() {
        homePage.VerifyHomePageURL(applicationSpecific.getValue("homePageURL"));
    }

    @Then("verify remove button on {string} is displayed")
    public void verify_remove_button_on_is_displayed(String item) {

        homePage.VerifyItemRemovalButtonIsDisplayed(getDriver(), item);
    }
    @Then("user logs out")
    public void user_logs_out() {
        homePage.ClickLogoutBtn(getDriver());
        applicationSpecific.quitBrowser();
    }


    @When("a user clicks on remove button for {string}")
    public void a_user_clicks_on_remove_button_for(String item) {
        homePage.ClickItemRemovalButton(getDriver(),item);
    }


    @When("a user clicks {string} add to cart button")
    public void a_user_clicks_add_to_cart_button(String item) {
        homePage.ClickNewItemAddedToCart(getDriver(),item);
    }

    @Then("user click the hamburger bar")
    public void user_click_the_hamburger_bar() throws Exception {
        homePage.ClickHamburgerMenu(getDriver());
        applicationSpecific.quitBrowser();
    }

    @When("user clicks on the cart")
    public void user_clicks_on_the_cart() {
        homePage.ClickOnCart(getDriver());
    }

    @When("user selects the product storing icon  and select Price \\(low to high)")
    public void user_selects_the_product_storing_icon_and_select_price_low_to_high() {
        homePage.FilterBox(getDriver());
    }
    @Then("user confirm that the notification badge displays on the shopping cart icon")
    public void user_confirm_that_the_notification_badge_displays_on_the_shopping_cart_icon() {
        homePage.ShoppingCartBadge(getDriver());
    }
}
