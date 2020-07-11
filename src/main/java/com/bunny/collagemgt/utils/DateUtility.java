package com.bunny.collagemgt.utils;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtility {
	private DateUtility() {
	}

	public static LocalDateTime todayDateTime() {
		return LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
	}

	public static String DateTimeMethod() {
		return DateUtility.todayDateTime().format(DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss"));
	}
}
