package com.github.signed.pockuito;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class Pockuito {
    public static <T> T mockBuilder(final Class<T>classToMock){
        return Mockito.mock(classToMock, new BuilderMockBehaviour(classToMock));
    }

    public static <T> T mockBuilder(Class<T> classToMock, Object predefinedBuildArtifact) {
        return Mockito.mock(classToMock, new BuilderMockBehaviour(classToMock, predefinedBuildArtifact));
    }

    private static class BuilderMockBehaviour implements Answer {
        private final Class<?> classToMock;
        private final Object predefinedBuildArtifact;

        public BuilderMockBehaviour(Class<?> classToMock, Object predefinedBuildArtifact) {
            this.classToMock = classToMock;
            this.predefinedBuildArtifact = predefinedBuildArtifact;
        }

        public <T> BuilderMockBehaviour(Class<T> classToMock) {
            this(classToMock, null);
        }

        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            Class<?> returnType = invocation.getMethod().getReturnType();
            if(returnType.equals(classToMock)){
                return invocation.getMock();
            }else {
                if(null == predefinedBuildArtifact){
                    return Mockito.mock(returnType);
                }else{
                    return predefinedBuildArtifact;
                }
            }
        }
    }
}