package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.FitnessFunc1;

public class FitnessFunc1Test {

	@Test
	// Test the default constructor
	public void testFitnessFunc1DefaultConstructor() {
		FitnessFunc1 f1 = new FitnessFunc1();
		assertEquals(f1.getVariableCount(), 1);
		assertEquals(f1.getLowerBound(), 0);
		assertEquals(f1.getUpperBound(), 1);
	}
	
	@Test
	// Test the constructor that sets privates attributes
	public void testFitnessFunc1Constructor() {
		FitnessFunc1 f1 = new FitnessFunc1(1, -1, 6);
		assertEquals(f1.getVariableCount(), 1);
		assertEquals(f1.getLowerBound(), -1);
		assertEquals(f1.getUpperBound(),6);
	}
	
}
