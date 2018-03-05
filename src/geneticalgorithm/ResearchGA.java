package geneticalgorithm;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/** 
 *  Class Name: ResearchGA
 *  Class Description: The ResearchGA class contains the main attributes and methods of the genetic algorithm.
 *  Class Modifiers: Public
 *  Class Inheritance: None
 *  Class Attributes:
 *       private String[][][] population - an array of the individuals in a generation.  Array size is dictated by POP_SIZE attribute.
 *       private String[][][] nextGen - an array containing the next generation of the population.  It is the same size as population.
 *       private int POP_SIZE - number of individuals in a generation
 *       private int NUM_GENES_PER_INDIVIDUAL - number of characters in the string describing the individuals genes
 *       private Double MUTATION_RATE - the percent of genes that may be altered at random
 *       private int METHYLATION_COUNT - the number of least fit individuals who will be affected by methylation
 *       private Random rnd - random number generator
 *       private int NUM_OF_GENERATIONS - the number of generations (iterations) that the algorithm will go through
 *       private FitnessFunction currentFunction - holds the currently used fitness function object that the individuals will be judged against
 *       private String filePath - full path to the file the output will be written to
 *  
 *  Class Methods:
 *       public ResearchGA() - default constructor
 *       public ResearchGA(int popSize, int numGenerations, int numGenes, Double mutation, int methCount, String filePath) - constructor, which sets attributes
 *       private String[][][] initialization(int numVariables) - generates random set of bits for genes and all 0's for methylation
 *       private int[][] performSelection(String[][][] currGen) - determine which individuals from the current generation will be mated for the next generation
 *       private String[][][] performCrossover(String[][][] nextGen, int[][] pairs) - combine genes from the selected pairs to produce a pair of new individuals
 *       private String[][][] performMutation(String[][][] nextGen) - randomly change a MUTATION_RATE percentage of genes in an individual
 *       private String[][][] determineMethylation(String[][][] nextGen) - Locates the MC least fit individuals, randomly select 1 (one) gene, and test whether the gene being flipped makes for a more fit individual.  If the bit flip increases fitness, the corresponding methylation bit is set to 1.
 *       private String[][][] clearMethylation(String[][][] nextGen) - sets all methylation bits back to 0
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
 *       public String[][][] getNextGen()
 *       public void setNextGen(String[][][] gen)
 */
public class ResearchGA {

	// An array of the individuals in a generation.  Array size is dictated by POP_SIZE attribute.
	private String[][][] population;
	// An array containing the next generation of the population.  It is the same size as population.
	private String[][][] nextGen;
	// Number of individuals in a generation
	private int POP_SIZE;
	// Number of characters in the string describing the individuals genes
	private int NUM_GENES_PER_INDIVIDUAL;
	// The percent of genes that may be altered at random
	private Double MUTATION_RATE;
	// The number of least fit individuals who will be affected by methylation
	private int METHYLATION_COUNT;
	// Random number generator 
	private Random rnd;
	// The number of generations (iterations) that the algorithm will go through
	private int NUM_OF_GENERATIONS;
	// Holds the currently used fitness function object that the individuals will be judged against
	private FitnessFunction currentFunction;
	// Full path to the file the output will be written to
	private String filePath;
	public FitnessFunction myFitnessFunction;

	/**
	 * 
	 * @param args	the command line arguments
	 * 			[0] = fitness function
	 */
	public static void main(String[] args) {

		// TODO Get rid of default constructor. The args should pass in the
		//		values for the class attributes and set them immediately. 
		ResearchGA ga = new ResearchGA();
		
		// First argument represents the fitness function to run the GA against
		switch (args[0]) {
		case "1":
			ga.currentFunction = new FitnessFunc1();
			break;
		case "2":
			ga.currentFunction = new FitnessFunc2();
			break;
		case "3":
			ga.currentFunction = new FitnessFunc3();
			break;
		case "4":
			ga.currentFunction = new FitnessFunc4();
			break;
		case "5":
			ga.currentFunction = new FitnessFunc5();
			break;
		default: 
			ga.currentFunction = new FitnessFunc1();
			break;
		}
		
		// Intialize random number generator based on date
		ga.rnd = new Random();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("ssMMmmyydd");
		long d = Long.parseLong(sdf.format(cal.getTime()));
		ga.rnd.setSeed(d);

		// Initialize the population
		ga.population = ga.initialization(ga.currentFunction.getVariableCount());
		ga.outputToFile(ga.population);
		int[][] pairs;
		for (int gen = 1; gen <= ga.NUM_OF_GENERATIONS; gen++) {
			//CW: Just added the method calls in the order the overview doc calls for them
			ga.nextGen = ga.determineMethylation(ga.population);
			pairs = ga.performSelection(ga.nextGen);
			ga.nextGen = ga.performCrossover(ga.nextGen, pairs);
			ga.nextGen = ga.performMutation(ga.nextGen);
			ga.outputToFile(ga.nextGen);
			ga.nextGen = ga.clearMethylation(ga.nextGen);
			ga.population = ga.nextGen;
		}
	}

