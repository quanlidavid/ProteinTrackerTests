package com.simpleprogrammer.proteintracker.tests;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.simpleprogrammer.InvalidGoalException;
import com.simpleprogrammer.TrackingService;

public class TrackingServiceTests {

	private TrackingService service;

	@BeforeClass
	public static void before() {
		System.out.println("Before Class");
	}

	@AfterClass
	public static void after() {
		System.out.println("After Class");
	}

	@Before
	public void setup() {
		System.out.println("Before");
		service = new TrackingService();
	}

	@After
	public void tearDown() {
		System.out.println("After");
	}

	@Category(GoodTestsCategory.class)
	@Test
	public void NewTrackingServiceTotalIsZero() {
		assertEquals("Tracking service total was not zero", 0,
				service.getTotal());
	}

	@Ignore
	@Test
	public void WhenAddingProteinTotalIncreasesByThatAmount() {
		service.addProtein(10);
		assertEquals("Protein amount was not correct", 10, service.getTotal());
	}

	@Category(GoodTestsCategory.class)
	@Test
	public void WhenRemoveingProteinTotalRemainsZero() {
		service.removeProtein(5);
		assertEquals(0, service.getTotal());
		assertThat("Remove 5 is not 0.", service.getTotal(), is(0));

		assertThat(service.getTotal(), allOf(is(0), isA(Integer.class)));
	}

	@Category(NegativeTestsCategory.class)
	@Test(expected = InvalidGoalException.class)
	public void WhenGoalIsSetToLessThanZeroExceptionIsThrow()
			throws InvalidGoalException {
		service.setGoal(-2);
	}

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Category(NegativeTestsCategory.class)
	@Test
	public void WhenGoalIsSetToLessThanZeroExceptionWithCorrectMessageIsThrow()
			throws InvalidGoalException {
		thrown.expect(InvalidGoalException.class);
		thrown.expectMessage(containsString("Goal was less than zero1!"));
		service.setGoal(-2);
	}

	
	@Category(NegativeTestsCategory.class)
	@Test(timeout = 200)
	public void BadTest() {
		for (int i = 0; i < 100000000; i++) {
			service.addProtein(1);
			//System.out.println(System.currentTimeMillis());
		}
	}
	
	
	@Rule
	public Timeout timeout = new Timeout(200);

	@Category(NegativeTestsCategory.class)
	@Test
	public void TimeoutRuleTest() {
		for (int i = 0; i < 100000000; i++) {
			service.addProtein(1);
			//System.out.println(System.currentTimeMillis());
		}
	}

}
