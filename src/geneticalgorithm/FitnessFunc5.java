package geneticalgorithm;

/** 
 *  Class Name: FitnessFunc5
 *  Class Description: The FitnessFuntion class contains the inherited attributes and methods from FitnessFuncion, with an overloaded getFitness() method.
 *  Class Modifiers: Public
 *  Class Inheritance: FitnessFunction
 *  Class Attributes:
 *       protected int VARIABLE_COUNT = 2
 *       protected int LOWER_BOUND = -3
 *       protected int UPPER_BOUND = 3
 *  
 *  Class Methods:
 *       public FitnessFunc5() - default constructor
 *       public FitnessFunc5(int vc, int lb, int ub) - constructor that accepts parameters to be assigned to attributes.
 *       public Double getFitness(String genes) - returns a Double value of the equation: f(x)=2x^2-1.05x^4+x^6/6-xy+y^2, where x = genes
 *       public int getVariableCount()
 *       public void setVariableCount(int vc)
 *       public int getLowerBound()
 *       public void setLowerBound(int lb)
 *       public int getUpperBound()
 *       public void setUpperBound()
 */
public class FitnessFunc5 extends FitnessFunction {

	/**
	 * Default constructor
	 */
	public FitnessFunc5() {

	}
	
	/**
	 * Constructor that accepts parameters to be assigned to attributes.
	 * @param vc
	 * @param lb
	 * @param ub
	 */
	public FitnessFunc5(int vc, int lb, int ub) {

	}

	/**
	 * 
	 * @param xGenes
	 * @param yGenes
	 * @return a Double value of the equation: f(x)=2x^2-1.05x^4+x^6/6-xy+y^2, where x = genes
	 */
	public Double getFitness(Double xGenes, Double yGenes) {
		return null;
	}
}