	/**
	 * Default constructor
	 */
	public ResearchGA() {
		// TODO do we even need this? Default constructors are only really necessary if we have default values,
		//	but it seems to me like we'll always require the user to enter in the values.
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
	 * @return new population
	 */
	private String[][][] initialization(int numVariables) {
	    String[][][] newPopulation = new String[POP_SIZE][numVariables][2];

	    Random rand = new Random();
	    String news;
	    String meth;

	    //Iterates through the individuals (runs POP_SIZE times)
	    for (int a = 0; a < POP_SIZE; a++) {
	        //Iterates though the variables (1 time for #1-4 and 2 times for #5)
	        for (int b = 0; b < numVariables; b++) {
	            news = new String();
	            meth = new String();
	            //Builds the new strings for genes (news) and methylation (meth) by iterating "number of genes per individual" times
	            for (int c = 0; c < NUM_GENES_PER_INDIVIDUAL; c++) {
	                if (rand.nextInt(2) == 0)
	                    news = news.concat("0");    // tacks a 0 on to the end of the string
	                else
	                    news = news.concat("1");    // tacks a 0 on to the end of the string
	                meth = meth.concat("0");        // builds the all 0 string for methylation
	            }
	            newPopulation[a][b][0] = news;      //saves the gene string into the current array element
	            System.out.println("News " + news);
	            newPopulation[a][b][1] = meth;      //saves the methylation string into the current array element
	            System.out.println("Meth " + meth);
	        }
	    }
	    return newPopulation;
	}

	/**
	 * Determine which individuals from the current generation will be mated for the next generation
	 * @param currGen
	 * @return
	 */
	private int[][] performSelection(String[][][] currGen) {
		int[][] selectPairs = new int[currGen.length/2][2]; //creates a 

		//TODO

		return selectPairs;
	}

	/**
	 * Combine genes from the selected pairs to produce a pair of new individuals
	 * @param nextGen
	 * @param pairs
	 * @return
	 */
	private String[][][] performCrossover(String[][][] nextGen,int[][] pairs) {
		String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];

		//TODO

		return ng;
	}

	/**
	 * Randomly change a MUTATION_RATE percentage of genes in an individual
	 * @param nextGen
	 * @return
	 */
	private String[][][] performMutation(String[][][] nextGen) {
		String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];

		//TODO

		return ng;	  
	}

	/**
	 * Locates the MC least fit individuals, randomly select 1 (one) gene, and test whether 
	 * the gene being flipped makes for a more fit individual.  If the bit flip increases fitness, 
	 * the corresponding methylation bit is set to 1.
	 * @param nextGen
	 * @return
	 */
	private String[][][] determineMethylation(String[][][] nextGen) {
		String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];

		//TODO

		return ng;
	}

	/**
	 * Sets all methylation bits back to 0
	 * @param nextGen
	 * @return
	 */
	private String[][][] clearMethylation(String[][][] nextGen) {
		String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];

		//TODO

		return ng;
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
	 * @param currPop	array representing the current population
	 */
	private void outputToFile(String[][][] currPop) {

	}

	/**
	 * Get the population
	 * @return an array representing the population
	 */
	public String[][][] getPopulation() {
		return population;
	}

	/**
	 * Get the population size
	 * @return the population size
	 */
	public int getPopulationSize() {
		return POP_SIZE;
	}

	/**
	 * Get the number of genes per individual
	 * @return the number of genes per individual
	 */
	public int getNumberGenesPerIndividual() {
		return NUM_GENES_PER_INDIVIDUAL;
	}

	/**
	 * Get the mutation rate
	 * @return the mutation rate
	 */
	public Double getMutationRate() {
		return MUTATION_RATE;
	}

	/**
	 * Get the methylation count
	 * @return methylation count
	 */
	public int getMethylationCount() {
		return METHYLATION_COUNT;
	}

	/**
	 * Get the number of generations.
	 * @return the number of generations
	 */
	public int getNumberOfGenerations() {
		return NUM_OF_GENERATIONS;
	}

	/**
	 * Get the current fitness function
	 * @return the current fitness function
	 */
	public FitnessFunction getCurrentFunction() {
		return currentFunction;
	}

	/**
	 * Get the output filepath
	 * @return the output file path
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * Get the next generation
	 * @return next generation
	 */
	public String[][][] getNextGen() {
		return nextGen;
	}

	/**
	 * Set population
	 * @param population	an array representing the population
	 */
	public void setPopulation(String[][][] population) {
		this.population = population;
	}

	/**
	 * Set population size
	 * @param popSize	population size
	 */
	public void setPopulationSize(int popSize) {
		this.POP_SIZE = popSize;
	}

	/**
	 * Set number of genes per individual
	 * @param numGenes	the number of genes
	 */
	public void setNumGenesPerIndividual(int numGenes) {
		this.NUM_GENES_PER_INDIVIDUAL = numGenes;
	}

	/**
	 * Set the mutation rate
	 * @param rate the mutation rate
	 */
	public void setMutationRate(Double rate) {
		this.MUTATION_RATE = rate;
	}

	/**
	 * Set methylation count
	 * @param mc	the methylation count
	 */
	public void setMethylationCount(int mc) {
		this.METHYLATION_COUNT = mc;
	}

	/**
	 * Set the number of generations
	 * @param generations	the number of generations
	 */
	public void setNumberOfGenerations(int generations) {
		this.NUM_OF_GENERATIONS = generations;
	}

	/**
	 * Set current fitness function
	 * @param function	the fitness function that is currently being evaluated.
	 */
	public void setCurrentFunction(FitnessFunction function) {
		this.currentFunction = function;
	}

	/**
	 * Set output filepath
	 * @param filepath	the filepath of the output file
	 */
	public void setFilePath(String filepath) {
		this.filePath = filepath;
	}

	/**
	 * Set the next generation
	 * @param gen	an array representing the next generation
	 */
	public void setNextGen(String[][][] gen) {
		this.nextGen = gen;
	}

}