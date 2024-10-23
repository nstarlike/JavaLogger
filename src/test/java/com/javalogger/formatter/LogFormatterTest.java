package com.javalogger.formatter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.text.SimpleDateFormat;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import com.javalogger.config.Config;
import com.javalogger.config.LogConfig;

class LogFormatterTest {
	private static LogFormatter formatter;
	
	@BeforeAll
	static void setupt() {
		String format = "%d %t %c %m";
		Config config = new LogConfig();
		config.setProperty("classname", LogFormatterTest.class.getName());
		config.setProperty("format", format);
		formatter = new LogFormatter(format, config);
	}

	@Test
	void testSetGetFormat() {
		String format = "%d %t %m";
		formatter.setFormat(format);
		
		assertEquals(formatter.getFormat(), format);
	}

	@Test
	void testGetFormattedMessage() {
		String format = "%d %t %c %m";
		String msg = "test";
		
		formatter.setFormat(format);
		String formatted = formatter.getFormattedMessage(msg);
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = sdf.format(c.getTime());
		assertEquals(formatted, dateTime + " " + LogFormatterTest.class.getName() + " " + msg);
	}

}
