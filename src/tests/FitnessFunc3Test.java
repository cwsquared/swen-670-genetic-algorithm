package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.FitnessFunc3;

public class FitnessFunc3Test {

	@Test
	// Test the default constructor
	public void testFitnessFunc3DefaultConstructor() {
		FitnessFunc3 f3 = new FitnessFunc3();
		assertEquals(f3.getVariableCount(), 1);
		assertEquals(f3.getLowerBound(), 0);
		assertEquals(f3.getUpperBound(), 1);
	}
	
	@Test
	// Test the constructor that sets privates attributes
	public void testFitnessFunc3Constructor() {
		FitnessFunc3 f3 = new FitnessFunc3(1, -1, 6);
		assertEquals(f3.getVariableCount(), 1);
		assertEquals(f3.getLowerBound(), -1);
		assertEquals(f3.getUpperBound(), 6);
	}
	
}
