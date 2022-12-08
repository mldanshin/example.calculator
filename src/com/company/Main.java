package com.company;

import com.company.calculation.Expression;
import com.company.calculation.ExpressionCreator;
import com.company.calculation.Result;

public class Main {
    public static void main(String[] args) {
        Input input = new Input();
        Output output = new Output();

        try {
            Expression expression = new ExpressionCreator(input.getDirtyExpression()).getExpression();
            Result result = expression.calculate();
            output.display(result.getValue());
        } catch (Exception ex) {
            output.display(ex.getMessage());
        }
    }
}
