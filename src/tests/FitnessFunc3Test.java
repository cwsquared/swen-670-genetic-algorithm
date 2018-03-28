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
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc3Zero() {
		FitnessFunc3 f3 = new FitnessFunc3(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "0000000000000000";
		ind[0][1] = "0000000000000000";
		assertEquals(f3.getFitness(ind), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1.
	public void testGetFitnessFunc3One() {
		FitnessFunc3 f3 = new FitnessFunc3(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "1111111111111111";
		ind[0][1] = "0000000000000000";
		assertEquals(f3.getFitness(ind), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc3OneFifteenth() {
		FitnessFunc3 f3 = new FitnessFunc3(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "1100110011001100";
		ind[0][1] = "0000000000000000";
		assertEquals(f3.getFitness(ind) , 1.902692726297746E-4, 1E-10);
	}
	
	
	
}
