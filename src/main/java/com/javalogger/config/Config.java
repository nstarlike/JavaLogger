package com.javalogger.config;

public interface Config {
	public void loadProperty(String propertyName);
	public void loadProperty();
	public String getProperty(String key);
	public void setProperty(String key, String value);
}
