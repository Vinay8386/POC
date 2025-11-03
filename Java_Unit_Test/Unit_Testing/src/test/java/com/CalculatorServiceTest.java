package com;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.service.CalculatorService;

public class CalculatorServiceTest {
	
	//Initialization is mandatory otherwise it will throw null pointer exception
	//CalculatorService service=new CalculatorService();
	
	CalculatorService service;
	
	@BeforeEach
    void setUp() {
        service = new CalculatorService();
    }
	
	@Test
	public void testAdd() {
		assertEquals(5,service.add(2, 3));
	}
	
	//In case of multiple input
	@ParameterizedTest
	@CsvSource({
	    "2, 3, 5",
	    "10, 5, 15",
	    "0, 0, 0",
	    "-1, -1, -2"
	})
	void testAddMultipleInput(int a, int b, int expected) {
	    assertEquals(expected, service.add(a, b));
	}
	
	//In place of hardcoding value in class use csv file
	@ParameterizedTest
	@CsvFileSource(resources = "/input_data.csv", numLinesToSkip = 1)
	void testAddMultipleInputUsingCSVFile(int a, int b, int expected) {
	    assertEquals(expected, service.add(a, b));
	}
	
	//combine test case with edge case: Not recommended
	@Test
	public void testDivide() {
		assertEquals(1,service.divide(3, 3));
		assertEquals(0,service.divide(3, 0));
		assertThrows(ArithmeticException.class,()->service.divide(10, 0));
		assertEquals(2,service.divide(6, 3));
	}
	
	@Test
	public void testDivideSuccess() {
		assertEquals(1,service.divide(3, 3));
		assertEquals(2,service.divide(6, 3));
	}
	
	@Test
	public void testDivideByZero() { //Exception case
		assertThrows(ArithmeticException.class,()->service.divide(10, 0));
	}
	
	@Test
    void testIsPositive() {
        assertTrue(service.isPositive(5));
        assertFalse(service.isPositive(-3));
    }

    @Test
    void testFindSquareRoot() {
        assertEquals(3, service.findSquareRoot(9));
        assertNull(service.findSquareRoot(-4));
    }
}
