package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import geneticalgorithm.FitnessFunction;

public class FitnessFunctionTest {

	@Test
	// Test the default constructor
	public void testFitnessFunc1DefaultConstructor() {
		FitnessFunction f = new FitnessFunction();
		assertEquals(f.getVariableCount(), 1);
		assertEquals(f.getLowerBound(), 0);
		assertEquals(f.getUpperBound(), 1);
	}
	
	@Test
	// Test the constructor that sets privates attributes
	public void testFitnessFunc1Constructor() {
		FitnessFunction f = new FitnessFunction(1, -1, 6);
		assertEquals(f.getVariableCount(), 1);
		assertEquals(f.getLowerBound(), -1);
		assertEquals(f.getUpperBound(),6);
	}
	
}
