package com.simpleprogrammer.proteintracker.tests;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;

import static org.junit.Assert.*;

import com.simpleprogrammer.TrackingService;

@RunWith(Theories.class)
public class TrackingServiceTheories {

	@DataPoints
	public static int[] data() {
		int[] data = { 1, 5, 10, 15, 20, 50, -4 };
		return data;
	}
	// public static int[] data = { 1, 5, 10, 15, 20, 50, -4 };

	@Theory
	public void PositiveValuesShouldAlwaysHavePositiveTotals(Integer value) {
		TrackingService service = new TrackingService();
		service.addProtein(value);
		//Assume.assumeTrue(value > 0);

		assertTrue(service.getTotal() > 0);
	}

	@DataPoints
	// public static String[] GOOD_USERNAME = { "optimus", "sad" };
	public static String[] generatedDataPoints() {
		return new String[] { "optimus", "sad" };
	}

	@Theory
	public void filenameIncludesUsername(String username) {
		// assumeThat(username, not(containsString("/")));
		assertThat(username, containsString(username));
	}
}
