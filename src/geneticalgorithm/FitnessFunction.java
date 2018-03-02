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
package geneticalgorithm;

public class FitnessFunction {

  protected int VARIABLE_COUNT;
  protected int LOWER_BOUND;
  protected int UPPER_BOUND;
  public ResearchGA myResearchGA;

  public int getVariableCount() {
	  return VARIABLE_COUNT;
  }

  public Double getFitness(String genes) {
	  return null;
  }

  public FitnessFunction() {
  }

  public void setVariableCount(int variables) {
	  this.VARIABLE_COUNT = variables;
  }

  public int getLowerBound() {
	  return LOWER_BOUND;
  }

  public void setLowerBound(int lb) {
	  this.LOWER_BOUND = lb;
  }

  public int getUpperBound() {
	  return UPPER_BOUND;
  }

  public void setUpperBound(int ub) {
	  this.UPPER_BOUND = ub;
  }

}