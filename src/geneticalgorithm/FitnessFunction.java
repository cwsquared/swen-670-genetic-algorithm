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
 *       public Double getFitness(String genes) - fitness function to be overloaded by inheriting classes.  Returns null.
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
	 * Constructor that accepts parameters to be assigned to attributes.
	 * @param vc	an integer, variable count of the function.
	 * @param lb	an integer, lower bound of the domain range.
	 * @param ub	an integer, upper bound of the domain range.
	 */
	public FitnessFunction(int vc, int lb, int ub) {
		this.VARIABLE_COUNT = vc;
		this.LOWER_BOUND = lb;
		this.UPPER_BOUND = ub;
	}
	
	/**
	 * Converts the string of 1's and 0's to a Double number value
	 * @param genes	a string representing genes
	 * @param meth	a string representing methylation
	 * @return a string representing the genes as influenced by the methylation
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
	 * Determines an individuals genetic fitness
	 * @param individual	2-dimensional String array that represents all genetic/epigenetic information for the individual
	 * @return returns null
	 */
	public Double getFitness(String[][] individual) {
		return null;
	}
	
	/**
	 * Converts the string of genes to a number of type Double.
	 * @param genes	a string that represents the genetic information
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