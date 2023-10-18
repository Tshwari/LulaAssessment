package StepDefinition;

import RestClient.RestClient;
import Utilitis.ApplicationSpecific;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.io.IOException;

import static testBase.Base.getDriver;

public class CheckStatusOfSauceDemo_API_StepDef {

    RestClient api = new RestClient();
    int statusCode;
    ApplicationSpecific applicationSpecific = new ApplicationSpecific(getDriver());
    @Given("a user is given the sauce demo url and sends a Get request")
    public void a_user_is_given_the_sauce_demo_url_and_sends_a_get_request() throws IOException {

        statusCode = api.get(applicationSpecific.getValue("urlAPI"));
    }

    @Then("a valid respone is returned")
    public void a_valid_respone_is_returned() {
        Assert.assertEquals(statusCode,200);
    }
}
