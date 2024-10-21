package com.javalogger;

import com.javalogger.context.Context;
import com.javalogger.context.LogContext;

public class JavaLogger {
	private Class<?> c;
	private Context context;
	
	public JavaLogger(Class<?> c) {
		this.c = c;
		this.context = new LogContext(c);
	}
	
	public void print(String message) {
		context.print(message);
	}
	
	public void println(String message) {
		context.println(message);
	}
	
}
