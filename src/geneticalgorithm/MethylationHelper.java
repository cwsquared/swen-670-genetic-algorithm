package geneticalgorithm;

import java.util.Comparator;

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
	public void setIndividualFitness(double individualFitness) {
		this.individualFitness = individualFitness;
	}
	public int getIndividualIndex() {
		return individualIndex;
	}
	public void setIndividualIndex(int individualIndex) {
		this.individualIndex = individualIndex;
	}

	public static Comparator<MethylationHelper> indFit = new Comparator<MethylationHelper>() {

		public double compare(MethylationHelper mh1, MethylationHelper mh2) {

			double indFit1 = mh1.getIndividualFitness();
			double indFit2 = mh2.getIndividualFitness();

			// ascending
			return indFit1-indFit2;

			// descending
			//return indFit2-indFito1;
		}
		
	};

}
