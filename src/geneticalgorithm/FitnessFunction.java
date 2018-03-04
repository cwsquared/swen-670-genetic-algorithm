package geneticalgorithm;

/** 
 *  Class Name: FitnessFunction
 *  Class Description: The FitnessFuntion class contains the generic attributes and methods of one of the fitness functions individual's genes will be tested against.
 *  Class Modifiers: Public
 *  Class Inheritance: None
 *  Class Attributes:
 *       protected int VARIABLE_COUNT
 *       protected int LOWER_BOUND
 *       protected int UPPER_BOUND
 *  
 *  Class Methods:
 *       public FitnessFunction() - default constructor
 *       public FitnessFunction(int vc, int lb, int ub) - constructor that accepts parameters to be assigned to attributes.
 *       public Double getFitness(String genes) - fitness function to be overloaded by inheriting classes.  Returns 0.0
 *       public int getVariableCount()
 *       public void setVariableCount(int vc)
 *       public int getLowerBound()
 *       public void setLowerBound(int lb)
 *       public int getUpperBound()
 *       public void setUpperBound()
 *       public Double convertGenesToNumber(String genes) - converts the gene string to a number
 */
public class FitnessFunction {

	protected int VARIABLE_COUNT = 1;
	protected int LOWER_BOUND = 0;
	protected int UPPER_BOUND = 1;
	public ResearchGA myResearchGA;
	
	/**
	 * Default constructor
	 */
	public FitnessFunction() {
		
	}
	
	/**
	 * Constructor to set attributes
	 */
	public FitnessFunction(int vc, int lb, int ub) {
		this.VARIABLE_COUNT = vc;
		this.LOWER_BOUND = lb;
		this.UPPER_BOUND = ub;
	}
	
	/**
	 * Fitness function to be overloaded by inheriting classes.  Returns 0.0
	 * @param genes 
	 * @return 
	 */
	public Double getFitness(String genes) {
		return null;
	}
	
	/**
	 * Converts the string of genes to a number of type Double.
	 * @param genes
	 * @param numGenes
	 * @return the genes as a number
	 */
	public Double convertGenesToNumber(String genes) {
		double num = 0.0;
		int numGenes = genes.length();
        for (int i = 0; i < numGenes; i++)
        {
           if (genes.charAt(i) == '1')
             num = num + StrictMath.pow(2, i);
        }
        num = LOWER_BOUND + (num/(StrictMath.pow(2, numGenes) - 1)) * (UPPER_BOUND - LOWER_BOUND);
		return num;
	}
	/**
	 * Get the variable count for the fitness function.
	 * @return the variable count
	 */
	public int getVariableCount() {
		return VARIABLE_COUNT;
	}

	/**
	 * Set the number of variables for the fitness function
	 * @param variables the number of variables
	 */
	public void setVariableCount(int variables) {
		this.VARIABLE_COUNT = variables;
	}

	/**
	 * Get the lower bound
	 * @return the lower bound
	 */
	public int getLowerBound() {
		return LOWER_BOUND;
	}

	/**
	 * Set the lower bound
	 * @param lb	the lower bound
	 */
	public void setLowerBound(int lb) {
		this.LOWER_BOUND = lb;
	}

	/**
	 * Get the upper bound
	 * @return the upper bound
	 */
	public int getUpperBound() {
		return UPPER_BOUND;
	}

	/**
	 * Set the upper bound
	 * @param ub	the upper bound
	 */
	public void setUpperBound(int ub) {
		this.UPPER_BOUND = ub;
	}

}