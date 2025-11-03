package com.service;


public class CalculatorService {
	
	public int add(int a, int b) {
        return a + b;
    }

    public int divide(int a, int b) {
        if (b == 0) throw new ArithmeticException("Division by zero not allowed");
        return a / b;
    }

    public boolean isPositive(int num) {
        return num > 0;
    }

    public Integer findSquareRoot(int num) {
        return num >= 0 ? (int)Math.sqrt(num) : null;
    }
}
