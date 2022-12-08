package com.company.calculation;

public class Subtraction implements Operator {

    public int calculate(Operand operand1, Operand operand2) {
        return operand1.getValue() - operand2.getValue();
    }
}
