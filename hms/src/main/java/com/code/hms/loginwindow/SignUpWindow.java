package com.code.hms.loginwindow;

import javax.swing.*;
import java.awt.*;


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

}
