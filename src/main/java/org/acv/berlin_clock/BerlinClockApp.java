package org.acv.berlin_clock;

public class BerlinClockApp {

	public static void main(String[] args) {
		BerlinClock berlinClock = new BerlinClock();
		System.out.println(berlinClock.convertTime(args[0]));
	}

}
