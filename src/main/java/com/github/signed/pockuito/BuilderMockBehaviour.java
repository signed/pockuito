package com.github.signed.pockuito;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class BuilderMockBehaviour implements Answer {
    private final Class<?> classToMock;
    private final BuilderArtifactCreator creator;

    public BuilderMockBehaviour(Class<?> classToMock, BuilderArtifactCreator creator) {
        this.classToMock = classToMock;
        this.creator = creator;
    }

    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        Class<?> returnType = invocation.getMethod().getReturnType();
        if (returnType.equals(classToMock)) {
            return invocation.getMock();
        } else {
            return creator.createFor(invocation);
        }
    }
}
