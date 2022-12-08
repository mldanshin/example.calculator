package com.company.calculation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionCreator {
    private String text;
    private Expression expression;

    public ExpressionCreator(String text) throws Exception {
        this.text = text;

        this.deleteSpace();
        this.verify();
    }

    public Expression getExpression() {
        return  this.expression;
    }

    private void verify() throws Exception {
        Pattern pattern = Pattern.compile("[+\\-*/]");
        String[] operands = pattern.split(this.text);
        int operandLength = operands.length;

        Matcher matcher = pattern.matcher(this.text);

        if (operandLength < 2) {
            throw new Exception("A string is not a mathematical operation");
        } else if (operandLength > 2) {
            for (String operand : operands) {
                if (operand == "") {
                    throw new Exception("the number must be positive");
                }
            }
            throw new Exception("The format of the mathematical" +
                    "operation does not satisfy the task - two operands and one operator (+, -, /, *)");
        } else {
            Operand operand1 = new Operand(operands[0]);
            Operand operand2 = new Operand(operands[1]);

            matcher.find();
            String lexemeOperator = matcher.group();
            Operator operator = new OperatorCreator().getOperator(lexemeOperator);

            this.expression = new Expression(operand1, operator, operand2);
        }
    }

    private void deleteSpace() {
        Pattern pattern = Pattern.compile("\\s+");
        Matcher matcher = pattern.matcher(this.text);
        this.text = matcher.replaceAll("");
    }
}
