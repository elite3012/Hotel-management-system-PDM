package com.code.hms.loginwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpWindow extends JFrame {

    static JTextField firstNameField;
    static JTextField lastNameField;
    static JTextField dateOfBirthField;
    static JTextField idNumberField;
    static JTextField nationalityField;
    static JTextField addressField;
    static JTextField phoneNumberField;
    static JTextField emailField;
    static JTextField usernameField;
    static JTextField roleField;

    static JPasswordField passwordField;
    static JPasswordField confirmPasswordField;

    static JLabel firstNameLabel;
    static JLabel lastNameLabel;
    static JLabel dateOfBirthLabel;
    static JLabel idNumberLabel;
    static JLabel nationalityLabel;
    static JLabel addressLabel;
    static JLabel phoneNumberLabel;
    static JLabel emailLabel;
    static JLabel usernameLabel;
    static JLabel passwordLabel;
    static JLabel confirmPasswordLabel;
    static JLabel roleLabel;

    static JButton signInButton;

    public SignUpWindow() {
        setTitle("Sign Up");
        setSize(1280, 672);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Background
        LoadImage loader = new LoadImage("hms/bg img/bg.png", getWidth(), getHeight());
        JLabel backgroundLbl = new JLabel(loader.getImageIcon());
        backgroundLbl.setBounds(0, 0, getWidth(), getHeight());
        panel.add(backgroundLbl);

        JPanel signUpPanel = new JPanel();
        signUpPanel.setLayout(null);
        signUpPanel.setBackground(new Color(0, 0, 0, 150));
        signUpPanel.setBounds(0, 0, 1280, 672);

        // Add components
        int x1 = 175, x2 = 755, y = 100, width = 350, height = 40, gap = 70;

        // First Name and Last Name
        JLabel firstNameLbl = createLabel("First Name:", x1, y);
        firstNameField = createTextField(x1, y + 20, width, height);
        JLabel lastNameLbl = createLabel("Last Name:", x2, y);
        lastNameField = createTextField(x2, y + 20, width, height);

        // Date of Birth and Identification Number
        y += gap;
        JLabel dobLbl = createLabel("Date of Birth:", x1, y);
        dateOfBirthField = createTextField(x1, y + 20, width, height);
        JLabel idLbl = createLabel("Identification Number:", x2, y);
        idNumberField = createTextField(x2, y + 20, width, height);

        // Nationality and Address
        y += gap;
        JLabel nationalityLbl = createLabel("Nationality:", x1, y);
        nationalityField = createTextField(x1, y + 20, width, height);
        JLabel addressLbl = createLabel("Address:", x2, y);
        addressField = createTextField(x2, y + 20, width, height);

        // Phone Number and Email
        y += gap;
        JLabel phoneLbl = createLabel("Phone Number:", x1, y);
        phoneNumberField = createTextField(x1, y + 20, width, height);
        JLabel emailLbl = createLabel("Email:", x2, y);
        emailField = createTextField(x2, y + 20, width, height);

        // Username and Password
        y += gap;
        JLabel usernameLbl = createLabel("Username:", x1, y);
        usernameField = createTextField(x1, y + 20, width, height);
        JLabel passwordLbl = createLabel("Password:", x2, y);
        passwordField = new JPasswordField();
        passwordField.setBounds(x2, y + 20, width, height);

        // Confirm Password and Role
        y += gap;
        JLabel confirmPasswordLbl = createLabel("Confirm Password:", x1, y);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(x1, y + 20, width, height);
        JLabel roleLbl = createLabel("Role:", x2, y);
        roleField = createTextField(x2, y + 20, width, height);

        // Sign-Up Button
        y += gap;
        JButton signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(490, y + 30, 300, 50);
        signUpButton.setBackground(Color.decode("#847966"));
        signUpButton.setForeground(Color.WHITE);

        // Add components to the sign-up panel
        signUpPanel.add(firstNameLbl);
        signUpPanel.add(firstNameField);
        signUpPanel.add(lastNameLbl);
        signUpPanel.add(lastNameField);
        signUpPanel.add(dobLbl);
        signUpPanel.add(dateOfBirthField);
        signUpPanel.add(idLbl);
        signUpPanel.add(idNumberField);
        signUpPanel.add(nationalityLbl);
        signUpPanel.add(nationalityField);
        signUpPanel.add(addressLbl);
        signUpPanel.add(addressField);
        signUpPanel.add(phoneLbl);
        signUpPanel.add(phoneNumberField);
        signUpPanel.add(emailLbl);
        signUpPanel.add(emailField);
        signUpPanel.add(usernameLbl);
        signUpPanel.add(usernameField);
        signUpPanel.add(passwordLbl);
        signUpPanel.add(passwordField);
        signUpPanel.add(confirmPasswordLbl);
        signUpPanel.add(confirmPasswordField);
        signUpPanel.add(roleLbl);
        signUpPanel.add(roleField);
        signUpPanel.add(signUpButton);

        // Add panels to the frame
        add(signUpPanel);
        add(panel);


    public static void main(String[] args) {
        new SignUpWindow().setVisible(true);

    }

}
