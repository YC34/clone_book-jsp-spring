package com.example.demo.ch2._classFile;

import com.example.demo.ch2._interfaceFile.Operation;
import org.springframework.stereotype.Component;

import java.util.Collection;


@Component
public class Calculator {

    private final Collection<Operation> operations;


    public Calculator(Collection<Operation> operations) {
        this.operations = operations;
    }


    public void calculate(int lhs, int rhs , char op) {

        for (Operation operation : operations){
            if(operation.handles(op)){
                int result = operation.apply(lhs,rhs);
                System.out.printf("%d %d %s = %d%n",lhs,rhs,op,result);
                return;
            }
        }

        throw new IllegalArgumentException("이런 연산은  없습니다 . "+op);
    }

}
