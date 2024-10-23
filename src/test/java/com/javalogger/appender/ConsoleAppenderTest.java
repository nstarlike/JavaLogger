package com.javalogger.appender;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class ConsoleAppenderTest {
	private static ConsoleAppender appender;
	
	@BeforeAll
	static void setup() {
		appender = new ConsoleAppender();
	}
	
	@Test
	void testPrint() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		String msg = "test";
		appender.print(msg);
		
		assertEquals(out.toString(), msg);
	}

	@Test
	void testPrintln() {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		String msg = "test";
		appender.println(msg);
		
		assertEquals(out.toString(), msg + "\r\n");
	}

}
