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
	public void shouldRepresentOneMinuteUnits() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "0000\n" + "00000000000\n" + "YY00";
		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("00:02:00"));
	}

	@Test
	public void shouldRepresentFiveMinuteUnits() {
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
	public void shouldRepresentOneHourUnits() {
		String expectedBerlinClockTime = "Y\n" + "0000\n" + "R000\n" + "00000000000\n" + "0000";

		assertEquals(expectedBerlinClockTime, berlinClock.convertTime("01:00:00"));
	}

	@Test
	public void shouldRepresentFiveHourUnits() {
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
	public void shouldThowExceptionWhenInvalidHourEntered() {
		berlinClock.convertTime("24:00:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhenInvalidMinutesEntered() {
		berlinClock.convertTime("00:77:00");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhenInvalidSecondsEntered() {
		berlinClock.convertTime("00:00:76");
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThowExceptionWhenInvalidFormatEntered() {
		berlinClock.convertTime("24.00:00");
	}

}
