package geneticalgorithm;

import java.util.Random;
import java.util.ArrayList;

/** 
 *  Class Name: ResearchGA
 *  Class Description: The ResearchGA class contains the main attributes and methods of the genetic algorithm.
 *  Class Modifiers: Public
 *  Class Inheritance: None
 *  Class Attributes:
 *       private ArrayList population - an array of the individuals in a generation.  Array size is dictated by POP_SIZE attribute.
 *       private int POP_SIZE - number of individuals in a generation
 *       private int NUM_GENES_PER_INDIVIDUAL - number of characters in the string describing the individuals genes
 *       private Double MUTATION_RATE - the percent of genes that may be altered at random
 *       private int METHYLATION_COUNT - the number of least fit individuals who will be affected by methylation
 *       private Random rnd - 
 *       private int NUM_OF_GENERATIONS - the number of generations (iterations) that the algorithm will go through
 *       private FitnessFunction currentFunction - holds the currently used fitness function object that the individuals will be judged against
 *       private String filePath - full path to the file the output will be written to
 *  
 *  Class Methods:
 *       public ResearchGA() - default constructor
 *       public ResearchGA(int popSize, int numGenerations, int numGenes, Double mutation, int methCount, String filePath) - constructor, which sets attributes
 *       private void initialization(int numVariables) - generates random set of bits for genes and all 0's for methylation
 *       private void performSelection() - determine which individuals from the current generation will be mated for the next generation
 *       private void performCrossover() - combine genes from the selected pairs to produce a pair of new individuals
 *       private void performMutation() - randomly change a MUTATION_RATE percentage of genes in an individual
 *       private void determineMethylation() - Locates the MC least fit individuals, randomly select 1 (one) gene, and test whether the gene being flipped makes for a more fit individual.  If the bit flip increases fitness, the corresponding methylation bit is set to 1.
 *       private void clearMethylation() - sets all methylation bits back to 0
 *       private Double convertGenesToNumber(String genes) - converts the string of 1's and 0's to a Double number value
 *       private void outputToFile(String filepath) - writes the current individual's genes, domain values, and fitness to the file specified in the filePath
 *       public ArrayList getPopulation()
 *       public setPopulation(ArrayList population)
 *       public int getPopulationSize()
 *       public setPopulationSize(int PopSize)
 *       public int getNumberGenesPerIndividual()
 *       public void setNumGenesPerIndividual(int numGenes)
 *       public Double getMutationRate()
 *       public void setMutationRate(Double rate)
 *       public int getMethylationCount()
 *       public void setMethylationCount(int mc)
 *       public int getNumberOfGenerations()
 *       public FitnessFunction getCurrentFunction()
 *       public void setCurrentFunction(FitnessFunction function)
 *       public String getFilePath()
 *       public void setFilePath(String filepath)
 */
public class ResearchGA {

	// An array of the individuals in a generation.  Array size is dictated by POP_SIZE attribute.
	private ArrayList population;

	//Number of individuals in a generation
	private int POP_SIZE;

	//Number of characters in the string describing the individuals genes
	private int NUM_GENES_PER_INDIVIDUAL;


	//The percent of genes that may be altered at random
	private Double MUTATION_RATE;

	//The number of least fit individuals who will be affected by methylation

	private int METHYLATION_COUNT;

	private Random rnd;

	//The number of generations (iterations) that the algorithm will go through
	private int NUM_OF_GENERATIONS;

	// Holds the currently used fitness function object that the individuals will be judged against
	private FitnessFunction currentFunction;

	// Full path to the file the output will be written to
	private String filePath;

	public FitnessFunction myFitnessFunction;

	/**
	 * Default constructor
	 */
	public ResearchGA() {

	}

