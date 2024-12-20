package main.java.edu.time.manager.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

    // Convert LocalDateTime to String
    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }

    // Convert String to LocalDateTime
    public static LocalDateTime parseDateTime(String dateTimeStr) {
        return LocalDateTime.parse(dateTimeStr, formatter);
    }
}

