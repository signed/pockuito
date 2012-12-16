package com.github.signed.pockuito;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;

public class MockFromReturnType implements BuilderArtifactCreator {

    @Override
    public Object createFor(InvocationOnMock invocation) {
        return Mockito.mock(invocation.getMethod().getReturnType());
    }
}
