package com.github.signed.pockuito;

import org.mockito.invocation.InvocationOnMock;

public interface BuilderArtifactCreator {
    Object createFor(InvocationOnMock invocation);
}
