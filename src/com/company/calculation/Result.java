package com.company.calculation;

public class Result {
    private String value;
    private NumberSystemType type;

    public Result(int value, NumberSystemType type) throws Exception {
        this.type = type;
        this.initializeValue(value);
    }

    public String getValue() {
        return  this.value;
    }

    public NumberSystemType getType() {
        return this.type;
    }

    private void initializeValue(int value) throws Exception {
        if (this.type == NumberSystemType.Arabian) {
            this.value = String.valueOf(value);
        } else if (this.type == NumberSystemType.Roman) {
            if (value < 1) {
                throw new Exception("an operation with Roman numerals can only return a positive number");
            } else {
                this.value = new RomanArabicConverter().convertToRoman(value);
            }
        } else {
            throw new Exception("unsupported type");
        }
    }
}
