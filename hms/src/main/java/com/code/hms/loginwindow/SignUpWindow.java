package com.code.hms.loginwindow;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class SignUpWindow extends JFrame {

    private JTextField firstNameField, lastNameField, dateOfBirthField, idNumberField, nationalityField, addressField, phoneNumberField, emailField, usernameField;
    private JPasswordField passwordField, confirmPasswordField;
    private JComboBox<String> roleDropdown;

    public SignUpWindow() {
        setTitle("Sign Up");
        setSize(1280, 672);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Background
        LoadImage loader = new LoadImage("hms/src/main/java/com/code/hms/assets/bg.png", getWidth(), getHeight());
        JLabel backgroundLbl = new JLabel(loader.getImageIcon());
        backgroundLbl.setBounds(0, 0, getWidth(), getHeight());
        panel.add(backgroundLbl);

        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(null);
        signUpPanel.setBackground(new Color(0, 0, 0, 150));
        signUpPanel.setBounds(50, 50, 1180, 572);
        backgroundLbl.add(signUpPanel);

        // Component Coordinates
        int x1 = 75, x2 = 600, y = 50, width = 350, height = 30, gap = 50;

        // First Name and Last Name
        addFieldWithLabel("First Name:", x1, y, width, height, signUpPanel);
        firstNameField = addTextField(x1, y + 25, width, height, signUpPanel);
        addFieldWithLabel("Last Name:", x2, y, width, height, signUpPanel);
        lastNameField = addTextField(x2, y + 25, width, height, signUpPanel);

        // Date of Birth and Identification Number
        y += gap;
        addFieldWithLabel("Date of Birth:", x1, y, width, height, signUpPanel);
        dateOfBirthField = addTextField(x1, y + 25, width, height, signUpPanel);
        addFieldWithLabel("ID Number:", x2, y, width, height, signUpPanel);
        idNumberField = addTextField(x2, y + 25, width, height, signUpPanel);

        // Nationality and Address
        y += gap;
        addFieldWithLabel("Nationality:", x1, y, width, height, signUpPanel);
        nationalityField = addTextField(x1, y + 25, width, height, signUpPanel);
        addFieldWithLabel("Address:", x2, y, width, height, signUpPanel);
        addressField = addTextField(x2, y + 25, width, height, signUpPanel);

        // Phone Number and Email
        y += gap;
        addFieldWithLabel("Phone Number:", x1, y, width, height, signUpPanel);
        phoneNumberField = addTextField(x1, y + 25, width, height, signUpPanel);
        addFieldWithLabel("Email:", x2, y, width, height, signUpPanel);
        emailField = addTextField(x2, y + 25, width, height, signUpPanel);

        // Username and Password
        y += gap;
        addFieldWithLabel("Username:", x1, y, width, height, signUpPanel);
        usernameField = addTextField(x1, y + 25, width, height, signUpPanel);
        addFieldWithLabel("Password:", x2, y, width, height, signUpPanel);
        passwordField = new JPasswordField();
        passwordField.setBounds(x2, y + 25, width, height);
        signUpPanel.add(passwordField);

        // Confirm Password and Role
        y += gap;
        addFieldWithLabel("Confirm Password:", x1, y, width, height, signUpPanel);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(x1, y + 25, width, height);
        signUpPanel.add(confirmPasswordField);
        addFieldWithLabel("Role:", x2, y, width, height, signUpPanel);
        roleDropdown = new JComboBox<>(new String[]{"Customer", "Admin", "Receptionist"});
        roleDropdown.setBounds(x2, y + 25, width, height);
        signUpPanel.add(roleDropdown);

        // Sign-Up Button
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(440, y + 75, 300, 40);
        signUpButton.setBackground(Color.decode("#847966"));
        signUpButton.setForeground(Color.WHITE);
        signUpPanel.add(signUpButton);

        // Action Listener
        signUpButton.addActionListener(e -> validateAndSubmitForm());

        add(panel);
    }

    private void validateAndSubmitForm() {
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled!", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Sign-Up successful for: " + username, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private JLabel addFieldWithLabel(String text, int x, int y, int width, int height, JPanel panel) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setForeground(Color.WHITE);
        panel.add(label);
        return label;
    }

    private JTextField addTextField(int x, int y, int width, int height, JPanel panel) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        panel.add(textField);
        return textField;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SignUpWindow().setVisible(true));
    }
}