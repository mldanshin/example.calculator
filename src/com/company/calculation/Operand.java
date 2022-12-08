package com.company.calculation;

public class Operand {
    private int value;
    private NumberSystemType type;

    public Operand(String value) throws Exception {
        this.initializeType(value);
        this.initializeValue(value);
    }

    public int getValue() {
        return  this.value;
    }

    public NumberSystemType getType() {
        return this.type;
    }

    private void initializeType(String value) throws Exception {
        String regexOperandArabian = "^[1-9]|10$";
        String regexOperandRoman = "^X|(VI{0,3})|(I[VX])|I{1,3}$";

         if (value.matches(regexOperandArabian)) {
             this.type = NumberSystemType.Arabian;
         } else if (value.matches(regexOperandRoman)) {
             this.type = NumberSystemType.Roman;
         } else  {
             throw new Exception("The operand can be an Arabic or Roman integer from 1 to 10");
         }
    }

    private void initializeValue(String value) throws Exception {
        if (this.type == NumberSystemType.Arabian) {
            this.value = Integer.parseInt(value);
        } else if (this.type == NumberSystemType.Roman) {
            this.value = new RomanArabicConverter().convertToArabic(value);
        } else {
            throw new Exception("unsupported operand type");
        }
    }
}
