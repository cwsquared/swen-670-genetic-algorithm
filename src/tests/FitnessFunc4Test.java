package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.FitnessFunc4;

public class FitnessFunc4Test {

	@Test
	// Test the default constructor
	public void testFitnessFunc4DefaultConstructor() {
		FitnessFunc4 f4 = new FitnessFunc4();
		assertEquals(f4.getVariableCount(), 1);
		assertEquals(f4.getLowerBound(), 0);
		assertEquals(f4.getUpperBound(), 1);
	}
	
	@Test
	// Test the constructor that sets privates attributes
	public void testFitnessFunc4Constructor() {
		FitnessFunc4 f4 = new FitnessFunc4(1, -1, 6);
		assertEquals(f4.getVariableCount(), 1);
		assertEquals(f4.getLowerBound(), -1);
		assertEquals(f4.getUpperBound(), 6);
	}
	
}
