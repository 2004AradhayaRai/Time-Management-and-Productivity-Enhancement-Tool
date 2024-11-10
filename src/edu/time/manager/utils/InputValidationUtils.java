package edu.time.manager.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidationUtils {

    // Validate email address
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // Check if a string is non-empty
    public static boolean isNonEmpty(String input) {
        return input != null && !input.trim().isEmpty();
    }

    // Validate that a date string is in the correct format (YYYY-MM-DD)
    public static boolean isValidDateFormat(String date) {
        try {
            DateTimeUtils.parseDateTime(date);  // If this doesn't throw an exception, the format is valid
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

