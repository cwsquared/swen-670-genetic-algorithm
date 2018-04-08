package geneticalgorithm;

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
	
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc2Zero() {
		FitnessFunc2 f2 = new FitnessFunc2(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "0000000000000000";
		ind[0][1] = "0000000000000000";
		assertEquals(f2.getFitness(ind), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1.
	public void testGetFitnessFunc2One() {
		FitnessFunc2 f2 = new FitnessFunc2(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "1111111111111111";
		ind[0][1] = "0000000000000000";
		assertEquals(f2.getFitness(ind), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = (1/15).
	public void testGetFitnessFunc2OneFifteenth() {
		FitnessFunc2 f3 = new FitnessFunc2(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "1110110001001100";
		ind[0][1] = "0010000010000000";
		assertEquals(f3.getFitness(ind), 0.04123937851565791, 1E-10);
	}
	
	
}


