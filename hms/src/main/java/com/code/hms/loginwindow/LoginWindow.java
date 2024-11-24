package com.code.hms.loginwindow;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginWindow extends JFrame {
    static JTextField usernameField;
    static JPasswordField passwordField;

    public LoginWindow() {
        setTitle("Login");
        setSize(1280, 672);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create panel
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Background
        LoadImage loader = new LoadImage("hms/assets/bg.png", getWidth(), getHeight());
        JLabel backgroundLbl = new JLabel(loader.getImageIcon());
        backgroundLbl.setBounds(0, 0, getWidth(), getHeight());
        panel.add(backgroundLbl);

        // Login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(0, 0, 0, 150));
        loginPanel.setBounds(0, 0, 500, getHeight());
        backgroundLbl.add(loginPanel);

        // Username
        JLabel usernameLbl = new JLabel("Username:");
        usernameLbl.setBounds(100, 50, 300, 30);
        usernameLbl.setForeground(Color.WHITE);
        loginPanel.add(usernameLbl);

        usernameField = new JTextField();
        usernameField.setBounds(100, 80, 300, 40);
        loginPanel.add(usernameField);

        // Password
        JLabel passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(100, 150, 300, 30);
        passwordLbl.setForeground(Color.WHITE);
        loginPanel.add(passwordLbl);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 180, 300, 40);
        loginPanel.add(passwordField);

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 250, 300, 40);
        loginButton.setBackground(Color.decode("#847966"));
        loginButton.setForeground(Color.WHITE);
        loginPanel.add(loginButton);

        // Forgot Password
        JLabel forgotPasswordButton = new JLabel("Forgot Password");
        forgotPasswordButton.setForeground(Color.YELLOW);
        forgotPasswordButton.setBounds(100, 320, 300, 30);
        forgotPasswordButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginPanel.add(forgotPasswordButton);

        // Sign-Up
        JLabel signUpButton = new JLabel("Sign Up");
        signUpButton.setForeground(Color.YELLOW);
        signUpButton.setBounds(100, 350, 300, 30);
        signUpButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loginPanel.add(signUpButton);

        // Login logic
        loginButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();

            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Username or Password cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Login attempt for: " + username);
            }
        });

        // Forgot Password navigation
        forgotPasswordButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ForgotPasswordWindow().setVisible(true);
                dispose();
            }
        });

        // Sign-Up navigation
        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Redirecting to Sign-Up...");
            }
        });

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginWindow().setVisible(true));
    }
}
