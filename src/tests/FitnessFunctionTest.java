package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import geneticalgorithm.FitnessFunction;

public class FitnessFunctionTest {

	@Test
	// Test the default constructor
	public void testFitnessFunctionDefaultConstructor() {
		FitnessFunction f = new FitnessFunction();
		assertEquals(f.getVariableCount(), 1);
		assertEquals(f.getLowerBound(), 0);
		assertEquals(f.getUpperBound(), 1);
	}
	
	@Test
	// Test the constructor that sets privates attributes
	public void testFitnessFunctionConstructor() {
		FitnessFunction f = new FitnessFunction(1, -1, 6);
		assertEquals(f.getVariableCount(), 1);
		assertEquals(f.getLowerBound(), -1);
		assertEquals(f.getUpperBound(),6);
	}
	
	@Test
	//Test that the Gene Expression method returns correct string of expressed genes with zeroed methylation
	public void testExpressGeneticsZeroMethylation() {
		FitnessFunction ff = new FitnessFunction();
		String eg1 = ff.expressGenetics("10101010","00000000");
		assertEquals(eg1, "10101010");
	}
	
	@Test
	//Test that the Gene Expression method returns correct string of expressed genes with some methylation
	public void testExpressGeneticsSomeMethylation() {
		FitnessFunction ff = new FitnessFunction();
		String eg2 = ff.expressGenetics("10101010","10101010");
		assertEquals(eg2,"00000000");
	}
	
	@Test
	//Test that the Gene Expression method returns correct string of expressed genes with methylation of all 1's
	public void testExpressGeneticsFullMethylation() {
		FitnessFunction ff = new FitnessFunction();
		String eg3 = ff.expressGenetics("10101010","11111111");
		assertEquals(eg3,"01010101");
	}
	
	@Test
	//Test that the getFitness method returns null
	public void testGetFitness() {
		String[][] ind = new String[1][2];
		ind[0][0] = "10101010";
		ind[0][1] = "01010101";
		FitnessFunction ff = new FitnessFunction(1, 0, 1);
		assertEquals(ff.getFitness(ind),null);
	}
	
	@Test
	//Test that the convertGenesToNumbers method returns the correct double value for a genes string "00000000"
	public void testConvertGenesToNumberZero() {
		String genes = "00000000";
		FitnessFunction ff = new FitnessFunction(1, 0, 1);
		assertEquals(ff.convertGenesToNumber(genes), 0.0, 1E-10);
	}
	
	@Test
	//Test that the convertGenesToNumbers method returns the correct double value for a genes string "00000000"
	public void testConvertGenesToNumberOne() {
		String genes = "11111111";
		FitnessFunction ff = new FitnessFunction(1, 0, 1);
		assertEquals(ff.convertGenesToNumber(genes), 1.0, 1E-10);
	}
	
	@Test
	//Test that the convertGenesToNumbers method returns the correct double value for a genes string "00000000"
	public void testConvertGenesToNumberOneFifteenth() {
		String genes = "1000100010001000";
		FitnessFunction ff = new FitnessFunction(1, 0, 1);
		assertEquals(ff.convertGenesToNumber(genes), 0.06666666667, 1E-10);
	}
}
