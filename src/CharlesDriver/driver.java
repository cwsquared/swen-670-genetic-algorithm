package CharlesDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

import geneticalgorithm.FitnessFunc1;
import geneticalgorithm.FitnessFunc2;
import geneticalgorithm.FitnessFunc3;
import geneticalgorithm.FitnessFunc4;
import geneticalgorithm.FitnessFunc5;
import geneticalgorithm.ResearchGA;

public class driver {

	public static void main(String[] argsX) {

//		ResearchGA ga = new ResearchGA(1, 2, 1, 0.2, 2 );
		Random rnd;
		String args[]= {"1", "2", "1","5", "0.2", "2"};
		
		driver mytesting = new driver();
		
		ResearchGA ga = new ResearchGA(
				Integer.parseInt(args[1]),
				Integer.parseInt(args[2]),
				Integer.parseInt(args[3]),
				Double.parseDouble(args[4]),
				Integer.parseInt(args[5]));

		
		// First argument represents the fitness function to run the GA against
		switch (args[0]) {
		case "1":
			ga.setCurrentFunction(new FitnessFunc1());
			break;
		case "2":
			ga.setCurrentFunction(new FitnessFunc2());
			break;
		case "3":
			ga.setCurrentFunction(new FitnessFunc3());
			break;
		case "4":
			ga.setCurrentFunction(new FitnessFunc4());
			break;
		case "5":
			ga.setCurrentFunction(new FitnessFunc5());
			break;
		}

		// Initialize the population
//		ga.population = ga.initialization(ga.currentFunction.getVariableCount());
		ga.setPopulation( ga.initialization(ga.getCurrentFunction().getVariableCount()));
		
//		ga.printGeneration(ga.population);
//		ga.printGeneration(ga.getPopulation());  //--remmed out for now...not visible
		
		int[][] pairs;
//		for (int gen = 1; gen <= ga.NUM_OF_GENERATIONS; gen++) {
		for (int gen = 1; gen <= ga.getNumberOfGenerations(); gen++) {
			//CW: Just added the method calls in the order the overview doc calls for them

			//ga.nextGen = ga.determineMethylation(ga.population);  	///---oc = original code
//			ga.nextGen = ga.determineMethylation(ga.getPopulation()); 	///---remmed out because method is private/protected
			//pairs = ga.performSelection(ga.nextGen); 					///---oc
//			pairs = ga.performSelection(ga.getNextGen());				///---remmed out because method is private/protected
			//ga.nextGen = ga.performCrossover(ga.nextGen, pairs);		///---oc
//			ga.nextGen = ga.performCrossover(ga.getNextGen(), pairs);	///---remmed out because method is private/protected
			//ga.nextGen = ga.performMutation(ga.nextGen);				///---oc

///---my modifications for testing
mytesting.myprint(" BEFORE ",ga.getPopulation());

			//ga.nextGen = ga.performMutation(ga.population);
			ga.setNextGen( ga.performMutation(ga.getPopulation() , true));

mytesting.myprint(" AFTER ",ga.getNextGen());

			//ga.printGeneration(ga.nextGen);
			//ga.nextGen = ga.clearMethylation(ga.nextGen);  //--oc
			//ga.population = ga.nextGen; //--oc
		}		

	}
	
	
	public void myprint(String Title, String[][][] nextGen) {
		
		String normalIndividual = new String();

    	System.out.println("====================="+ String.format("%s", Title)+"==========================");

    	try {
	    	for (int x = 0; x < nextGen.length; x++)
	        {
	        	for (int y = 0; y < nextGen[x].length; y++) 
	        	{        		
	        		normalIndividual = nextGen[x][y][0];
	        		System.out.println("Normal Individual:     " + normalIndividual);
	         		//System.out.println();
	        	}
	        }
    	}catch(Exception ex) {
    		System.out.println("Error occured with array : "+ex.getMessage());
    	}
    	
  
    	System.out.println("========================================================");		
	}
	
	
}
