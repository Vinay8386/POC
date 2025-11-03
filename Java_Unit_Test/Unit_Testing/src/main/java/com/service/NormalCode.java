package com.service;

public class NormalCode {
	
	public int sum(int a, int b) {
		return a+b;
	}
	
	public int divide(int a, int b) {
		return a/b;
	}
	
	public boolean isPositive(int num) {
        return num > 0;
    }

    public Integer findSquareRoot(int num) {
        return num >= 0 ? (int)Math.sqrt(num) : null;
    }
}
