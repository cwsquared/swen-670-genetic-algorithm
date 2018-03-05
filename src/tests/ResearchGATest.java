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
	// Test all getters and setters for private attributes
	public void testResearchGAGettersSetters() {
		FitnessFunction f = new FitnessFunction();
		ga.setCurrentFunction(f);
		assertEquals("set/get CurrentFunction failed", f, ga.getCurrentFunction());
		
		ga.setMethylationCount(12);
		assertEquals("set/get MethylationCount failed", 12, ga.getMethylationCount());
		
		ga.setMutationRate(0.123);
		assertEquals("set/get MutationRate failed", 0.123, ga.getMutationRate(), 1);
		
		String[][][] ng = new String[2][2][2];
		ga.setNextGen(ng);
		assertArrayEquals("set/get NextGen failed", ng, ga.getNextGen());
		ng = null;
		
		ga.setNumberOfGenerations(3);
		assertEquals("set/get NumberOfGenerations failed", 3, ga.getNumberGenesPerIndividual());
		
		ga.setNumGenesPerIndividual(2);
		assertEquals("set/get NumGenesPerIndividual failed", 2, ga.getNumberGenesPerIndividual());
		
		String[][][] pop = new String[3][3][3];
		ga.setPopulation(pop);
		assertArrayEquals("set/get Population failed", pop, ga.getPopulation());
		pop = null;
		
		ga.setPopulationSize(100);
		assertEquals("set/get PopulationSize failed", 100, ga.getPopulationSize());
	}
	
}
