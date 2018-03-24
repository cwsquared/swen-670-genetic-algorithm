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
		assertEquals(f4.getFitness("0000000000000000"), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1.
	public void testGetFitnessFunc4One() {
		FitnessFunc4 f4 = new FitnessFunc4(1, 0, 1);
		assertEquals(f4.getFitness("1111111111111111"), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc2OneFifteenth() {
		FitnessFunc4 f4 = new FitnessFunc4(1, 0, 1);
		Double ret = f4.getFitness("0100010001000100");
//		System.out.println("===> "+ret);  ///--0.44319042360045985
		assertEquals(ret , 0.44319042360045985, 1E-10);
	}
	
	
	
}
