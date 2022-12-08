package com.company.calculation;

public class RomanArabicConverter {
    public int convertToArabic(String roman) {
        int decimal = 0;
        int lastNumber = 0;

        for (int x = roman.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = roman.charAt(x);

            switch (convertToDecimal) {
                case 'M':
                    decimal = this.processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;

                case 'D':
                    decimal = this.processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;

                case 'C':
                    decimal = this.processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;

                case 'L':
                    decimal = this.processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;

                case 'X':
                    decimal = this.processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;

                case 'V':
                    decimal = this.processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;

                case 'I':
                    decimal = this.processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }

        return decimal;
    }

    public String convertToRoman(int arabic) {
        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[arabic / 1000] + C[(arabic % 1000) / 100] + X[(arabic % 100) / 10] + I[(arabic % 10)];
    }

    private int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (lastNumber > decimal) {
            return lastDecimal - decimal;
        } else {
            return lastDecimal + decimal;
        }
    }
}
