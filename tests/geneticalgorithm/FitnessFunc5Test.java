package geneticalgorithm;

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
		FitnessFunc5 f5 = new FitnessFunc5(2, -3, 3);
		assertEquals(f5.getVariableCount(), 2);
		assertEquals(f5.getLowerBound(), -3);
		assertEquals(f5.getUpperBound(), 3);
	}	
	
	@Test
	// Test that the getFitness method returns correct value for x = 0.
	public void testGetFitnessFunc5NegativeThrees() {
		FitnessFunc5 f5 = new FitnessFunc5();
		String[][] ind = new String[2][2];
		ind[0][0] = "0000000000000000";
		ind[0][1] = "0000000000000000";
		ind[1][0] = "0000000000000000";
		ind[1][1] = "0000000000000000";
		assertEquals(f5.getFitness(ind), .0183654729, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1.
	public void testGetFitnessFunc5ThreeThree() {
		FitnessFunc5 f5 = new FitnessFunc5();
		String[][] ind = new String[2][2];
		ind[0][0] = "1111111111111111";
		ind[0][1] = "0000000000000000";
		ind[1][0] = "1111111111111111";
		ind[1][1] = "0000000000000000";
		assertEquals(f5.getFitness(ind), .0183654729, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 0 and y = 1
	public void testGetFitnessFunc5NegThreeThree() {
		FitnessFunc5 f5 = new FitnessFunc5();
		String[][] ind = new String[2][2];
		ind[0][0] = "0000000000000000";
		ind[0][1] = "0000000000000000";
		ind[1][0] = "1111111111111111";
		ind[1][1] = "0000000000000000";
		assertEquals(f5.getFitness(ind), .013802622498274672, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x = 1 and y = 0
	public void testGetFitnessFunc5ThreeNegThree() {
		FitnessFunc5 f5 = new FitnessFunc5();
		String[][] ind = new String[2][2];
		ind[0][0] = "1111111111111111";
		ind[0][1] = "0000000000000000";
		ind[1][0] = "0000000000000000";
		ind[1][1] = "0000000000000000";
		assertEquals(f5.getFitness(ind), .013802622498274672, 1E-10);
	}
	
	@Test
	// Test that the getFitness method returns correct value for x and y
	public void testGetFitnessFunc5ZeroZero() {
		FitnessFunc5 f5 = new FitnessFunc5();
		String[][] ind = new String[2][2];
		ind[0][0] = "0000000000000000000000000000000000000000000000000000000000000001";
		ind[0][1] = "0000000000000000000000000000000000000000000000000000000000000000";
		ind[1][0] = "0000000000000000000000000000000000000000000000000000000000000001";
		ind[1][1] = "0000000000000000000000000000000000000000000000000000000000000000";
		assertEquals(f5.getFitness(ind), Double.POSITIVE_INFINITY, 1E-10);
	}
	
}
