package com.github.signed.pockuito;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Pockuito_Test {

    @Test
    public void returnsAnInstanceOfTheClass() throws Exception {
        assertThat(Pockuito.mockBuilder(SimpleBuilder.class), CoreMatchers.notNullValue());
    }

    @Test
    public void ifAMethodIsCalledOnTheMockOfTheBuilderItReturnsTheMock() throws Exception {
        SimpleBuilder builderMock = Pockuito.mockBuilder(SimpleBuilder.class);
        assertThat(builderMock.collectDetail("detail"), is(builderMock));
    }
}
