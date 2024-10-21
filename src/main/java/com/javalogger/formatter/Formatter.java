package com.javalogger.formatter;

public interface Formatter {
	public void setFormat(String format);
	public String getFormat();
	public String getFormattedMessage(String message);
}
