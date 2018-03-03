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
 *       public String[][][] getNextGen90
 *       public void setNextGen(String[][][] gen)
 */
public class ResearchGA {

  private String[][][] population;
  private String[][][] nextGen;
  private int POP_SIZE;
  private int NUM_GENES_PER_INDIVIDUAL;
  private Double MUTATION_RATE;
  private int METHYLATION_COUNT;
  private Random rnd;
  private int NUM_OF_GENERATIONS;
  private FitnessFunction currentFunction;
  private String filePath;
  public FitnessFunction myFitnessFunction;

  public static void main(String[] args) {
	  
	  ResearchGA ga = new ResearchGA();
	  
	  switch (args[0]) {
		  case "1":
			  ga.currentFunction = new FitnessFunc1();
		  case "2":
			  ga.currentFunction = new FitnessFunc2();
		  case "3":
			  ga.currentFunction = new FitnessFunc3();
		  case "4":
			  ga.currentFunction = new FitnessFunc4();
		  case "5":
			  ga.currentFunction = new FitnessFunc5();	
	  }
	  ga.rnd = new Random();
	  Calendar cal = Calendar.getInstance();
      SimpleDateFormat sdf = new SimpleDateFormat("ssMMmmyydd");
      long d = Long.parseLong(sdf.format(cal.getTime()));
      ga.rnd.setSeed(d);
	  
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
  
  public ResearchGA() {
  }

  public ResearchGA(int popSize, int numGenerations, int numGenes, Double mutation, int methCount, String filePath) {
	  this.POP_SIZE = popSize;
	  this.NUM_OF_GENERATIONS = numGenerations;
	  this.NUM_GENES_PER_INDIVIDUAL = numGenes;
	  this.MUTATION_RATE = mutation;
	  this.METHYLATION_COUNT = methCount;
	  this.filePath = filePath;
  }

  private String[][][] initialization(int numVariables) {
	  String[][][] newPopulation = new String[POP_SIZE][numVariables][2];
	  
	  return newPopulation;
  }

  private int[][] performSelection(String[][][] currGen) {
	  int[][] selectPairs = new int[currGen.length/2][2]; //creates a 
	  
	  return selectPairs;
  }

  private String[][][] performCrossover(String[][][] nextGen,int[][] pairs) {
	  String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];
	  
	  return ng;
  }

  private String[][][] performMutation(String[][][] nextGen) {
	  String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];
	  
	  return ng;	  
  }

  private String[][][] determineMethylation(String[][][] nextGen) {
	  String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];
	  
	  return ng;
  }

  private String[][][] clearMethylation(String[][][] nextGen) {
	  String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];
	  
	  return ng;
  }

  private Double convertGenesToNumber(String genes) {
	  return null;
  }

  private void outputToFile(String[][][] currPop) {
  }

  public String[][][] getPopulation() {
	  return population;
  }

  public int getPopulationSize() {
	  return POP_SIZE;
  }

  public int getNumberGenesPerIndividual() {
	  return NUM_GENES_PER_INDIVIDUAL;
  }

  public Double getMutationRate() {
	  return MUTATION_RATE;
  }

  public int getMethylationCount() {
	  return METHYLATION_COUNT;
  }

  public int getNumberOfGenerations() {
	  return NUM_OF_GENERATIONS;
  }

  public FitnessFunction getCurrentFunction() {
	  return currentFunction;
  }

  public String getFilePath() {
	  return filePath;
  }

  public void setPopulation(String[][][] population) {
	  this.population = population;
  }

  public void setPopulationSize(int popSize) {
	  this.POP_SIZE = popSize;
  }

  public void setNumGenesPerIndividual(int numGenes) {
	  this.NUM_GENES_PER_INDIVIDUAL = numGenes;
  }

  public void setMutationRate(Double rate) {
	  this.MUTATION_RATE = rate;
  }

  public void setMethylationCount(int mc) {
	  this.METHYLATION_COUNT = mc;
  }

  public void setNumberOfGenerations(int generations) {
	  this.NUM_OF_GENERATIONS = generations;
  }

  public void setCurrentFunction(FitnessFunction function) {
	  this.currentFunction = function;
  }

  public void setFilePath(String filepath) {
	  this.filePath = filepath;
  }
  
  public String[][][] getNextGen() {
	  return nextGen;
  }
  
  public void setNextGen(String[][][] gen) {
	  this.nextGen = gen;
  }

}