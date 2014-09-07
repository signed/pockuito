package com.github.signed.pockuito;

import org.mockito.Mockito;

public class Pockuito {
    public static <T> T mockBuilder(final Class<T> classToMock) {
        return Mockito.mock(classToMock, new BuilderMockBehaviour(classToMock, new MockFromReturnType() ));
    }

    public static <T> T mockBuilder(Class<T> classToMock, Object predefinedBuildArtifact) {
        return Mockito.mock(classToMock, new BuilderMockBehaviour(classToMock, new Predefined(predefinedBuildArtifact)));
    }

    public static <T> T verifyNoCallsTo(T mock) {
        return Mockito.verify(mock, Mockito.times(0));
    }
}