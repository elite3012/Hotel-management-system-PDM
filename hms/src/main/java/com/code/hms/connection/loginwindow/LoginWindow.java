package com.code.hms.connection.loginwindow;

import javax.swing.*;

public class LoginWindow extends JFrame {
    static JTextField usernameField;
    static JPasswordField passwordField;
    static JLabel usernameLbl, passwordLbl;
    static JButton loginButton;
    static JLabel forgotPasswordButton, signUpButton;

    public LoginWindow() {

        //set up frame
        setTitle("Login");
        setSize(1280, 672);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Add components
        usernameLbl = new JLabel("Username:");
        usernameLbl.setBounds(100, 50, 300, 50);
        usernameField = new JTextField();
        usernameField.setBounds(100, 100, 300, 50);

        passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(100, 150, 300, 50);
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 200, 300, 50);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 300, 300, 50);
    }
}
