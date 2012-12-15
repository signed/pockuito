package com.github.signed.pockuito;

import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class Pockuito {
    public static <T> T mockBuilder(Class<T>classToMock){
        return Mockito.mock(classToMock, new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                return invocation.getMock();
            }
        });
    }

}
