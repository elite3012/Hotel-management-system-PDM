package com.code.hms.utils;

import java.util.Random;

public class ForgotPassword {

    private static final int CODE_LENGTH = 6; // Length of the reset code
    private static final String EMAIL_SUBJECT = "Password Reset Code";
    private String generatedResetCode = null; // Store the generated reset code
    private long codeGenerationTime = 0; // Store the time when the reset code was generated

    /**
     * Generates a random reset code.
     * 
     * @return The generated reset code as a string.
     */
    private String generateResetCode() {
        Random random = new Random();
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(random.nextInt(10)); // Generate a digit between 0-9
        }
        return code.toString();
    }

    /**
     * Sends the password reset code to the user's email address.
     *
     * @param userEmail The user's email address.
     */
    public void sendPasswordResetCode(String userEmail) {
        // Generate the reset code
        String resetCode = generateResetCode();
        this.generatedResetCode = resetCode;  // Store the generated reset code
        this.codeGenerationTime = System.currentTimeMillis();  // Store the time of code generation

        // Prepare the email body
        String emailBody = "Your password reset code is: " + resetCode;

        // Send the email
        EmailSending.sendSimpleEmail(userEmail, EMAIL_SUBJECT, emailBody);

        // Log the action (you can also log this to a database or file)
        LoggingEngine logger = LoggingEngine.getInstance();
        logger.setReady(ForgotPassword.class.getName());
        logger.setMessage("Password reset code sent to " + userEmail + ": " + resetCode);
    }

    /**
     * Validates the reset code.
     * 
     * @param inputCode The code entered by the user.
     * @return true if the input code matches the generated code and is within a valid time window.
     */
    public boolean isValidResetCode(String inputCode) {
        // Check if the reset code matches and if it was generated within the last 10 minutes
        long currentTime = System.currentTimeMillis();
        boolean isValidCode = inputCode.equals(generatedResetCode) && (currentTime - codeGenerationTime) <= 10 * 60 * 1000;

        return isValidCode;
    }

    public static void main(String[] args) {
        // Example usage
        ForgotPassword forgotPasswordUtility = new ForgotPassword();

        // 1. Send the reset code to the user's email
        forgotPasswordUtility.sendPasswordResetCode("user@example.com");

    }
}
