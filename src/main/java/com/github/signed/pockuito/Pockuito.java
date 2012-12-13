package com.github.signed.pockuito;

import org.mockito.Mockito;

public class Pockuito {
    public static <T> T mockBuilder(Class<T>classToMock){
        return Mockito.mock(classToMock);
    }
}
