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
package geneticalgorithm;

public class FitnessFunc2 extends FitnessFunction {

  public FitnessFunc2() {
	  this.VARIABLE_COUNT = 1;
	  this.LOWER_BOUND = 0;
	  this.UPPER_BOUND = 1;
  }

  public Double getFitness(Double genes) {
	  return null;
  }

  public FitnessFunc2(int vc, int lb, int ub) {
	  this.VARIABLE_COUNT = vc;
	  this.LOWER_BOUND = lb;
	  this.UPPER_BOUND = ub;
  }

}