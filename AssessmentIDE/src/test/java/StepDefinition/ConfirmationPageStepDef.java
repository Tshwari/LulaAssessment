package StepDefinition;

import PageObjects.ConfirmationPage;
import PageObjects.HomePage;
import Utilitis.ApplicationSpecific;
import io.cucumber.java.en.Then;

import java.io.IOException;

import static testBase.Base.getDriver;

public class ConfirmationPageStepDef {

    ConfirmationPage confirmationPage = new ConfirmationPage(getDriver());

    ApplicationSpecific applicationSpecific = new ApplicationSpecific(getDriver());
    HomePage homePage = new HomePage(getDriver());

    @Then("validate all checks on confirmation page")
    public void validate_all_checks_on_confirmation_page() throws IOException {
       confirmationPage.ValidConfirmationChecks(getDriver());
       homePage.VerifyHomePageURL(applicationSpecific.getValue("homePageURL"));
       applicationSpecific.quitBrowser();

    }

}
