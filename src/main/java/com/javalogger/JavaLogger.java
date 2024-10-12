package com.javalogger;

import com.javalogger.context.Context;

public class JavaLogger {
	private static Context context;
	
	public static void print(String message) {
		context.print(message);
	}
	
	public static void println(String message) {
		context.println(message);
	}
}
