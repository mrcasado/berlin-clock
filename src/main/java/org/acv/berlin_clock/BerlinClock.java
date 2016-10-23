package org.acv.berlin_clock;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Berlin Clock.
 *
 * Provides the means to convert 24 hour clock time to Berlin clock time. 
 * Seconds are represented with Y(Yellow Light) for even numbered seconds and 0 for odd numbered seconds
 * Each five minutes light is represented with a Y(yellow light) if lit except for
 * lights representing 15,30 and 45 minutes which are R(Red). The ones unlit are represented with 0. 
 * Each one hour light is represented with an R(red light) if lit. The ones unlit are represented with 0. 
 * Each one minute light is represented with an Y(yellow light) if lit. The ones unlit are represented
 * with 0. 
 */

public class BerlinClock {

	/**
	 * Validates a 24 hour clock time string and converts it to Berlin clock
	 * time.
	 *
	 * @param twentyFourHoursTime String that represents 24 hour clock with format hh:mm:ss
	 *
	 * @return String representing Berlin Clock.
	 */

	public String convertTime(String twentyFourHoursTime) {
		String[] timeUnits = twentyFourHoursTime.split(":");
		if (timeUnits.length != 3)
			throw new IllegalArgumentException("Wrong format. Use hh:mm:ss");

		int hours = Integer.parseInt(timeUnits[0]);
		int minutes = Integer.parseInt(timeUnits[1]);
		int seconds = Integer.parseInt(timeUnits[2]);

		if (hours > 23 || hours < 0)
			throw new IllegalArgumentException("Wrong number of hours. Valid range: 0-23");

		if (minutes > 59 || minutes < 0)
			throw new IllegalArgumentException("Wrong number of minutes: Valid range 0-59");

		if (seconds > 59 || seconds < 0)
			throw new IllegalArgumentException("Wrong number of seconds. Valid range 0-59");

		return String.join("\n", this.secondsRowRepresentation(seconds), this.fiveHourUnitsRowRepresentation(hours),
				this.oneHourUnitsRowRepresentation(hours), this.fiveMinuteUnitsRowRepresentation(minutes),
				this.oneMinuteUnitsRowRepresentation(minutes));
	}

	/**
	 * Converts minutes to a a string representing a one minute lights row in a
	 * Berlin clock
	 *
	 * @param minutes int that represents the 24 clock minutes
	 *
	 * @return String representing single minutes in the Berlin clock
	 */
	private String oneMinuteUnitsRowRepresentation(int minutes) {
		return IntStream.rangeClosed(1, 4).mapToObj(i -> i <= minutes % 5 ? "Y" : "0").collect(Collectors.joining());
	}

	/**
	 * Converts minutes to a a string representing a five minute lights row in a
	 * Berlin clock
	 * 
	 * @param minutes int that represents the 24 clock minutes
	 *
	 * @return String representing single minutes in the Berlin clock
	 */
	private String fiveMinuteUnitsRowRepresentation(int minutes) {
		return IntStream.rangeClosed(1, 11).mapToObj(i -> i <= (minutes - minutes % 5) / 5 ? "Y" : "0")
				.collect(Collectors.joining()).replaceAll("YYY", "YYR");
	}

	/**
	 * Converts hours to a string representing a one hour lights row in a Berlin
	 * clock
	 *
	 * @param hours int that represents the 24 clock hours
	 *
	 * @return String representing a one hour lights row in a Berlin clock
	 */
	private String oneHourUnitsRowRepresentation(int hours) {
		return IntStream.rangeClosed(1, 4).mapToObj(i -> i <= hours % 5 ? "R" : "0").collect(Collectors.joining());

	}

	/**
	 * Converts hours to a string representing a five hour lights row in a
	 * Berlin clock. Each five hours light is represented with an R(red light)
	 * if lit. The ones unlit are represented with 0.
	 *
	 * @param hours int that represents the 24 clock hours
	 *
	 * @return String representing a five hour lights row in a Berlin clock
	 */
	private String fiveHourUnitsRowRepresentation(int hours) {
		return IntStream.rangeClosed(1, 4).mapToObj(i -> i <= (hours - hours % 5) / 5 ? "R" : "0")
				.collect(Collectors.joining());
	}

	/**
	 * Converts seconds to a string representing a seconds light in Berlin
	 * clock.
	 *
	 * @param seconds int that represents the 24 clock seconds
	 *
	 * @return String representing a seconds light in a Berlin clock
	 */
	private String secondsRowRepresentation(int seconds) {
		return seconds % 2 == 0 ? "Y" : "0";
	}

}
