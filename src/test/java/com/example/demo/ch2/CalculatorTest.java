package com.example.demo.ch2;

import com.example.demo.ch2._classFile.Calculator;
import com.example.demo.ch2._interfaceFile.Operation;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Collections;

import static org.mockito.ArgumentMatchers.anyChar;

public class CalculatorTest {
    private Calculator calculator;
    private Operation mockOperation;

    // 생성자 주입을 위한 mock객체 생성?

    @Before
    public void setUp() {
        this.mockOperation = Mockito.mock(Operation.class);
        this.calculator = new Calculator(Collections.singletonList(mockOperation));
    }


    @Test(expected = IllegalAccessException.class)
    public void throwExceptionWhenNoSuitableOperationFound(){
        // 무조건 false로 반환하게 객체를 주입?
        Mockito.when(mockOperation.handles(anyChar())).thenReturn(false);
        //then
        calculator.calculate(2,2,'*');


    }



    @Test
    public void shouldCallApplyMethodWhenSuitableOperationFound(){
        // true를 반환
        Mockito.when(mockOperation.handles(anyChar())).thenReturn(true);
        Mockito.when(mockOperation.apply(2,2)).thenReturn(4);

        // then
        calculator.calculate(2,2,'*');

        Mockito.verify(mockOperation, Mockito.times(1)).apply(2,2);
    }




}
