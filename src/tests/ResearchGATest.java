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
	
}
