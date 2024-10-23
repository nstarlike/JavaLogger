package com.javalogger.context;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class LogContextTest {
	private static LogContext context;
	
	@BeforeAll
	static void setup() {
		context = new LogContext(LogContextTest.class);
	}

	@Test
	void testPrint() {
		String msg = "test";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		context.print(msg);
		
		assertTrue(out.toString().endsWith(LogContextTest.class.getName() + " : " + msg));
	}

	@Test
	void testPrintln() {
		String msg = "test";
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		
		context.println(msg);
		
		assertTrue(out.toString().endsWith(LogContextTest.class.getName() + " : " + msg + "\r\n"));
	}

}
