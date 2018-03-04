package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.FitnessFunc2;

public class FitnessFunc2Test {

	@Test
	// Test the default constructor
	public void testFitnessFunc2DefaultConstructor() {
		FitnessFunc2 f2 = new FitnessFunc2();
		assertEquals(f2.getVariableCount(), 1);
		assertEquals(f2.getLowerBound(), 0);
		assertEquals(f2.getUpperBound(), 1);
	}
	
	@Test
	// Test the constructor that sets privates attributes
	public void testFitnessFunc2Constructor() {
		FitnessFunc2 f2 = new FitnessFunc2(1, -1, 6);
		assertEquals(f2.getVariableCount(), 1);
		assertEquals(f2.getLowerBound(), -1);
		assertEquals(f2.getUpperBound(), 6);
	}
	
}
