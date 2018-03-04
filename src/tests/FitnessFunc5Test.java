package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.FitnessFunc5;

public class FitnessFunc5Test {

	@Test
	// Test the default constructor
	public void testFitnessFunc5DefaultConstructor() {
		FitnessFunc5 f5 = new FitnessFunc5();
		assertEquals(f5.getVariableCount(), 2);
		assertEquals(f5.getLowerBound(), -3);
		assertEquals(f5.getUpperBound(), 3);
	}
	
	@Test
	// Test the constructor that sets privates attributes
	public void testFitnessFunc5Constructor() {
		FitnessFunc5 f5 = new FitnessFunc5(1, -1, 6);
		assertEquals(f5.getVariableCount(), 1);
		assertEquals(f5.getLowerBound(), -1);
		assertEquals(f5.getUpperBound(), 6);
	}
	
}
