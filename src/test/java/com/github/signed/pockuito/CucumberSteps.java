package com.github.signed.pockuito;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.sameInstance;

public class CucumberSteps {

    private SimpleBuilder mockedBuilder;
    private SimpleBuilder detailResponse;
    private ObjectUnderConstruction objectUnderConstruction;

    @Given("^a SimpleBuilder that constructs an ObjectUnderConstruction$")
    public void a_SimpleBuilder_that_constructs_an_ObjectUnderConstruction() throws Throwable {
        //set the scene, nothing to do
    }

    @Given("^I create a mock for the SimpleBuilder$")
    public void I_created_a_mock_for_the_SimpleBuilder() throws Throwable {
        mockedBuilder = Pockuito.mockBuilder(SimpleBuilder.class);
    }

    @When("^I invoke a method on the mock that has SimpleBuilder as return type$")
    public void I_invoke_a_method_that_has_SimpleBuilder_as_return_type() throws Throwable {
        detailResponse = mockedBuilder.collectDetail("detail");
    }

    @Then("^the mock returns itself$")
    public void the_mock_returns_itself() throws Throwable {
        Assert.assertThat(detailResponse, sameInstance(mockedBuilder));
    }

    @When("^I invoke the build method on the mock$")
    public void I_invoke_the_build_method_on_the_mock() throws Throwable {
        objectUnderConstruction = mockedBuilder.build();
    }

    @Then("^the mock returns a mock of the methods return type$")
    public void the_mock_returns_a_mock_of_the_methods_return_type() throws Throwable {
        Assert.assertThat(objectUnderConstruction, instanceOf(ObjectUnderConstruction.class));
    }
}
