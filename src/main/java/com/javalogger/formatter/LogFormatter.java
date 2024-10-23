package com.javalogger.formatter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.javalogger.config.Config;

public class LogFormatter implements Formatter {
	private String format;
	private Config config;

	public LogFormatter(String format, Config config) {
		this.setFormat(format);
		this.config = config;
	}

	@Override
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String getFormat() {
		return this.format;
	}

	@Override
	public String getFormattedMessage(String message) {
		// Define strings related to dates
		Calendar c = Calendar.getInstance();
		Date date = c.getTime();

		// Get today
		SimpleDateFormat todayFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today = todayFormat.format(date);

		// Get the current time
		SimpleDateFormat nowFormat = new SimpleDateFormat("HH:mm:ss");
		String now = nowFormat.format(date);

		// Build a formatted message if the format is not empty.
		if (this.format != null || this.format.isEmpty()) {
			String formatted = this.format;
			formatted = formatted.replace("%m", message);
			formatted = formatted.replaceAll("%d", today);
			formatted = formatted.replaceAll("%t", now);
			formatted = formatted.replaceAll("%c", config.getProperty("classname"));
			return formatted;

			// Just return the message.
		} else {
			return message;
		}

	}

}
