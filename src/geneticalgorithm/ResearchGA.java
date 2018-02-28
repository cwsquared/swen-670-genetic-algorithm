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

  private ArrayList population;

  private int POP_SIZE;

  private int NUM_GENES_PER_INDIVIDUAL;

  private Double MUTATION_RATE;

  private int METHYLATION_COUNT;

  private Random rnd;

  private int NUM_OF_GENERATIONS;

  private FitnessFunction currentFunction;

  private String filePath;

    public FitnessFunction myFitnessFunction;

  public ResearchGA() {
  }

  public ResearchGA(int popSize, int numGenerations, int numGenes, Double mutation, int methCount, String filePath) {
  }

  private void initialization(int numVariables) {
  }

  private void performSelection() {
  }

  private void performCrossover() {
  }

  private void performMutation() {
  }

  private void determineMethylation() {
  }

  private void clearMethylation() {
  }

  private Double convertGenesToNumber(String genes) {
  return null;
  }

  private void outputToFile(String filepath) {
  }

  public ArrayList getPopulation() {
  return null;
  }

  public int getPopulationSize() {
  return 0;
  }

  public int getNumberGenesPerIndividual() {
  return 0;
  }

  public Double getMutationRate() {
  return null;
  }

  public int getMethylationCount() {
  return 0;
  }

  public int getNumberOfGenerations() {
  return 0;
  }

  public FitnessFunction getCurrentFunction() {
  return null;
  }

  public String getFilePath() {
	  return filePath;
  }

  public void setPopulation(ArrayList population) {
  }

  public void setPopulationSize(int popSize) {
  }

  public void setNumGenesPerIndividual(int numGenes) {
  }

  public void setMutationRate(Double rate) {
  }

  public void setMethylationCount(int mc) {
  }

  public void setNumberOfGenerations(int generations) {
  }

  public void setCurrentFunction(FitnessFunction function) {
  }

  public void setFilePath(String filepath) {
  }

}