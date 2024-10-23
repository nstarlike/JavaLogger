package com.javalogger.appender;

public class ConsoleAppender implements Appender {

	@Override
	public void print(String message) {
		System.out.print(message);
	}

	@Override
	public void println(String message) {
		System.out.println(message);
	}

}
