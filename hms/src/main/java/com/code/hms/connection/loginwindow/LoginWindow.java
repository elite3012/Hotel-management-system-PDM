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
    }
}
