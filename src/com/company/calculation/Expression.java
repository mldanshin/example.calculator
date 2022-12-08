package com.company.calculation;

public class Expression {
    Operand operand1;
    Operator operator;
    Operand operand2;

    public  Expression(Operand operand1, Operator operator, Operand operand2) throws Exception {
        this.operand1 = operand1;
        this.operator = operator;
        this.operand2 = operand2;

        this.verifyOperandIdentity();
    }

    public Result calculate() throws Exception {
        return new Result(
                operator.calculate(this.operand1, this.operand2),
                this.operand1.getType()
        );
    }

    private void verifyOperandIdentity() throws Exception {
        if (this.operand1.getType() != this.operand2.getType()) {
            throw new Exception("both operands must be of the same type");
        }
    }
}
