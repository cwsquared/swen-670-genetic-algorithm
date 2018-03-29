package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.FitnessFunc2;
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
	
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc4Zero() {
		FitnessFunc4 f4 = new FitnessFunc4(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "0000000000000000";
		ind[0][1] = "0000000000000000";
		assertEquals(f4.getFitness(ind), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1.
	public void testGetFitnessFunc4One() {
		FitnessFunc4 f4 = new FitnessFunc4(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "1111111111111111";
		ind[0][1] = "0000000000000000";
		assertEquals(f4.getFitness(ind), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1/15.
	public void testGetFitnessFunc4OneFifteenth() {
		FitnessFunc4 f4 = new FitnessFunc4(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "1100110011001100";
		ind[0][1] = "0000000000000000";
		assertEquals(f4.getFitness(ind) , 0.44319042360045985, 1E-10);
	}
	
	
	
}
