package com.github.signed.pockuito;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MockBuilderSteps {

    private final ObjectUnderConstruction predefinedBuildArtifact = new ObjectUnderConstruction("predefined");
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

    @And("^I create a mock for the SimpleBuilder with a defined ObjectUnderConstruction$")
    public void I_create_a_mock_for_the_SimpleBuilder_with_a_defined_ObjectUnderConstruction() throws Throwable {
        mockedBuilder = Pockuito.mockBuilder(SimpleBuilder.class, predefinedBuildArtifact);
    }

    @When("^I invoke a method on the mock that has SimpleBuilder as return type$")
    public void I_invoke_a_method_that_has_SimpleBuilder_as_return_type() throws Throwable {
        detailResponse = mockedBuilder.collectDetail("detail");
    }

    @Then("^the mock returns itself$")
    public void the_mock_returns_itself() throws Throwable {
        assertThat(detailResponse, sameInstance(mockedBuilder));
    }

    @When("^I invoke the build method on the mock$")
    public void I_invoke_the_build_method_on_the_mock() throws Throwable {
        objectUnderConstruction = mockedBuilder.build();
    }

    @Then("^the mock returns a mock of the methods return type$")
    public void the_mock_returns_a_mock_of_the_methods_return_type() throws Throwable {
        assertThat(objectUnderConstruction, instanceOf(ObjectUnderConstruction.class));
    }

    @Then("^the predefined ObjectUnderConstruction is returned$")
    public void the_predefined_ObjectUnderConstruction_is_returned() throws Throwable {
        assertThat(objectUnderConstruction, sameInstance(predefinedBuildArtifact));
    }
}
