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

	   /*Comparator for sorting the list by roll no*/
    public static Comparator<MethylationHelper> StuRollno = new Comparator<MethylationHelper>() {

	public double compare(MethylationHelper mh1, MethylationHelper mh2) {

	   double rollno1 = mh1.getIndividualFitness();
	   double rollno2 = mh2.getIndividualFitness();

	   /*For ascending order*/
	   return rollno1-rollno2;

	   /*For descending order*/
	   //rollno2-rollno1;
   }};
}
