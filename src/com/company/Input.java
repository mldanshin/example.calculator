package com.company;

import java.util.Scanner;

public class Input {
    private String text;

    public Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the expression: ");
        this.text = scanner.nextLine();
    }

    public String getDirtyExpression() {
        return this.text;
    }
}
