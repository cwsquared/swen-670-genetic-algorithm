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
	// Test the initialization function population size
	public void testInitializationPopulationSize() {
		// Setup values of population array
		String[][][] pop = ga.initialization(1);
		// Set value of population size by checking length of population array
		int individuals = pop.length;
		// check that initialization passes back an array of correct size based on population size
		assertEquals("Initialization created population of correct size", 1, individuals);
	}
	
	@Test
	// Test the initialization function second dimension size
	public void testInitalizationArraySecondDimensionSizeOne() {
		String[][][] pop = ga.initialization(1);
		int individuals = pop[0].length;
		assertEquals("Initialization created array second dimension of correct size", 1, individuals);
	}
	
	@Test
	// Test the initialization function second dimension size
	public void testInitalizationArraySecondDimensionSizeTwo() {
		String[][][] pop = ga.initialization(2);
		int individuals = pop[0].length;
		assertEquals("Initialization created array second dimension of correct size", 2, individuals);
	}
	
	@Test
	// Test the initialization function methylation string
	public void testInitializationMethylationString() {
		String[][][] pop = ga.initialization(1);
		String individuals = pop[0][0][1];
		assertEquals("Initialization created methylation string with expected contents", "000", individuals);	
	}
	
	@Test
	// Test the initialization function individual gene string length
	public void testInitializationIndividualGeneStringSize() {
		String[][][] pop = ga.initialization(1);
		int individuals = pop[0][0][0].length();
		assertEquals("Initialization created methylation string with expected contents", 3, individuals);	
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
	
	@Test
	// Test the selected function selected pairs size
	public void testResearchGASelectionPairsSize(){		
		//Create the Array to hold the individuals
		String[][][] population = ga.initialization(1);
		int populationLength = ga.getPopulationSize();
		
		//Perform Selection on this population and save the pairs
		int[][] pairs = ga.performSelection(population);
		int pairsLength = pairs.length;
		
		//Check that the selection returns an array of size (Total Population)/2
		assertEquals("Selected Pair size is half of the population size", populationLength/2, pairsLength);		
	}
	
	@Test
	// Test the crossover function next generation size
	public void testResearchGANextGenSize(){		
		//Create the Array to hold the current generation individuals
		String[][][] population = ga.initialization(1);
		int populationLength = ga.getPopulationSize();
		
		//Perform Selection on this population and save the pairs
		int[][] pairs = ga.performSelection(population);
		
		//Create Array to hold the next generation individuals
		//NOTE: Parameter values were derived from the constructor (i.e. pop size = 1, numVariables = 1)
		String[][][] nextGen = new String[1][1][2];
		
		//Perform crossover on the population		
		nextGen =  ga.performCrossover(population, pairs);
		int nextGenLength = nextGen.length;
		
		//Check that the function returns a new generation with correct size after crossing the genes
		assertEquals("The new generation size is twice the Selected pair size", populationLength, nextGenLength);		
	}
	
	@Test
	//Test that the Gene Expression method returns correct string of expressed genes with zeroed methylation
	public void testexpressGeneticsZeroMethylation() {
		String eg1 = ga.expressGenetics("10101010","00000000");
		assertEquals(eg1, "10101010");
	}
	
	@Test
	//Test that the Gene Expression method returns correct string of expressed genes with some methylation
	public void testexpressGeneticsSomeMethylation() {
		String eg2 = ga.expressGenetics("10101010","10101010");
		assertEquals(eg2,"00000000");
	}
	
	@Test
	//Test that the Gene Expression method returns correct string of expressed genes with methylation of all 1's
	public void testexpressGeneticsFullMethylation() {
		String eg3 = ga.expressGenetics("10101010","11111111");
		assertEquals(eg3,"01010101");
	}
	
	
	@Test
	public void testMutation() {
		String[][][] p = new String[1][1][2];
		String[][][] ret;
		
		p[0][0][0] = "00000";
		p[0][0][1] = "00000";
		
		ga.setPopulation(p);
		ga.setNumGenesPerIndividual(5);
		ga.setMutationRate(100.0);
		
		ret = ga.performMutation(ga.getPopulation());
		//System.out.println("===? "+ret[0][0][0]);

		assertEquals("Error occured trying to test gene '11111", "11111", ret[0][0][0]);		
	
	}
	
	@Test
	//Test that the methylation string is set back to all zeroes by the clearMethylation() method
	public void testClearMethylation() {
		String[][][] pop = new String[3][1][2];
		pop[0][0][0] = "10101010";
		pop[0][0][1] = "10101010";
		pop[1][0][0] = "01010101";
		pop[1][0][1] = "10001000";
		pop[2][0][0] = "11110000";
		pop[2][0][1] = "00001000";
		ga.clearMethylation(pop);
		assertEquals(pop[0][0][1], "00000000");
		assertEquals(pop[1][0][1], "00000000");
		assertEquals(pop[2][0][1], "00000000");
	}
}
