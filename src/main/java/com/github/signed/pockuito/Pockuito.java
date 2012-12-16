package com.github.signed.pockuito;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class Pockuito {
    public static <T> T mockBuilder(final Class<T>classToMock){
        return Mockito.mock(classToMock, new BuilderMockBehaviour(classToMock));
    }

    private static class BuilderMockBehaviour implements Answer {
        private final Class<?> classToMock;

        public BuilderMockBehaviour(Class<?> classToMock) {
            this.classToMock = classToMock;
        }

        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            Class<?> returnType = invocation.getMethod().getReturnType();
            if(returnType.equals(classToMock)){
                return invocation.getMock();
            }else {
                return Mockito.mock(returnType);
            }
        }
    }
}