	/**
	 * Constructor to set attributes
	 * @param popSize 			the population size
	 * @param numGenerations	the number of generations
	 * @param numGenes			the number of genes
	 * @param mutation			the mutation rate
	 * @param methCount			the methylation count
	 * @param filePath			the output filepath
	 */
	public ResearchGA(int popSize, int numGenerations, int numGenes, Double mutation, int methCount, String filePath) {
		this.POP_SIZE = popSize;
		this.NUM_OF_GENERATIONS = numGenerations;
		this.NUM_GENES_PER_INDIVIDUAL = numGenes;
		this.MUTATION_RATE = mutation;
		this.METHYLATION_COUNT = methCount;
		this.filePath = filePath;
	}

	/**
	 * Generates random set of bits for genes and all 0's for methylation
	 * @param numVariables	the number of variables to intialize with
	 */
	private void initialization(int numVariables) {

	}

	/**
	 * Determine which individuals from the current generation will be mated for the next generation
	 */
	private void performSelection() {

	}

	/**
	 * Combine genes from the selected pairs to produce a pair of new individuals
	 */
	private void performCrossover() {

	}

	/**
	 * Randomly change a MUTATION_RATE percentage of genes in an individual
	 */
	private void performMutation() {

	}

	/**
	 * Locates the MC least fit individuals, randomly select 1 (one) gene, and test whether 
	 * the gene being flipped makes for a more fit individual.  If the bit flip increases fitness, 
	 * the corresponding methylation bit is set to 1.
	 */
	private void determineMethylation() {
	}

	/**
	 * Sets all methylation bits back to 0
	 */
	private void clearMethylation() {

	}

	/**
	 * Converts the string of 1's and 0's to a Double number value
	 * @param genes	a string representing genes
	 * @return a number representing the genes
	 */
	private Double convertGenesToNumber(String genes) {
		return null;
	}

	/**
	 * Writes the current individual's genes, domain values, and fitness to the file specified in the filePath
	 * @param filepath	the output filepath
	 */
	private void outputToFile(String filepath) {
		
	}

	/**
	 * Get the population
	 * @return an array representing the population
	 */
	public ArrayList getPopulation() {
		return null;
	}

	/**
	 * Get the population size
	 * @return the population size
	 */
	public int getPopulationSize() {
		return 0;
	}

	/**
	 * Get the number of genes per individual
	 * @return the number of genes per individual
	 */
	public int getNumberGenesPerIndividual() {
		return 0;
	}

	/**
	 * Get the mutation rate
	 * @return the mutation rate
	 */
	public Double getMutationRate() {
		return null;
	}

	/**
	 * Get the methylation count
	 * @return methylation count
	 */
	public int getMethylationCount() {
		return 0;
	}

	/**
	 * Get the number of generations.
	 * @return the number of generations
	 */
	public int getNumberOfGenerations() {
		return 0;
	}

	/**
	 * Get the current fitness function
	 * @return the current fitness function
	 */
	public FitnessFunction getCurrentFunction() {
		return null;
	}

	/**
	 * Get the output filepath
	 * @return the output file path
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Set population
	 * @param population	an array representing the population
	 */
	public void setPopulation(ArrayList population) {

	}

	/**
	 * Set population size
	 * @param popSize	population size
	 */
	public void setPopulationSize(int popSize) {

	}

	/**
	 * Set number of genes per individual
	 * @param numGenes	the number of genes
	 */
	public void setNumGenesPerIndividual(int numGenes) {

	}

	/**
	 * Set the mutation rate
	 * @param rate the mutation rate
	 */
	public void setMutationRate(Double rate) {

	}

	/**
	 * Set methylation count
	 * @param mc	the methylation count
	 */
	public void setMethylationCount(int mc) {

	}

	/**
	 * Set the number of generations
	 * @param generations	the number of generations
	 */
	public void setNumberOfGenerations(int generations) {

	}

	/**
	 * Set current fitness function
	 * @param function	the fitness function that is currently being evaluated.
	 */
	public void setCurrentFunction(FitnessFunction function) {

	}

	/**
	 * Set output filepath
	 * @param filepath	the filepath of the output file
	 */
	public void setFilePath(String filepath) {

	}

}