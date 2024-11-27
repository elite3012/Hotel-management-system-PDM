package com.code.hms.connection;

import java.awt.Dialog.ModalExclusionType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.ibatis.common.jdbc.ScriptRunner;

public class DatabaseServerPreparingInitializer extends JFrame {

    private static final long serialVersionUID = 1L;
    private static File file;
    private boolean status = false;

    public DatabaseServerPreparingInitializer() {
        setType(Type.POPUP);
        setResizable(false);
        this.setAlwaysOnTop(isAlwaysOnTopSupported());
        setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
        this.pack();
    }

    /**
     * Method to run the SQL script for initializing the database.
     */
    public void runScriptFile() {
        final String sqlFilePath = "hms/src/main/java/com/code/hms/connection/hms.sql"; // Path to SQL file
        final String DB_DRIVER = "com.mysql.cj.jdbc.Driver"; // JDBC Driver for MySQL
        final String DB_CONNECTION = "jdbc:mysql://localhost:3306/"; // Connection URL for MySQL

        // Prompt for database credentials from the user
        String DB_USER = JOptionPane.showInputDialog(this, "Enter your database username:", "Coder HMS [Input]", JOptionPane.QUESTION_MESSAGE);
        String DB_PASSWORD = JOptionPane.showInputDialog(this, "Enter your database password:", "Coder HMS [Input]", JOptionPane.QUESTION_MESSAGE);

        try {
            // Load the JDBC driver class
            Class.forName(DB_DRIVER);
            // Establish the connection to the database
            Connection connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

            // Create a ScriptRunner to execute the SQL file
            ScriptRunner runner = new ScriptRunner(connection, false, false); // No auto-commit and no verbose output
            Reader br = new BufferedReader(new FileReader(sqlFilePath)); // Read the SQL script from the file

            // Execute the script
            runner.runScript(br);
            status = true; // Set the status to true if the script runs successfully

        } catch (SQLException | ClassNotFoundException | IOException ex) {
            status = false; // Set the status to false if an error occurs
            ex.printStackTrace(); // Log the exception for debugging
            JOptionPane.showMessageDialog(this, "Error occurred while executing SQL script: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Method to get the log file if it exists.
     * 
     * @return the log file
     */
    public static File getLogFile() {
        if (file.exists()) {
            return DatabaseServerPreparingInitializer.file;
        }
        return null; // Return null if the log file doesn't exist
    }

    /**
     * Method to get the status of the script execution.
     * 
     * @return true if the script ran successfully, false otherwise
     */
    public boolean getStatus() {
        return this.status;
    }

	public static void main(String[] args) {
        // Initialize the database and run the script
        DatabaseServerPreparingInitializer initializer = new DatabaseServerPreparingInitializer();
        initializer.runScriptFile();

        // Check if the script executed successfully
        if (initializer.getStatus()) {
            System.out.println("Database initialized successfully.");
        } else {
            System.out.println("Database initialization failed.");
        }
    }
}
