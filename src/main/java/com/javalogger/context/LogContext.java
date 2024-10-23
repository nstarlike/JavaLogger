package com.javalogger.context;

import com.javalogger.appender.Appender;
import com.javalogger.appender.ConsoleAppender;
import com.javalogger.config.Config;
import com.javalogger.config.LogConfig;
import com.javalogger.formatter.Formatter;
import com.javalogger.formatter.LogFormatter;

public class LogContext implements Context {
	private Class<?> source;
	private Config config;
	private Appender appender;
	private Formatter formatter;
	
	public LogContext(Class<?> source) {
		this.source = source;
		
		// Load configurations
		this.config = new LogConfig();
		this.config.loadProperty();
		this.config.setProperty("classname", source.getName());
		
		this.appender = new ConsoleAppender();
		
		// Set the format of messages
		String format = this.config.getProperty("format");
		if(format == null || format.isBlank()) {
			format = "[%d %t] %m";
		}
		this.formatter = new LogFormatter(format, config);
	}
	
	@Override
	public void print(String message) {
		String formattedMessage = this.formatter.getFormattedMessage(message);
		this.appender.print(formattedMessage);
	}

	@Override
	public void println(String message) {
		String formattedMessage = this.formatter.getFormattedMessage(message);
		this.appender.println(formattedMessage);
	}

}
