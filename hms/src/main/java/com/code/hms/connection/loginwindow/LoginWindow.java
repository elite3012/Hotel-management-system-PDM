package com.code.hms.connection.loginwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginWindow extends JFrame {
    static JTextField usernameField;
    static JPasswordField passwordField;
    static JLabel usernameLbl, passwordLbl;
    static JButton loginButton;
    static JLabel forgotPasswordButton, signUpButton;

    public LoginWindow(GraphicsConfiguration gc) {
        super(gc);
    }

    public LoginWindow() {

        // Set up frame
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

        forgotPasswordButton = new JLabel("Forgot Password");
        forgotPasswordButton.setBounds(200, 400, 100, 50);
        forgotPasswordButton.setForeground(Color.ORANGE);

        signUpButton = new JLabel("Sign Up");
        signUpButton.setBounds(200, 500, 100, 50);
        signUpButton.setForeground(Color.ORANGE);

        panel.add(usernameLbl);
        panel.add(usernameField);
        panel.add(passwordLbl);
        panel.add(passwordField);
        panel.add(loginButton);
        panel.add(forgotPasswordButton);
        panel.add(signUpButton);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                JOptionPane.showMessageDialog(null, "Login attempt for: " + username);
            }
        });
    }

    public static void main(String[] args) {
        new LoginWindow().setVisible(true);
    }
}
