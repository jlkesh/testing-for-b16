package uz.jl;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.mockito.verification.VerificationMode;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class CalculatorServiceTest {

    @Test
    void add() {
        CalculatorService mock = Mockito.mock(CalculatorService.class);
        int a = 12;
        int b = 2;
        int expected = 14;
        when(mock.add(a, b)).thenReturn(expected);
        int result = mock.add(a, b);
        // result = mock.add(a, b);
        System.out.println(result);
        assertEquals(14, result);
//        Mockito.verify(mock).add(a, b);
//        Mockito.verify(mock).add(a, b);
        Mockito.verify(mock, VerificationModeFactory.only())
                .add(a, b);
    }

    @Test
    void div() {
        CalculatorService mock = Mockito.mock(CalculatorService.class);
        int a = 12;
        int b = 0;
        when(mock.div(a, b)).thenThrow(new RuntimeException("zero division error"));
        assertThrows(RuntimeException.class, () -> mock.div(a, b));
    }
}