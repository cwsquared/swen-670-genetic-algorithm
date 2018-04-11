package geneticalgorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class FitnessTrackerTest {
	
	@Test
	// Test the constructor that sets private attributes
	public void testMethylationHelper() {
		FitnessTracking ft = new FitnessTracking(1,2.0);
		assertEquals(ft.getIndividualIndex(),1);
		assertEquals(ft.getIndividualFitness(),2.0,1E-10);
	}

	@Test
	public void testGetIndividualFitness() {
		FitnessTracking ft = new FitnessTracking(0,2.5);
		assertEquals(ft.getIndividualFitness(),2.5,1E-10);
	}

	@Test
	public void testSetIndividualFitness() {
		FitnessTracking ft = new FitnessTracking(0,2.5);
		ft.setIndividualFitness(5.3);
		assertEquals(ft.getIndividualFitness(),5.3,1E-10);
	}

	@Test
	public void testGetIndividualIndex() {
		FitnessTracking ft = new FitnessTracking(3,2.5);
		assertEquals(ft.getIndividualIndex(),3);
	}

	@Test
	public void testSetIndividualIndex() {
		FitnessTracking ft = new FitnessTracking(5,2.5);
		ft.setIndividualIndex(10);
		assertEquals(ft.getIndividualIndex(),10);
	}

}
