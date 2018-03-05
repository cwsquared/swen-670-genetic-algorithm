package tests;

import static org.hamcrest.CoreMatchers.instanceOf;
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
		assertEquals("Population generated properly", ga.getPopulation(), true);
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
