package com.github.signed.pockuito;

import org.mockito.invocation.InvocationOnMock;

public class Predefined implements BuilderArtifactCreator {
    private final Object predefinedBuildArtifact;

    public Predefined(Object predefinedBuildArtifact) {
        this.predefinedBuildArtifact = predefinedBuildArtifact;
    }

    @Override
    public Object createFor(InvocationOnMock invocation) {
        return this.predefinedBuildArtifact;
    }
}
