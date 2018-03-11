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
 *  
 *  Class Methods:
 *       public ResearchGA() - default constructor
 *       public ResearchGA(int popSize, int numGenerations, int numGenes, Double mutation, int methCount) - constructor, which sets attributes
 *       private String[][][] initialization(int numVariables) - generates random set of bits for genes and all 0's for methylation
 *       private int[][] performSelection(String[][][] currGen) - determine which individuals from the current generation will be mated for the next generation
 *       private String[][][] performCrossover(String[][][] nextGen, int[][] pairs) - combine genes from the selected pairs to produce a pair of new individuals
 *       private String[][][] performMutation(String[][][] nextGen) - randomly change a MUTATION_RATE percentage of genes in an individual
 *       private String[][][] determineMethylation(String[][][] nextGen) - Locates the MC least fit individuals, randomly select 1 (one) gene, and test whether the gene being flipped makes for a more fit individual.  If the bit flip increases fitness, the corresponding methylation bit is set to 1.
 *       private String[][][] clearMethylation(String[][][] nextGen) - sets all methylation bits back to 0
 *       private Double convertGenesToNumber(String genes) - converts the string of 1's and 0's to a Double number value
 *       private void printGeneration() - outputs the current individual's genes, domain values, and fitness
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
	public FitnessFunction myFitnessFunction;

	/**
	 * Main program
	 * @param args	the command line arguments
	 * 			[0] = fitness function
	 * 			[1] = POP_SIZE
	 * 			[2] = NUM_OF_GENERATIONS
	 * 			[3] = NUM_GENES_PER_INDIVIDUAL
	 * 			[4] = MUTATION_RATE 
	 * 			[5] = METHYLATION_COUNT
	 */
	public static void main(String[] args) {

		boolean validated = false;

		// Validate arguments before proceeding
		if(args.length == 6) {
			boolean arg0Valid = false;
			boolean numberArgsValid = false;
			boolean popSizeIsEven = false;

			// Check that the first argument is 1,2,3,4,5 (i.e. valid fitness function)
			if(args[0].equals("1") || args[0].equals("2") || args[0].equals("3") || args[0].equals("4") || args[0].equals("5")) {
				arg0Valid = true;
			}

			// Check that the remaining arguments are int or double
			try {
				Integer.parseInt(args[1]);
				
				// Check that population size is even
				if((Integer.parseInt(args[1]) & 1) == 0) {
					popSizeIsEven = true;
				}
				
				Integer.parseInt(args[2]);
				Integer.parseInt(args[3]);
				Double.parseDouble(args[4]);
				Integer.parseInt(args[5]);
				numberArgsValid = true;
			}  catch (Exception e) { numberArgsValid = false;}

			if(arg0Valid == true && numberArgsValid == true && popSizeIsEven == true) {
				validated = true;
			}

		}

		// If the arguments are valid, continue with program
		if(validated == true) {
			// Create genetic algorithm based on arguments
			ResearchGA ga = new ResearchGA(
					Integer.parseInt(args[1]),
					Integer.parseInt(args[2]),
					Integer.parseInt(args[3]),
					Double.parseDouble(args[4]),
					Integer.parseInt(args[5]));

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
			}

			// Initialize random number generator based on date
			ga.rnd = new Random();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("ssMMmmyydd");
			long d = Long.parseLong(sdf.format(cal.getTime()));
			ga.rnd.setSeed(d);

			// Initialize the population
			ga.population = ga.initialization(ga.currentFunction.getVariableCount());
			System.out.println("Initial generation");   //Header for the output
			ga.printGeneration(ga.population);
			int[][] pairs;
			for (int gen = 1; gen <= ga.NUM_OF_GENERATIONS; gen++) {
				ga.nextGen = ga.determineMethylation(ga.population);
				pairs = ga.performSelection(ga.nextGen);
				ga.nextGen = ga.performCrossover(ga.nextGen, pairs);
				ga.nextGen = ga.performMutation(ga.nextGen);
				System.out.println("\n Generation" + gen);
				ga.printGeneration(ga.nextGen);
				ga.nextGen = ga.clearMethylation(ga.nextGen);
				ga.population = ga.nextGen;
			}
		} else {
			System.out.println("Failed to run genetic algorithm due to invalid arguments.");
		}
	}

	/**
	 * Constructor to set attributes
	 * @param popSize 			the population size
	 * @param numGenerations	the number of generations
	 * @param numGenes			the number of genes
	 * @param mutation			the mutation rate
	 * @param methCount			the methylation count
	 */
	public ResearchGA(int popSize, int numGenerations, int numGenes, Double mutation, int methCount) {
		this.POP_SIZE = popSize;
		this.NUM_OF_GENERATIONS = numGenerations;
		this.NUM_GENES_PER_INDIVIDUAL = numGenes;
		this.MUTATION_RATE = mutation;
		this.METHYLATION_COUNT = methCount;
	}

	/**
	 * Generates random set of bits for genes and all 0's for methylation
	 * @param numVariables	the number of variables to intialize with
	 * @return new population
	 */
	public String[][][] initialization(int numVariables) {
	    String[][][] newPopulation = new String[POP_SIZE][numVariables][2];

	    Random rand = new Random();
	    String genes;
	    String meth;
	    
	    //Iterates through the individuals (runs POP_SIZE times)
	    for (int ind = 0; ind < POP_SIZE; ind++) {
	        //Iterates though the variables (1 time for #1-4 and 2 times for #5)
	        for (int vb = 0; vb < numVariables; vb++) {
	            genes = new String();
	            meth = new String();
	            //Builds the new strings for genes (news) and methylation (meth) by iterating "number of genes per individual" times
	            for (int i = 0; i < NUM_GENES_PER_INDIVIDUAL; i++) {
	            	genes +=String.valueOf(rand.nextInt(2));
	                meth += "0";
	            }
	            newPopulation[ind][vb][0] = genes;      //saves the gene string into the current array element for index [a][b]
	            newPopulation[ind][vb][1] = meth;      //saves the methylation string into the current array element for index [a][b]
	        }
	    }
	    return newPopulation;
	}

	/**
	 * Determine which individuals from the current generation will be mated for the next generation
	 * @param currGen
	 * @return
	 */
	public int[][] performSelection(String[][][] currGen) {
		int[][] selectPairs = new int[currGen.length/2][2]; 
				
		for(int x = 0; x < currGen.length / 2; x++){
				
			//Variable to hold the overall fitness
			double sumFitness = 0.0;
			double selectionValue = 0.0;
			
			//Loop to determine the sum of the overall fitness
			for(int ind = 0; ind < currGen.length; ind++){ 
				for(int vb = 0; vb < currGen[ind].length; vb++){
					sumFitness = sumFitness + currentFunction.getFitness(expressGenetics(currGen[ind][vb][0],currGen[ind][vb][1]));
				}
			}
//			System.out.print("Sum of fitness for this generation is " + sumFitness + "\n");
			
			//Loop to Select the individuals from the array
			for(int b = 0; b < currGen[x].length; b++){
				
				//**First individual
				selectionValue = rnd.nextDouble() * sumFitness;
//				System.out.print("Selection value (Before) is " + selectionValue + "\n");				
				int selectionIndex = -1;
				while(selectionValue >= 0.0){
					selectionIndex = selectionIndex + 1;
					selectionValue = selectionValue - currentFunction.getFitness(expressGenetics(currGen[selectionIndex][b][0],currGen[selectionIndex][b][1]));
				}		
				selectPairs[x][0] = selectionIndex; 
//				System.out.print("Selection value (After) is " + selectionValue + "\n");
//				System.out.println("First Index: " + selectionIndex);
		    
		        //**Second Individual
		        selectionValue = rnd.nextDouble() * sumFitness;
//		        System.out.print("Selection value (Before) is " + selectionValue + "\n");
		        selectionIndex = -1;
		        while (selectionValue >= 0.0)
		        {
		            selectionIndex = selectionIndex + 1;
		            selectionValue = selectionValue - currentFunction.getFitness(expressGenetics(currGen[selectionIndex][b][0],currGen[selectionIndex][b][1]));
		        }  
//		        System.out.print("Selection value (After) is " + selectionValue + "\n");
		        selectPairs[x][1] = selectionIndex; 	
//		        System.out.println("Second Index: " + selectionIndex);
			}        		
//			System.out.println("");
		}
		 	    
		return selectPairs;
	}
	
			
	/**
	 * Combine genes from the selected pairs to produce a pair of new individuals
	 * @param nextGen
	 * @param pairs
	 * @return
	 */
	public String[][][] performCrossover(String[][][] nextGen,int[][] pairs) {
		String[][][] ng = new String[nextGen.length][nextGen[0].length][nextGen[0][0].length];

		String[] selectedIndividual1 = new String[2];
		String[] selectedIndividual2 = new String[2];
		String[] newIndividual1 = new String[2];
		String[] newIndividual2 = new String[2];
		
		for(int a = 0; a < nextGen.length / 2; a++){ 
			for(int b = 0; b < nextGen[a].length; b++){
				selectedIndividual1[0] = nextGen[pairs[a][0]][b][0];	//genes
				selectedIndividual1[1] = nextGen[pairs[a][0]][b][1];	//methylation
				selectedIndividual2[0] = nextGen[pairs[a][1]][b][0];	//genes
				selectedIndividual2[1] = nextGen[pairs[a][1]][b][1];	//methylation
//				System.out.println("Pairs: " + selectedIndividual1 + "|" + selectedIndividual2);
				
				//** Crossover Implementation
				int crossoverPoint = rnd.nextInt(getNumberGenesPerIndividual() - 1);   
//				System.out.print("Crossover point " + crossoverPoint + "\n");
				
				
				//First Individual
				newIndividual1[0] = selectedIndividual1[0].substring(0, crossoverPoint).concat(
						selectedIndividual2[0].substring(crossoverPoint, nextGen[0][0].length));	//genes
				newIndividual1[1] = selectedIndividual1[1].substring(0, crossoverPoint).concat(
						selectedIndividual2[1].substring(crossoverPoint, nextGen[0][0].length));	//methylation
		        
				//Second Individual
		        newIndividual2[0] = selectedIndividual2[0].substring(0, crossoverPoint).concat(
		                selectedIndividual1[0].substring(crossoverPoint, nextGen[0][0].length));	//genes
		        newIndividual2[1] = selectedIndividual2[1].substring(0, crossoverPoint).concat(
		                selectedIndividual1[1].substring(crossoverPoint, nextGen[0][0].length));	//methylation
		        
//		        System.out.println("First Individual: " + newIndividual1 + " |  Second Individual: " + newIndividual2 + "\n");
		        
		        //Add new individuals to generation
		        ng[a*2][b][0] = newIndividual1[0];		//genes
		        ng[a*2][b][1] = newIndividual1[1];		//methylation
		        ng[a*2+1][b][0] = newIndividual2[0];	//genes
		        ng[a*2+1][b][1] = newIndividual2[1];	//methylation
			}
		}	
		return ng;
	}

	/**
	 * Randomly change a MUTATION_RATE percentage of genes in an individual
	 * @param nextGen
	 * @return
	 */
	public String[][][] performMutation(String[][][] nextGen, boolean...showMsg) { ///---modified the argument to allow for additional parameter. I use this for debuging
		
		boolean ShowMessage = showMsg.length > 0 ? showMsg[0] : false;
		boolean mutated =false;		//--detect if mutation took place
		String[][][] ng = nextGen;	//--a copy of the current generation of genes that needs to be mutated
		
		String normalIndividual = new String();		///---used to store current individual string that we will examine and mutate
		Double myrnd; ///---random number, did this so we can see the actual random number being used to detect mutation!

		try {

	        for (int individual = 0; individual < nextGen.length; individual++)
	        {
	        	for (int number_of_variables = 0; number_of_variables < nextGen[individual].length; number_of_variables++) 
	        	{
	        		mutated = false;
	        		normalIndividual = nextGen[individual][number_of_variables][0];
	        		
	        		if (ShowMessage)  ///---show debugging output 
	        			System.out.println("\tAnalyzing gene <<<[ "+normalIndividual + " ]>>>");
	
	                for (int c = 0; c < NUM_GENES_PER_INDIVIDUAL;c++) // normalIndividual.length(); c++)
	                {
	                	if (rnd==null) {  ///---We need to initialize this if not trying to test the GA function the main thread will throw an exception on
	                		rnd = new Random();
	                	}
	                	myrnd = rnd.nextDouble();
	                  
	                	if (myrnd < MUTATION_RATE) {
	                		mutated = true;
	                		
	                		if (ShowMessage) ///---show debugging output 
	                			System.out.println("\tGeneration(["+(individual+1)+"]["+(number_of_variables+1)+"]["+(c+1)+"]) Will mutate! --> Random #("+MUTATION_RATE+") is: "+ String.format("%1.2f", myrnd));                   
	
	                    	if (normalIndividual.substring(c, c + 1).equals("1")) {
	                			normalIndividual = normalIndividual.substring(0,c)+'0'+normalIndividual.substring(c+1);
	                		}else{
	                			normalIndividual = normalIndividual.substring(0,c)+'1'+normalIndividual.substring(c+1);
	                		}
	                	}                  
	                }
	                
	                ng[individual][number_of_variables][0] = normalIndividual;
	                		
	                if (ShowMessage) ///---show debugging output 
	        			System.out.println("\t-->> "+normalIndividual + " <<--  " + (mutated ? "MUTATED!!!" : "")); System.out.println();   		
	        	}
	        	
	        }
		} catch (Exception ex) {
			if (ShowMessage)
				System.out.println("Error occured with array : "+ex.getMessage());
		}
        
		return ng;
		
	}

	/**
	 * Locates the MC least fit individuals, randomly select 1 (one) gene, and test whether 
	 * the gene being flipped makes for a more fit individual.  If the bit flip increases fitness, 
	 * the corresponding methylation bit is set to 1.
	 * @param nextGen
	 * @return
	 */
	public String[][][] determineMethylation(String[][][] nextGen) {
		String[][][] ng = nextGen;

		//TODO

		return ng;
	}

	/**
	 * Sets all methylation bits back to 0
	 * @param nextGen
	 * @return
	 */
	public String[][][] clearMethylation(String[][][] nextGen) {
		String[][][] ng = nextGen;

		for (int ind = 0; ind < ng.length; ind++) {
			for (int vb = 0; vb < ng[ind].length; vb++) {
				String newMeth = new String();
				for (int i = 0; i < ng[ind][vb].length; i++) {
					newMeth = newMeth.concat("0");
				}
				
				ng[ind][vb][1] = newMeth;
			}
		}

		return ng;
	}

	/**
	 * Converts the string of 1's and 0's to a Double number value
	 * @param genes	a string representing genes
	 * @return a number representing the genes
	 */
	public String expressGenetics(String genes, String meth) {
		String eg = new String();
		
		for (int i = 0; i < genes.length(); i++) {
			if (meth.substring(i, i + 1).equals("1")) {		//Flip the current gene char
				if (genes.substring(i, i + 1).equals("1"))
					eg = eg.concat("0");
				else
					eg = eg.concat("1");
			} 
			else
			{
				eg = eg.concat(genes.substring(i, i + 1));
			}
		}	
		return eg;
	}

	/**
	 * Prints the current individual's genes, domain values, and fitness
	 * @param currPop	array representing the current population
	 */
	private void printGeneration(String[][][] currPop) {
		for (int ind = 0; ind < currPop.length; ind++) {
			String individual = "";
			
			for (int vb = 0; vb < currPop[ind].length; vb++) {
				individual = individual.concat(expressGenetics(currPop[ind][vb][0],currPop[ind][vb][1]) + ",");
			}
			
			for (int vb = 0; vb < currPop[ind].length; vb++) {
				individual = individual.concat(currentFunction.convertGenesToNumber(expressGenetics(currPop[ind][vb][0],currPop[ind][vb][1])) + ",");
			} 
			individual = individual.concat(currentFunction.getFitness(expressGenetics(currPop[ind][0][0],currPop[ind][0][1])).toString());
		
			System.out.println(individual);
		}
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
	 * Set the next generation
	 * @param gen	an array representing the next generation
	 */
	public void setNextGen(String[][][] gen) {
		this.nextGen = gen;
	}

}