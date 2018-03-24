package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.FitnessFunc1;
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
	
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc2Zero() {
		FitnessFunc2 f2 = new FitnessFunc2(1, 0, 1);
		assertEquals(f2.getFitness("0000000000000000"), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1.
	public void testGetFitnessFunc2One() {
		FitnessFunc2 f2 = new FitnessFunc2(1, 0, 1);
		assertEquals(f2.getFitness("1111111111111111"), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc2OneFifteenth() {
		FitnessFunc2 f3 = new FitnessFunc2(1, 0, 1);
		Double ret = f3.getFitness("1100110011001100");
//		System.out.println("===> "+ret);  ///--0.04123937851565791
		assertEquals(ret , 0.04123937851565791, 1E-10);
	}
	
	
}


