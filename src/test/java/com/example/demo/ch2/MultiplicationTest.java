package com.example.demo.ch2;

import com.example.demo.ch2.component.Multiplication;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MultiplicationTest {

    private final Multiplication addition = new Multiplication();

    @Test
    public void shouldMatchOperation(){
        Assertions.assertThat(addition.handles('*')).isTrue();
        Assertions.assertThat(addition.handles('/')).isFalse();
    }

    @Test
    public void shouldCorrectlyApplyFormula(){
        Assertions.assertThat(addition.apply(2,2)).isEqualTo(4);
        Assertions.assertThat(addition.apply(2,10)).isEqualTo(120);
    }


}
