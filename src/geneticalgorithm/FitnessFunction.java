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
 */
public class FitnessFunction {

	protected int VARIABLE_COUNT;

	protected int LOWER_BOUND;

	protected int UPPER_BOUND;

	public ResearchGA myResearchGA;

	/**
	 * Get the variable count for the fitness function.
	 * @return the variable count
	 */
	public int getVariableCount() {
		return 0;
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
	 * Default constructor
	 */
	public FitnessFunction() {
	}

	/**
	 * Set the number of variables for the fitness function
	 * @param variables the number of variables
	 */
	public void setVariableCount(int variables) {

	}

	/**
	 * Get the lower bound
	 * @return the lower bound
	 */
	public int getLowerBound() {
		return 0;
	}

	public void setLowerBound(int lb) {

	}

	/**
	 * Get the upper bound
	 * @return the upper bound
	 */
	public int getUpperBound() {
		return 0;
	}

	/**
	 * Set the upper bound
	 * @param ub	the upper bound
	 */
	public void setUpperBound(int ub) {

	}

}