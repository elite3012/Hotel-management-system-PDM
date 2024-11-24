package com.code.hms.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingEngine {

    private static volatile LoggingEngine instance = null;
    private static Logger logger;
    private static FileHandler fileHandler;
    private static LoggingFormatter formatter;
    private static Path logDirectory;
    private static Path logFilePath;

    // Private constructor to prevent instantiation
    private LoggingEngine() {}

    // Thread-safe singleton getter
    public static LoggingEngine getInstance() {
        if (instance == null) {
            synchronized (LoggingEngine.class) {
                if (instance == null) {
                    instance = new LoggingEngine();
                }
            }
        }
        return instance;
    }

    public void setReady(String className) {
        final String path = System.getProperty("user.dir");
        logger = Logger.getLogger(className);

        try {
            // Create logging directory and subdirectory based on current year/month
            String logDirectoryPath = path + File.separator + "Logging Store" + File.separator
                    + LocalDate.now().getYear() + File.separator + LocalDate.now().getMonthValue();
            logDirectory = Paths.get(logDirectoryPath);

            if (!Files.exists(logDirectory)) {
                Files.createDirectories(logDirectory);
            }

            // Create a log file for the current date
            String today = LocalDate.now().toString();
            logFilePath = Paths.get(logDirectory.toString() + File.separator + "Logging_" + today + ".log");

            if (!Files.exists(logFilePath)) {
                Files.createFile(logFilePath);
            }

            // Initialize file handler
            fileHandler = new FileHandler(logFilePath.toString(), true);
            logger.addHandler(fileHandler);

            // Set the custom log formatter
            formatter = new LoggingFormatter();
            fileHandler.setFormatter(formatter);

            // Set default logging level
            logger.setLevel(Level.INFO);
        } catch (SecurityException | IOException e) {
            // Log the exception itself
            e.printStackTrace();
            if (logger != null) {
                logger.log(Level.SEVERE, "Failed to set up logging", e);
            }
        }
    }

    public void setMessage(String message) {
        if (logger != null) {
            logger.info(message);
        }
    }

    public void setConsoleLogging(boolean status) {
        if (logger != null) {
            logger.setUseParentHandlers(status);
        }
    }

    public void changeLoggingLevel(Level level) {
        if (logger != null) {
            logger.setLevel(level);
        }
    }

    // Close resources (like FileHandler) when the application shuts down
    public void closeLogging() {
        if (fileHandler != null) {
            fileHandler.close();
        }
    }
}