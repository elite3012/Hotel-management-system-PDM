package com.code.hms.utils;

import java.util.Random;

public class ForgotPassword {

    private static final int CODE_LENGTH = 6; // Length of the reset code
    private static final String EMAIL_SUBJECT = "Password Reset Code";

    /**
     * Generates a random numeric reset code.
     *
     * @return A random numeric code as a String.
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
     * Sends a password reset code to the user's email address.
     *
     * @param userEmail The user's email address.
     */
    public void sendPasswordResetCode(String userEmail) {
        // Generate the reset code
        String resetCode = generateResetCode();

        // Prepare the email body
        String emailBody = "Your password reset code is: " + resetCode;

        // Send the email
        EmailSending.sendSimpleEmail(userEmail, EMAIL_SUBJECT, emailBody);

        // Log the action
        LoggingEngine logger = LoggingEngine.getInstance();
        logger.setReady(ForgotPassword.class.getName());
        logger.setMessage("Password reset code sent to " + userEmail + ": " + resetCode);
    }

    public static void main(String[] args) {
        // Example usage
        ForgotPassword forgotPasswordUtility = new ForgotPassword();
        forgotPasswordUtility.sendPasswordResetCode("user@example.com");
    }
}