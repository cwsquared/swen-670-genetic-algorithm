package geneticalgorithm;

public class FitnessTracking {

	private int individualIndex;
	private double individualFitness;
	
	/**
	 * Constructor, assigns parameters to object attributes
	 * @param index	an integer, index of the individual in the population
	 * @param fitness	a double, the fitness of the indexed individual against the benchmark function
	 */
	public FitnessTracking(int index, double fitness) {
		this.individualIndex = index;
		this.individualFitness = fitness;
	}
	
	/**
	 * Returns the fitness of the individual
	 * @return individualFitness
	 */
	public double getIndividualFitness() {
		return individualFitness;
	}
	
	/**
	 * Assigns the parameter to the object's individualFitness attribute
	 * @param fitness	a double, the fitness of the indexed individual against the benchmark function
	 */
	public void setIndividualFitness(double fitness) {
		this.individualFitness = fitness;
	}
	
	/**
	 * Returns the index of the individual in the population
	 * @return individualIndex
	 */
	public int getIndividualIndex() {
		return individualIndex;
	}
	
	/**
	 * Assigns the parameter to the object's individualFitness attribute
	 * @param index	an integer, index of the individual in the population
	 */
	public void setIndividualIndex(int index) {
		this.individualIndex = index;
	}


}
