package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import geneticalgorithm.ResearchGA;

public class ResearchGATest {

	@Test
	// Test the constructor that sets privates attributes
	public void testResearchGAConstructor() {
		ResearchGA ga = new ResearchGA(1, 2, 3, 4.4, 5, "filepath");
		assertEquals("filepath was not set correctly", ga.getFilePath(), "filepath");
	}

}
