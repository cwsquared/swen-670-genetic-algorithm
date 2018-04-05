package geneticalgorithm;

public class MethylationHelper {

	private int individualIndex;
	private double individualFitness;
	
	public MethylationHelper(int index, double fitness) {
		this.individualIndex = index;
		this.individualFitness = fitness;
	}
	
	public double getIndividualFitness() {
		return individualFitness;
	}
	public void setIndividualFitness(double fitness) {
		this.individualFitness = fitness;
	}
	public int getIndividualIndex() {
		return individualIndex;
	}
	public void setIndividualIndex(int index) {
		this.individualIndex = index;
	}


}
