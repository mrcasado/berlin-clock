package org.acv.berlin_clock;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BerlinClockTest {

	private BerlinClock berlinClock;

	@Before
	public void before() {
		berlinClock = new BerlinClock();
	}

	@Test
	public void shouldRepresentOneMinuteLights() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "0000\n" + "00000000000\n" + "YY00";
		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("00:02:00"));
	}

	@Test
	public void shouldRepresentFiveMinuteLights() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "0000\n" + "YY000000000\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("00:10:00"));
	}

	@Test
	public void shouldRepresentFifteenMinutes() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "0000\n" + "YYR00000000\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("00:15:00"));
	}

	@Test
	public void shouldRepresentThirtyMinutes() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "0000\n" + "YYRYYR00000\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("00:30:00"));
	}

	@Test
	public void shouldRepresentFortyFiveMinutes() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "0000\n" + "YYRYYRYYR00\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("00:45:00"));
	}

	@Test
	public void shouldRepresentOneHourLights() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "R000\n" + "00000000000\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("01:00:00"));
	}

	@Test
	public void shouldRepresentFiveHourLights() {
		String expectedBerlinClockTime = "Y\n" + "R000\n" + "0000\n" + "00000000000\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("05:00:00"));
	}

	@Test
	public void shouldRepresentEvenNumberedSeconds() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "0000\n" + "00000000000\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("00:00:00"));
	}

	@Test
	public void shouldRepresentOddNumberedSeconds() {
		String expectedBerlinClockTime = "0\n" + "0000\n" + "0000\n" + "00000000000\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("00:00:01"));
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhenHoursGreaterThan23() {
		berlinClock.convertTime("24:00:00");	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhenHoursLessThan0IsEntered() {
		berlinClock.convertTime("-2:00:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhendMinutesGreaterThan59() {
		berlinClock.convertTime("00:77:00");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhendMinutesIsLessThan0() {
		berlinClock.convertTime("00:-1:00");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhenSecondsGreaterThan59() {
		berlinClock.convertTime("00:00:76");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhenSecondsLessThan0() {
		berlinClock.convertTime("00:00:-01");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhenInvalidFormatEntered() {
		berlinClock.convertTime("24.00:00");
	}

}
