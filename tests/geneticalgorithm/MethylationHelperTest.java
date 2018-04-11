package geneticalgorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class MethylationHelperTest {
	
	@Test
	// Test the constructor that sets private attributes
	public void testMethylationHelper() {
		FitnessTracking mh = new FitnessTracking(1,2.0);
		assertEquals(mh.getIndividualIndex(),1);
		assertEquals(mh.getIndividualFitness(),2.0,1E-10);
	}

	@Test
	public void testGetIndividualFitness() {
		FitnessTracking mh = new FitnessTracking(0,2.5);
		assertEquals(mh.getIndividualFitness(),2.5,1E-10);
	}

	@Test
	public void testSetIndividualFitness() {
		FitnessTracking mh = new FitnessTracking(0,2.5);
		mh.setIndividualFitness(5.3);
		assertEquals(mh.getIndividualFitness(),5.3,1E-10);
	}

	@Test
	public void testGetIndividualIndex() {
		FitnessTracking mh = new FitnessTracking(3,2.5);
		assertEquals(mh.getIndividualIndex(),3);
	}

	@Test
	public void testSetIndividualIndex() {
		FitnessTracking mh = new FitnessTracking(5,2.5);
		mh.setIndividualIndex(10);
		assertEquals(mh.getIndividualIndex(),10);
	}

}
