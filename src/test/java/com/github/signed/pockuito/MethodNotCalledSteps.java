package com.github.signed.pockuito;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.mockito.Mockito;
import org.mockito.exceptions.verification.NeverWantedButInvoked;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MethodNotCalledSteps {


    private static interface AnInterface {

        void method();

        void anotherMethod();
    }

    private AnInterface theMock;
    private Boolean verificationFailed = null;

    @Given("^a mock$")
    public void a_mock() throws Throwable {
        theMock = Mockito.mock(AnInterface.class);
    }

    @Given("^I call the method$")
    public void I_call_the_method() throws Throwable {
        theMock.method();
    }

    @And("^I call another method$")
    public void I_call_another_method() throws Throwable {
        theMock.anotherMethod();
    }

    @When("^I verify that the method was not called$")
    public void I_verify_that_the_method_was_not_called() throws Throwable {
        try {
            Pockuito.verifyNoCallsTo(theMock).method();
            verificationFailed = false;
        } catch (NeverWantedButInvoked e) {
            verificationFailed = true;
        }
    }

    @Then("^the verification fails$")
    public void the_verification_fails() throws Throwable {
        assertThat(verificationFailed, is(true));
    }

    @Then("^the verification succeeds$")
    public void the_verification_succeeds() throws Throwable {
        assertThat(verificationFailed, is(false));
    }
}
