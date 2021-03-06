package com.github.signed.pockuito;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Pockuito_Test {

    private final SimpleBuilder mockedBuilder = Pockuito.mockBuilder(SimpleBuilder.class);

    @Test
    public void returnsAnInstanceOfTheClass() throws Exception {
        assertThat(mockedBuilder, CoreMatchers.notNullValue());
    }

    @Test
    public void ifAMethodIsCalledOnTheMockOfTheBuilderItReturnsTheMock() throws Exception {
        assertThat(mockedBuilder.collectDetail("detail"), is(mockedBuilder));
    }

    @Test
    public void returnAMockOfTheInstanceUnderConstructionIfTheBuildMethodIsCalled() throws Exception {
        assertThat(mockedBuilder.build(), instanceOf(ObjectUnderConstruction.class));
    }
}
