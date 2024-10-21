/**
 * 
 */
package com.javalogger.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import com.javalogger.config.LogConfig;

class LogConfigTest {
	private static LogConfig config;
	private static String PROPERTY_NAME = "Test.properties";

	@BeforeAll
	static void setup() {
		System.out.println("start setup");

		config = new LogConfig();
	}

	@Test
	void testLoadPropertyString() {
		System.out.println("start testLoadPropertyString");

		config.loadProperty(PROPERTY_NAME);
	}

	@Test
	void testLoadProperty() {
		System.out.println("start testLoadProperty");

		config.loadProperty();
	}

	@Test
	void testGetProperty() {
		System.out.println("start testGetProperty");

		config.loadProperty(PROPERTY_NAME);
		String format = config.getProperty("format");
		System.out.println("format=" + format);

		assertNotNull(format);
		assertNotEquals(format, "");
	}

	@Test
	void testSetProperty() {
		System.out.println("start testSetProperty");

		String val = "value";
		config.setProperty("prop", val);
		String prop = config.getProperty("prop");
		System.out.println("prop=" + prop);

		assertNotNull(prop);
		assertEquals(prop, val);
	}

}
