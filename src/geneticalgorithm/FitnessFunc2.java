package geneticalgorithm;

/** 
 *  Class Name: FitnessFunc2
 *  Class Description: The FitnessFuntion class contains the inherited attributes and methods from FitnessFuncion, with an overloaded getFitness() method.
 *  Class Modifiers: Public
 *  Class Inheritance: FitnessFunction
 *  Class Attributes:
 *       protected int VARIABLE_COUNT = 1
 *       protected int LOWER_BOUND = 0
 *       protected int UPPER_BOUND = 1
 *  
 *  Class Methods:
 *       public FitnessFunc2() - default constructor
 *       public FitnessFunc2(int vc, int lb, int ub) - constructor that accepts parameters to be assigned to attributes.
 *       public Double getFitness(String genes) - returns a Double value of the equation: f(x)=sin^6(5*pi*x^3), where x = genes
 *       public int getVariableCount()
 *       public void setVariableCount(int vc)
 *       public int getLowerBound()
 *       public void setLowerBound(int lb)
 *       public int getUpperBound()
 *       public void setUpperBound()
 */
public class FitnessFunc2 extends FitnessFunction {

	/**
	 * Default constructor
	 */
	public FitnessFunc2() {
		super();
	}

	/**
	 * Constructor that accepts parameters to be assigned to attributes.
	 * @param vc
	 * @param lb
	 * @param ub
	 */
	public FitnessFunc2(int vc, int lb, int ub) {
		super(vc, lb, ub);
	}

	/**
	 * 
	 * @param genes
	 * @return a Double value of the equation: f(x)=sin^6(5*pi*x^2), where x = genes
	 */
	public Double getFitness(String genes) {
		Double x = convertGenesToNumber(genes);
		Double pi = Math.PI;
		return Math.pow(Math.sin(5 * pi * Math.pow(x,2)), 6.0);	
	}

}