package geneticalgorithm;

/** 
 *  Class Name: FitnessFunc3
 *  Class Description: The FitnessFuntion class contains the inherited attributes and methods from FitnessFuncion, with an overloaded getFitness() method.
 *  Class Modifiers: Public
 *  Class Inheritance: FitnessFunction
 *  Class Attributes:
 *       protected int VARIABLE_COUNT = 1
 *       protected int LOWER_BOUND = 0
 *       protected int UPPER_BOUND = 1
 *  
 *  Class Methods:
 *       public FitnessFunc3() - default constructor
 *       public FitnessFunc3(int vc, int lb, int ub) - constructor that accepts parameters to be assigned to attributes.
 *       public Double getFitness(String genes) - returns a Double value of the equation: f(x)=sin^6(10*pi*x^2), where x = genes
 *       public int getVariableCount()
 *       public void setVariableCount(int vc)
 *       public int getLowerBound()
 *       public void setLowerBound(int lb)
 *       public int getUpperBound()
 *       public void setUpperBound()
 */
public class FitnessFunc3 extends FitnessFunction {

	/**
	 * Default constructor
	 */
	public FitnessFunc3() {
		super();
	}

	/**
	 * Constructor that accepts parameters to be assigned to attributes.
	 * @param vc	an integer, variable count of the function.
	 * @param lb	an integer, lower bound of the domain range.
	 * @param ub	an integer, upper bound of the domain range.
	 */
	public FitnessFunc3(int vc, int lb, int ub) {
		super(vc, lb, ub);
	}

	/**
	 * Determines an individuals genetic fitness
	 * @param individual	2-dimensional String array that represents all genetic/epigenetic information for the individual
	 * @return a Double value of the equation: f(x)=sin^6(10*pi*x^3), where x = the expressed genetics of individual
	 */
	public Double getFitness(String[][] individual) {
		String genetics = expressGenetics(individual[0][0],individual[0][1]);
		Double x = convertGenesToNumber(genetics);
		Double pi = StrictMath.PI;
		return StrictMath.pow(StrictMath.sin(10 * pi * StrictMath.pow(x,3)), 6.0);
	}
}