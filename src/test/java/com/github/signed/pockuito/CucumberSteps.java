package com.github.signed.pockuito;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.sameInstance;

public class CucumberSteps {

    private SimpleBuilder mockedBuilder;
    private SimpleBuilder detailResponse;

    @Given("^a SimpleBuilder that constructs an ObjectUnderConstruction$")
    public void a_SimpleBuilder_that_constructs_an_ObjectUnderConstruction() throws Throwable {
        //set the scene, nothing to do
    }

    @Given("^I created a mock for the SimpleBuilder$")
    public void I_created_a_mock_for_the_SimpleBuilder() throws Throwable {
        mockedBuilder = Pockuito.mockBuilder(SimpleBuilder.class);
    }

    @When("^I invoke a method that has SimpleBuilder as return type$")
    public void I_invoke_a_method_that_has_SimpleBuilder_as_return_type() throws Throwable {
        detailResponse = mockedBuilder.collectDetail("detail");
    }

    @Then("^the mock returns itself$")
    public void the_mock_returns_itself() throws Throwable {
        Assert.assertThat(detailResponse, sameInstance(mockedBuilder));
    }
}
