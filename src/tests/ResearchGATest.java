package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import geneticalgorithm.FitnessFunction;
import geneticalgorithm.ResearchGA;

public class ResearchGATest {

	private ResearchGA ga;
	
	@Before
	public void setUp() throws Exception{
		ga = new ResearchGA(1, 2, 3, 4.4, 5);
	}
	
	@Test
	// Test the constructor that sets privates attributes
	public void testResearchGAConstructor() {
		assertEquals("Constructor did not set population size", 1, ga.getPopulationSize());
		assertEquals("Constructor did not set number of generations", 2, ga.getNumberOfGenerations());
		assertEquals("Constructor did not set number of genes per individual", 3, ga.getNumberGenesPerIndividual());
		assertEquals("Constructor did not set mutation rate", 4.4, ga.getMutationRate(), 1);
		assertEquals("Constructor did not set methylation count", 5, ga.getMethylationCount());
	}
	
	@Test
	// Test the initialization function
	public void testInitialization() {
		/* Build GA Object with Constructor Arguments as follows
	 	 * @param popSize 			the population size 		2
		 * @param numGenerations	the number of generations 	2
		 * @param numGenes			the number of genes 		3
		 * @param mutation			the mutation rate			4.4
		 * @param methCount			the methylation count 		5
		 */
		ga = new ResearchGA(2, 2, 3, 4.4, 5);
		// initialize the population
		ga.initialization(ga.getPopulationSize());
		// Setup values of population array
		String[][][] pop = ga.getPopulation();
		// Set value of population size by checking length of population array
		int individuals = pop.length;
		// check that initialization passes back an array of correct size based on population size
		assertEquals("Initialization created pop of correct size", 1, individuals);
		
		// loop through all values for given population size
		
		for ( int a = 0; a < individuals; a++ ) {	
			// setup the values for each assert within the loop
			
			//int variables = pop[0].length;  // should be 1 for functions 1-4 or 2 for function 5
			//int values = pop[0][0].length;   // should always equal 2

			// check that initialization passes back an array with correct number of variables
			assertEquals("Initialization created pop with correct number of fitness function variabls", ,);
			
			// 		news check
			// fills the gene elements with strings equal to NUM_GENES_PER_INDIVIDUAL in length
			//assertEquals("Initialization created sequence with proper size", ,)
			
			// 		meth check
			// fills the methylation elements with the correct number of all zeroes
			//assertEquals("Initialization created sequence with expected methylation string", ,)
			
		}
		
		
	}
	
	@Test
	// Test getter and setter for current function
	public void testResearchGAGetSetCurrentFunction() {
		FitnessFunction f = new FitnessFunction();
		ga.setCurrentFunction(f);
		assertEquals("set/get CurrentFunction failed", f, ga.getCurrentFunction());
	}
	
	@Test
	// Test getter and setter for methylation count
	public void testResearchGAGetSetMethylationCount() {
		ga.setMethylationCount(12);
		assertEquals("set/get MethylationCount failed", 12, ga.getMethylationCount());
	}
	
	@Test
	// Test getter and setter for mutation rate
	public void testResearchGAGetSetMutationRate() {
		ga.setMutationRate(0.123);
		assertEquals("set/get MutationRate failed", 0.123, ga.getMutationRate(), 1);
	}
	
	@Test
	// Test getter and setter for next generation
	public void testResearchGAGetSetNextGen() {
		String[][][] ng = new String[2][2][2];
		ga.setNextGen(ng);
		assertArrayEquals("set/get NextGen failed", ng, ga.getNextGen());
		ng = null;
	}
	
	@Test
	// Test getter and setter for number of generations
	public void testResearchGAGetSetNumberOfGen() {
		ga.setNumberOfGenerations(3);
		assertEquals("set/get NumberOfGenerations failed", 3, ga.getNumberOfGenerations());
	}
	
	@Test
	// Test getter and setter for number of genes per individual
	public void testResearchGAGetSetNumGenesPerInd() {
		ga.setNumGenesPerIndividual(4);
		assertEquals("set/get NumberOfGenerations failed", 4, ga.getNumberGenesPerIndividual());
	}
	
	@Test
	// Test getter and setter for population
	public void testResearchGAGetSetPopulation() {
		String[][][] pop = new String[3][3][3];
		ga.setPopulation(pop);
		assertArrayEquals("set/get Population failed", pop, ga.getPopulation());
		pop = null;
	}
	
	@Test
	// Test getter and setter for population size
	public void testResearchGAGetSetPopulationSize() {
		ga.setPopulationSize(100);
		assertEquals("set/get PopulationSize failed", 100, ga.getPopulationSize());	
	}
	
}
