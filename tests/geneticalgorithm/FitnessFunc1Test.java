package geneticalgorithm;

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
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc1Zero() {
		FitnessFunc1 f1 = new FitnessFunc1(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "10101010";
		ind[0][1] = "10101010";
		assertEquals(f1.getFitness(ind), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1.
	public void testGetFitnessFunc1One() {
		FitnessFunc1 f2 = new FitnessFunc1(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "10101010";
		ind[0][1] = "01010101";
		assertEquals(f2.getFitness(ind), 0.0, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = (1/15).
	public void testGetFitnessFunc1OneFifteenth() {
		FitnessFunc1 f3 = new FitnessFunc1(1, 0, 1);
		String[][] ind = new String[1][2];
		ind[0][0] = "1000100010001000";
		ind[0][1] = "0000000000000000";
		assertEquals(f3.getFitness(ind), 0.4218750, 1E-10);
	}
}
