package org.acv.berlin_clock;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BerlinClockAppTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	  
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
	
	@Test
	public void testOut() {
		String expectedBerlinClockTime = "0\n" + "0000\n" + "0000\n" + "00000000000\n" + "0000\n";
		BerlinClockApp.main(new String[] {"00:00:01"});
	    assertEquals(expectedBerlinClockTime, outContent.toString());
	}	
}

