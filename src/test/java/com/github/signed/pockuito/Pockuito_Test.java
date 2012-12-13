package com.github.signed.pockuito;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class Pockuito_Test {

    @Test
    public void returnsAnInstanceOfTheClass() throws Exception {
        assertThat(Pockuito.mockBuilder(SimpleBuilder.class), CoreMatchers.notNullValue());
    }

    private class SimpleBuilder {


    }
}
