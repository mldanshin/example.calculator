package com.company.calculation;

public class OperatorCreator {
    public Operator getOperator(String lexeme) throws Exception {
        switch (lexeme) {
            case "+":
                return new Sum();
            case "-":
                return new Subtraction();
            case "*":
                return new Multiplication();
            case "/":
                return new Division();
            default:
                throw new Exception("unsupported operator");
        }
    }
}
