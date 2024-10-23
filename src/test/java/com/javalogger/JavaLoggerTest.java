package com.javalogger;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class JavaLoggerTest {
	private static JavaLogger logger;
	
	@BeforeAll
	static void setup() {
		logger = new JavaLogger(JavaLoggerTest.class);
	}
	
	@Test
	void testPrint() {
		String msg = "test";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		logger.print(msg);
		
		assertTrue(out.toString().endsWith(JavaLoggerTest.class.getName() + " : " + msg));
	}

	@Test
	void testPrintln() {
		String msg = "test";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		logger.println(msg);
		
		assertTrue(out.toString().endsWith(JavaLoggerTest.class.getName() + " : " + msg + "\r\n"));
	}

}
