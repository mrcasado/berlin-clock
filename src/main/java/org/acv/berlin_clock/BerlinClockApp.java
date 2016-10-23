package org.acv.berlin_clock;

import java.util.Scanner;

public class BerlinClockApp {

	public static void main(String[] args) {		
//    Scanner scanner = new Scanner(System.in);
//    String twentyFourHoursTime = scanner.nextLine();	
	BerlinClock berlinClock = new BerlinClock();
	System.out.println(berlinClock.convertTime(args[0]));
	}

}
