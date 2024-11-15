package com.code.hms.connection.loginwindow;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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

        // Background label
        LoadImage loader = new LoadImage("hms/bg img/bg.png", getWidth(), getHeight());
        JLabel backgroundLbl = new JLabel(loader.getImageIcon());
        backgroundLbl.setBounds(0, 0, getWidth(), getHeight());
        panel.add(backgroundLbl);

        // Black semi-transparent login panel
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBackground(new Color(0, 0, 0, 150));
        loginPanel.setBounds(0, 0, 500, getHeight());

        // Add components
        usernameLbl = new JLabel("Username:");
        usernameLbl.setBounds(100, 50, 300, 50);
        usernameLbl.setForeground(Color.WHITE);
        usernameField = new JTextField();
        usernameField.setBounds(100, 100, 300, 50);

        passwordLbl = new JLabel("Password:");
        passwordLbl.setBounds(100, 150, 300, 50);
        passwordLbl.setForeground(Color.WHITE);
        passwordField = new JPasswordField();
        passwordField.setBounds(100, 200, 300, 50);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 300, 300, 50);
        loginButton.setBackground(Color.decode("#847966"));
        loginButton.setForeground(Color.WHITE);

        forgotPasswordButton = new JLabel("Forgot Password");
        forgotPasswordButton.setBounds(250 - forgotPasswordButton.getPreferredSize().width / 2, 400, forgotPasswordButton.getPreferredSize().width, 50);
        forgotPasswordButton.setForeground(Color.YELLOW);

        signUpButton = new JLabel("Sign Up");
        signUpButton.setBounds(250 - signUpButton.getPreferredSize().width / 2, 500, signUpButton.getPreferredSize().width, 50);
        signUpButton.setForeground(Color.YELLOW);

        loginPanel.add(usernameLbl);
        loginPanel.add(usernameField);
        loginPanel.add(passwordLbl);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.add(forgotPasswordButton);
        loginPanel.add(signUpButton);

        add(loginPanel);
        add(panel);

        // Add ActionListener for buttons
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                JOptionPane.showMessageDialog(null, "Login attempt for: " + username);
            }
        });

        forgotPasswordButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Forgot Password clicked");
            }
        });

        signUpButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(null, "Sign Up clicked");
            }
        });
    }

    public static void main(String[] args) {
        new LoginWindow().setVisible(true);
        System.out.println(forgotPasswordButton.getWidth());
        System.out.println(signUpButton.getWidth());
    }
}
