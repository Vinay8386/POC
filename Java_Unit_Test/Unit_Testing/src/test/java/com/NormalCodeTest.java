package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.service.CalculatorService;
import com.service.NormalCode;

public class NormalCodeTest {
	
	NormalCode n;
	@BeforeEach
    void setUp() {
        n = new NormalCode();
    }
	
	@Test
	public void testSum() {
		//action
		//int expected=10;
		//int actual=n.sum(7, 3);
		//verification
		//assertEquals(expected, actual);
		assertEquals(10, n.sum(7, 3));
		assertEquals(0, n.sum(-3, 3));
		assertEquals(-1, n.sum(-4, 3));
		assertEquals(-10, n.sum(-7, -3));
	}
	
	@ParameterizedTest
	@CsvSource({
	    "10, 3, 7",
	    "-10, -5, -5",
	    "0, 0, 0",
	    "-3, -1, -2"
	})
	public void testSum2(int expected, int a, int b) {
		assertEquals(expected, n.sum(a, b));
	}
	
	@Test
	public void divideTest() {
		//action
		int actual=n.divide(4, 2);
		int expected=2;
		assertEquals(expected,actual);
		assertEquals(5,n.divide(10, 2));
	}
	
	@Test
	public void divideTestBYZero() {
		assertThrows(ArithmeticException.class,()->n.divide(4, 0));
	}
	
	@Test
	public void isPositiveTest() {
		assertTrue(n.isPositive(2)); //positive scenario
		assertFalse(n.isPositive(0)); //negative scenario
		assertFalse(n.isPositive(-10));
	}
	
	@Test
	public void findBySquareRootTest() {
		assertEquals(5, n.findSquareRoot(25));
		assertEquals(null, n.findSquareRoot(-25));
	}

}
