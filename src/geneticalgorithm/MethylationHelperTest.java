package geneticalgorithm;

import static org.junit.Assert.*;

import org.junit.Test;

public class MethylationHelperTest {
	
	@Test
	// Test the constructor that sets private attributes
	public void testMethylationHelper() {
		MethylationHelper mh = new MethylationHelper(1,2.0);
		assertEquals(mh.getIndividualIndex(),1);
		assertEquals(mh.getIndividualFitness(),2.0,1E-10);
	}

	@Test
	public void testGetIndividualFitness() {
		MethylationHelper mh = new MethylationHelper(0,2.5);
		assertEquals(mh.getIndividualFitness(),2.5,1E-10);
	}

	@Test
	public void testSetIndividualFitness() {
		MethylationHelper mh = new MethylationHelper(0,2.5);
		mh.setIndividualFitness(5.3);
		assertEquals(mh.getIndividualFitness(),5.3,1E-10);
	}

	@Test
	public void testGetIndividualIndex() {
		MethylationHelper mh = new MethylationHelper(3,2.5);
		assertEquals(mh.getIndividualIndex(),3);
	}

	@Test
	public void testSetIndividualIndex() {
		MethylationHelper mh = new MethylationHelper(5,2.5);
		mh.setIndividualIndex(10);
		assertEquals(mh.getIndividualIndex(),10);
	}

}
