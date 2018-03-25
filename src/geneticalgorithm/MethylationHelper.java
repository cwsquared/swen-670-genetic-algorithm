package geneticalgorithm;

public class MethylationHelper implements Comparable {

	private int individualIndex;
	private double individualFitness;
	
	public MethylationHelper(int index, double fitness) {
		this.individualIndex = index;
		this.individualFitness = fitness;
	}
	
	public double getIndividualFitness() {
		return individualFitness;
	}
	public void setIndividualFitness(double individualFitness) {
		this.individualFitness = individualFitness;
	}
	public int getIndividualIndex() {
		return individualIndex;
	}
	public void setIndividualIndex(int individualIndex) {
		this.individualIndex = individualIndex;
	}

	@Override
	public double compareTo(MethylationHelper comparestu) {
       double compareFitness=((MethylationHelper)comparestu).getIndividualFitness();
       // Ascending Order
       return this.individualFitness-compareFitness;
	}
	
}
