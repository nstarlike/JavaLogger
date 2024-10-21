package com.javalogger.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LogConfig implements Config {
	private Properties props;
	
	public LogConfig() {
		this.props = new Properties();
	}
	
	@Override
	public void loadProperty(String fileName) {
		// Load properties from the file.
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		InputStream is = loader.getResourceAsStream(fileName);
		
		try {
			this.props.load(is);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void loadProperty() {
		this.loadProperty("JavaLogger.properties");
	}
	
	@Override
	public String getProperty(String key) {
		if(this.props.containsKey(key)) {
			return this.props.getProperty(key);
		}else {
			return "";
		}
	}
	
	@Override
	public void setProperty(String key, String value) {
		props.setProperty(key, value);
	}
}
