package com.example.demo.ch2.component;

import com.example.demo.ch2._interfaceFile.Operation;
import org.springframework.stereotype.Component;

@Component
public class Multiplication implements Operation {
    @Override
    public int apply(int lhs, int rhs) {
        return lhs*rhs;
    }

    @Override
    public boolean handles(char op) {
        return '*' == op;
    }
}
