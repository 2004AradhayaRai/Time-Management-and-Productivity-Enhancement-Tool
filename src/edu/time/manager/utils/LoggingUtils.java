package edu.time.manager.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingUtils {
    private static final Logger logger = Logger.getLogger(LoggingUtils.class.getName());

    static {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
    }

    // Log info level messages
    public static void logInfo(String message) {
        logger.info(message);
    }

    // Log warning level messages
    public static void logWarning(String message) {
        logger.warning(message);
    }

    // Log error level messages
    public static void logError(String message) {
        logger.severe(message);
    }
}

