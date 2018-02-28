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
package geneticalgorithm;

public class FitnessFunc3 extends FitnessFunction {

  public FitnessFunc3() {
  }

  public Double getFitness(Double genes) {
  return null;
  }

  public FitnessFunc3(int vc, int lb, int ub) {
  }

}